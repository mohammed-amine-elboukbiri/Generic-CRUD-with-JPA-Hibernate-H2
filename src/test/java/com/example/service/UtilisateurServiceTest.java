package com.example.service;

import com.example.model.Utilisateur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class UtilisateurServiceTest {

    private EntityManagerFactory emf;
    private UtilisateurService service;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("gestion-salles");
        service = new UtilisateurService(emf);
    }

    @After
    public void tearDown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    @Test
    public void testCrudOperations() {
        Utilisateur utilisateur = new Utilisateur("Amine", "ELBOUKBIRI", "amineELBOUKBIRI@gmail.com");
        utilisateur.setDateNaissance_utilisateur(LocalDate.of(2005, 6, 8));
        utilisateur.setTelephone_utilisateur("0644107539");

        Utilisateur savedUtilisateur = service.save(utilisateur);
        assertNotNull(savedUtilisateur.getId_utilisateur());

        Optional<Utilisateur> foundUtilisateur = service.findById(savedUtilisateur.getId_utilisateur());
        assertTrue(foundUtilisateur.isPresent());
        assertEquals("Amine", foundUtilisateur.get().getNom_utilisateur());

        Utilisateur toUpdate = foundUtilisateur.get();
        toUpdate.setNom_utilisateur("Updated");
        service.update(toUpdate);

        Optional<Utilisateur> updatedUtilisateur = service.findById(savedUtilisateur.getId_utilisateur());
        assertTrue(updatedUtilisateur.isPresent());
        assertEquals("Updated", updatedUtilisateur.get().getNom_utilisateur());

        service.delete(updatedUtilisateur.get());
        Optional<Utilisateur> deletedUtilisateur = service.findById(savedUtilisateur.getId_utilisateur());
        assertFalse(deletedUtilisateur.isPresent());
    }

    @Test
    public void testFindByEmail() {
        Utilisateur utilisateur = new Utilisateur("Akram", "Arab", "akramArab@gmail.com");
        service.save(utilisateur);

        Optional<Utilisateur> foundUtilisateur = service.findByEmail("akramArab@gmail.com");
        assertTrue(foundUtilisateur.isPresent());
        assertEquals("Akram", foundUtilisateur.get().getNom_utilisateur());

        Optional<Utilisateur> notFound = service.findByEmail("nonexistent@gmail.com");
        assertFalse(notFound.isPresent());

        service.delete(foundUtilisateur.get());
    }

    @Test
    public void testFindAll() {

        Utilisateur u1 = new Utilisateur("Saad", "Akil", "saadAkil@gmail.com");
        Utilisateur u2 = new Utilisateur("Ziad", "Sadiq", "ziadSadiq@gmail.com");
        service.save(u1);
        service.save(u2);

        List<Utilisateur> utilisateurs = service.findAll();
        assertTrue(utilisateurs.size() >= 2);

        service.delete(u1);
        service.delete(u2);
    }
}
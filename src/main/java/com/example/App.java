package com.example;

import com.example.model.Salle;
import com.example.model.Utilisateur;
import com.example.service.SalleService;
import com.example.service.UtilisateurService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion-salles");

        UtilisateurService utilisateurService = new UtilisateurService(emf);
        SalleService salleService = new SalleService(emf);

        try {
            System.out.println("\n===== Test CRUD de l'Utilisateur =====");
            testCrudUtilisateur(utilisateurService);

            System.out.println("\n===== Test CRUD de Salle =====");
            testCrudSalle(salleService);

        } finally {
            emf.close();
        }
    }

    private static void testCrudUtilisateur(UtilisateurService service) {
        System.out.println("Création d'utilisateurs...");
        Utilisateur u1 = new Utilisateur("Ilyass", "Sekhsoukhi", "ilyassSekhsoukhi@gmail.com");
        u1.setDateNaissance_utilisateur(LocalDate.of(2005, 8, 5));
        u1.setTelephone_utilisateur("0675768329");

        Utilisateur u2 = new Utilisateur("Ayoub", "Bahla", "ayoubBahla@gmail.com");
        u2.setDateNaissance_utilisateur(LocalDate.of(2004, 10, 4));
        u2.setTelephone_utilisateur("0673829175");

        service.save(u1);
        service.save(u2);

        System.out.println("\nLecture de tous les utilisateurs :");
        List<Utilisateur> utilisateurs = service.findAll();
        utilisateurs.forEach(System.out::println);

        System.out.println("\nRecherche d'un utilisateur par ID :");
        Optional<Utilisateur> utilisateurOpt = service.findById(1L);
        utilisateurOpt.ifPresent(System.out::println);

        System.out.println("\nRecherche d'un utilisateur par email :");
        Optional<Utilisateur> utilisateurParEmail = service.findByEmail("ayoubBahla@gmail.com");
        utilisateurParEmail.ifPresent(System.out::println);

        System.out.println("\nMise à jour d'un utilisateur :");
        utilisateurOpt.ifPresent(utilisateur -> {
            utilisateur.setTelephone_utilisateur("0777459175");
            service.update(utilisateur);
            System.out.println("Utilisateur mis à jour : " + utilisateur);
        });

        System.out.println("\nSuppression d'un utilisateur :");
        service.deleteById(2L);
        System.out.println("Utilisateur avec ID=2 supprimé");

        System.out.println("\nListe des utilisateurs après suppression :");
        service.findAll().forEach(System.out::println);
    }

    private static void testCrudSalle(SalleService service) {

        System.out.println("Création de salles...");
        Salle s1 = new Salle("Salle de sport", 30);
        s1.setDescription_salle("Salle de sport équipée des meilleur machine de sport");
        s1.setEtage_salle(1);

        Salle s2 = new Salle("salle d'informatique", 150);
        s2.setDescription_salle("Grand salle pour etude d'informatique");
        s2.setEtage_salle(2);

        Salle s3 = new Salle("Salle de soutien", 20);
        s3.setDescription_salle("Petite salle pour les cours de soutien");
        s3.setEtage_salle(3);
        s3.setDisponible_salle(false);

        service.save(s1);
        service.save(s2);
        service.save(s3);


        System.out.println("\nLecture de toutes les salles :");
        List<Salle> salles = service.findAll();
        salles.forEach(System.out::println);

        System.out.println("\nRecherche d'une salle par ID :");
        Optional<Salle> salleOpt = service.findById(2L);
        salleOpt.ifPresent(System.out::println);

        System.out.println("\nRecherche des salles disponibles :");
        List<Salle> sallesDisponibles = service.findByDisponible(true);
        sallesDisponibles.forEach(System.out::println);

        System.out.println("\nRecherche des salles avec capacité minimum de 50 :");
        List<Salle> sallesGrandes = service.findByCapaciteMinimum(50);
        sallesGrandes.forEach(System.out::println);


        System.out.println("\nMise à jour d'une salle :");
        salleOpt.ifPresent(salle -> {
            salle.setCapacite_salle(200);
            service.update(salle);
            System.out.println("Salle mise à jour : " + salle);
        });


        System.out.println("\nSuppression d'une salle :");
        service.deleteById(3L);
        System.out.println("Salle avec ID=3 supprimée");

        System.out.println("\nListe des salles après suppression :");
        service.findAll().forEach(System.out::println);
    }
}
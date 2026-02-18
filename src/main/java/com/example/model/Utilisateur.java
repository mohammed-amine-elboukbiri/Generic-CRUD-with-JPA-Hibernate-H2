package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_utilisateur;

    @NotBlank(message = "Le nom est nécessaire")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    @Column(nullable = false)
    private String nom_utilisateur;

    @NotBlank(message = "Le prénom est nécessaire")
    @Size(min = 2, max = 50, message = "Le prénom doit contenir entre 2 et 50 caractères")
    @Column(nullable = false)
    private String prenom_utilisateur;

    @NotBlank(message = "L'email est nécessaire")
    @Email(message = "Format d'email invalide")
    @Column(unique = true, nullable = false)
    private String email_utilisateur;

    @Past(message = "La date de naissance doit être dans le passé")
    private LocalDate dateNaissance_utilisateur;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Format de téléphone invalide")
    private String telephone_utilisateur;

    // Constructeur par défaut requis par JPA
    public Utilisateur(
    ) {
    }

    public Utilisateur(String nom_utilisateur, String prenom_utilisateur, String email_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
        this.prenom_utilisateur = prenom_utilisateur;
        this.email_utilisateur = email_utilisateur;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getPrenom_utilisateur() {
        return prenom_utilisateur;
    }

    public void setPrenom_utilisateur(String prenom_utilisateur) {
        this.prenom_utilisateur = prenom_utilisateur;
    }

    public String getEmail_utilisateur() {
        return email_utilisateur;
    }

    public void setEmail_utilisateur(String email_utilisateur) {
        this.email_utilisateur = email_utilisateur;
    }

    public LocalDate getDateNaissance_utilisateur() {
        return dateNaissance_utilisateur;
    }

    public void setDateNaissance_utilisateur(LocalDate dateNaissance_utilisateur) {
        this.dateNaissance_utilisateur = dateNaissance_utilisateur;
    }

    public String getTelephone_utilisateur() {
        return telephone_utilisateur;
    }

    public void setTelephone_utilisateur(String telephone_utilisateur) {
        this.telephone_utilisateur = telephone_utilisateur;
    }

    @Override
    public String toString() {

        return "Les info du utilisateur " + nom_utilisateur + " sont : " + "\n" +
                " Id : " + id_utilisateur + "\n" +
                " Nom : " + nom_utilisateur + "\n" +
                " Prenom : " + prenom_utilisateur + "\n" +
                " Email : " + email_utilisateur + "\n" +
                " Date de naissance : " + dateNaissance_utilisateur + "\n" +
                " Telephone :" + telephone_utilisateur + "\n";
    }
}
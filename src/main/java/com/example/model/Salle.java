package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_salle;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    @Column(nullable = false)
    private String nom_salle;

    @NotNull(message = "La capacité est obligatoire")
    @Min(value = 1, message = "La capacité minimum est de 1 personne")
    @Max(value = 1000, message = "La capacité maximum est de 1000 personnes")
    @Column(nullable = false)
    private Integer capacite_salle;

    @Size(max = 500, message = "La description ne peut pas dépasser 500 caractères")
    @Column(length = 500)
    private String description_salle;

    @NotNull(message = "Le statut est obligatoire")
    @Column(nullable = false)
    private Boolean disponible_salle = true;

    @Min(value = 0, message = "L'étage ne peut pas être négatif")
    private Integer etage_salle;

    public Salle() {
    }

    public Salle(String nom_salle, Integer capacite_salle) {
        this.nom_salle = nom_salle;
        this.capacite_salle = capacite_salle;
    }

    public Long getId_salle() {
        return id_salle;
    }
    public void setId_salle(Long id_salle) {
        this.id_salle = id_salle;
    }

    public String getNom_salle() {
        return nom_salle;
    }
    public void setNom_salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }

    public Integer getCapacite_salle() {
        return capacite_salle;
    }
    public void setCapacite_salle(Integer capacite_salle) {
        this.capacite_salle = capacite_salle;
    }

    public String getDescription_salle() {
        return description_salle;
    }
    public void setDescription_salle(String description_salle) {
        this.description_salle = description_salle;
    }

    public Boolean getDisponible_salle() {
        return disponible_salle;
    }
    public void setDisponible_salle(Boolean disponible_salle) {
        this.disponible_salle = disponible_salle;
    }

    public Integer getEtage_salle() {
        return etage_salle;
    }
    public void setEtage_salle(Integer etage_salle) {
        this.etage_salle = etage_salle;
    }

    @Override
    public String toString() {

        return "Les info du salle " + nom_salle + " sont : " + "\n" +
                " Id : " + id_salle + "\n" +
                " Nom : " + nom_salle + "\n" +
                " Capacite : " + capacite_salle + "\n" +
                " Description : " + description_salle + "\n" +
                " Disponibilité : " + disponible_salle + "\n" +
                " Etage :" + etage_salle + "\n";
    }
}
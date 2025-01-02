package com.ada.rncp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur", nullable = false)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "adresse", length = Integer.MAX_VALUE)
    private String adresse;

    @Column(name = "descriptionpersonnelle", length = Integer.MAX_VALUE)
    private String descriptionpersonnelle;

    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public Utilisateur setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Utilisateur setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public Utilisateur setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Utilisateur setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Utilisateur setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getAdresse() {
        return adresse;
    }

    public Utilisateur setAdresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public String getDescriptionpersonnelle() {
        return descriptionpersonnelle;
    }

    public Utilisateur setDescriptionpersonnelle(String descriptionpersonnelle) {
        this.descriptionpersonnelle = descriptionpersonnelle;
        return this;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Utilisateur setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        return this;
    }

}
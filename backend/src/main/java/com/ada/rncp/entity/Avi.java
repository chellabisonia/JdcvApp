package com.ada.rncp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "avis")
public class Avi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avis", nullable = false)
    private Integer id;

    @Column(name = "note")
    private Integer note;

    @Column(name = "commentaire", length = Integer.MAX_VALUE)
    private String commentaire;

    @Column(name = "date_avis")
    private LocalDate dateAvis;

    @ManyToOne()
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne()
    @JoinColumn(name = "id_sejour")
    private Sejour sejour;

    public Integer getId() {
        return id;
    }

    public Avi setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getNote() {
        return note;
    }

    public Avi setNote(Integer note) {
        this.note = note;
        return this;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Avi setCommentaire(String commentaire) {
        this.commentaire = commentaire;
        return this;
    }

    public LocalDate getDateAvis() {
        return dateAvis;
    }

    public Avi setDateAvis(LocalDate dateAvis) {
        this.dateAvis = dateAvis;
        return this;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Avi setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        return this;
    }

    public Sejour getSejour() {
        return sejour;
    }

    public Avi setSejour(Sejour sejour) {
        this.sejour = sejour;
        return this;
    }
}
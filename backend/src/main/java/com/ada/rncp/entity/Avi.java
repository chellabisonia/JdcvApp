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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur idUtilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sejour")
    private Sejour idSejour;

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

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public Avi setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
        return this;
    }

    public Sejour getIdSejour() {
        return idSejour;
    }

    public Avi setIdSejour(Sejour idSejour) {
        this.idSejour = idSejour;
        return this;
    }
}
package com.ada.rncp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation", nullable = false)
    private Integer id;

    @Column(name = "date_reservation")
    private LocalDate dateReservation;

    @Column(name = "nombre_participants")
    private Integer nombreParticipants;

    @Column(name = "statut", length = 50)
    private String statut;

    @Column(name = "datedebutreservationsejour")
    private LocalDate datedebutreservationsejour;

    @Column(name = "datefinreservationsejour")
    private LocalDate datefinreservationsejour;

    @ManyToOne()
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne()
    @JoinColumn(name = "id_sejour")
    private Sejour sejour;

   public  Reservation(){}

    public Reservation(LocalDate dateReservation, String statut, Integer nombreParticipants,LocalDate datedebutreservationsejour, LocalDate datefinreservationsejour,Sejour sejour, Utilisateur utilisateur) {
        this.dateReservation = dateReservation;
        this.statut = statut;
        this.nombreParticipants = nombreParticipants;
        this.datedebutreservationsejour = datedebutreservationsejour;
        this.datefinreservationsejour = datefinreservationsejour;
        this.utilisateur = utilisateur;
        this.sejour = sejour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Integer getNombreParticipants() {
        return nombreParticipants;
    }

    public void setNombreParticipants(Integer nombreParticipants) {
        this.nombreParticipants = nombreParticipants;
    }

    public LocalDate getDatedebutreservationsejour() {
        return datedebutreservationsejour;
    }

    public void setDatedebutreservationsejour(LocalDate datedebutreservationsejour) {
        this.datedebutreservationsejour = datedebutreservationsejour;
    }

    public LocalDate getDatefinreservationsejour() {
        return datefinreservationsejour;
    }

    public void setDatefinreservationsejour(LocalDate datefinreservationsejour) {
        this.datefinreservationsejour = datefinreservationsejour;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Sejour getSejour() {
        return sejour;
    }

    public void setSejour(Sejour sejour) {
        this.sejour = sejour;
    }
}
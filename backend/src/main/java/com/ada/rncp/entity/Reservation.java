package com.ada.rncp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
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

    public Integer getId() {
        return id;
    }

    public Reservation setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public Reservation setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
        return this;
    }

    public Integer getNombreParticipants() {
        return nombreParticipants;
    }

    public Reservation setNombreParticipants(Integer nombreParticipants) {
        this.nombreParticipants = nombreParticipants;
        return this;
    }

    public String getStatut() {
        return statut;
    }

    public Reservation setStatut(String statut) {
        this.statut = statut;
        return this;
    }

    public LocalDate getDatedebutreservationsejour() {
        return datedebutreservationsejour;
    }

    public Reservation setDatedebutreservationsejour(LocalDate datedebutreservationsejour) {
        this.datedebutreservationsejour = datedebutreservationsejour;
        return this;
    }

    public LocalDate getDatefinreservationsejour() {
        return datefinreservationsejour;
    }

    public Reservation setDatefinreservationsejour(LocalDate datefinreservationsejour) {
        this.datefinreservationsejour = datefinreservationsejour;
        return this;
    }
}
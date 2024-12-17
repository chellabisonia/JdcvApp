package com.ada.rncp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @ColumnDefault("nextval('reservation_id_reservation_seq'::regclass)")
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

}
package com.ada.rncp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "paiement")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('paiement_id_paiement_seq'::regclass)")
    @Column(name = "id_paiement", nullable = false)
    private Integer id;

    @Column(name = "montant", precision = 10, scale = 2)
    private BigDecimal montant;

    @Column(name = "mode_paiement")
    private String modePaiement;

    @Column(name = "date_paiement")
    private LocalDate datePaiement;

    @Column(name = "numtransaction")
    private String numtransaction;

    @Column(name = "statut", length = 50)
    private String statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservation")
    private Reservation idReservation;

}
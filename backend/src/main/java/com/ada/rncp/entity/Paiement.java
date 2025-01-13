package com.ada.rncp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "paiement")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne()
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

    public Integer getId() {
        return id;
    }

    public Paiement setId(Integer id) {
        this.id = id;
        return this;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public Paiement setMontant(BigDecimal montant) {
        this.montant = montant;
        return this;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public Paiement setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
        return this;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public Paiement setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
        return this;
    }

    public String getNumtransaction() {
        return numtransaction;
    }

    public Paiement setNumtransaction(String numtransaction) {
        this.numtransaction = numtransaction;
        return this;
    }

    public String getStatut() {
        return statut;
    }

    public Paiement setStatut(String statut) {
        this.statut = statut;
        return this;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Paiement setIdReservation(Reservation reservation) {
        this.reservation = reservation;
        return this;
    }
}
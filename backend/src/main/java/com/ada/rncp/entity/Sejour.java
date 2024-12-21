package com.ada.rncp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "sejour")
public class Sejour {
    @Id
    @Column(name = "id_sejour", nullable = false)
    private Integer id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "ville")
    private String ville;

    @Column(name = "typehebergement")
    private String typehebergement;

    @Column(name = "prixparnuit", precision = 10, scale = 2)
    private BigDecimal prixparnuit;

    @Column(name = "datedebutdispo")
    private LocalDate datedebutdispo;

    @Column(name = "datefindispo")
    private LocalDate datefindispo;

    public Integer getId() {
        return id;
    }

    public Sejour setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitre() {
        return titre;
    }

    public Sejour setTitre(String titre) {
        this.titre = titre;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Sejour setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVille() {
        return ville;
    }

    public Sejour setVille(String ville) {
        this.ville = ville;
        return this;
    }

    public String getTypehebergement() {
        return typehebergement;
    }

    public Sejour setTypehebergement(String typehebergement) {
        this.typehebergement = typehebergement;
        return this;
    }

    public BigDecimal getPrixparnuit() {
        return prixparnuit;
    }

    public Sejour setPrixparnuit(BigDecimal prixparnuit) {
        this.prixparnuit = prixparnuit;
        return this;
    }

    public LocalDate getDatedebutdispo() {
        return datedebutdispo;
    }

    public Sejour setDatedebutdispo(LocalDate datedebutdispo) {
        this.datedebutdispo = datedebutdispo;
        return this;
    }

    public LocalDate getDatefindispo() {
        return datefindispo;
    }

    public Sejour setDatefindispo(LocalDate datefindispo) {
        this.datefindispo = datefindispo;
        return this;
    }
}
package com.ada.rncp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "sejour")
public class Sejour {
    @Id
    @ColumnDefault("nextval('sejour_id_sejour_seq'::regclass)")
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

}
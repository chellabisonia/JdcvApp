package com.ada.rncp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "avis")
public class Avi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('avis_id_avis_seq'::regclass)")
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

}
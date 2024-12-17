package com.ada.rncp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @ColumnDefault("nextval('utilisateur_id_utilisateur_seq'::regclass)")
    @Column(name = "id_utilisateur", nullable = false)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "adresse", length = Integer.MAX_VALUE)
    private String adresse;

    @Column(name = "descriptionpersonnelle", length = Integer.MAX_VALUE)
    private String descriptionpersonnelle;

}
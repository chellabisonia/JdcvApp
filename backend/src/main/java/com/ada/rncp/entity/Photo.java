package com.ada.rncp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('photo_id_photo_seq'::regclass)")
    @Column(name = "id_photo", nullable = false)
    private Integer id;

    @Column(name = "url_photo")
    private String urlPhoto;

    @Column(name = "dateajoutphoto")
    private LocalDate dateajoutphoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sejour")
    private Sejour idSejour;

}
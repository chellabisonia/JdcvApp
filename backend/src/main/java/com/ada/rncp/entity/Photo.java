package com.ada.rncp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photo", nullable = false)
    private Integer id;

    @Column(name = "url_photo")
    private String urlPhoto;

    @Column(name = "dateajoutphoto")
    private LocalDate dateajoutphoto;

    @ManyToOne()
    @JoinColumn(name = "id_sejour")
    private Sejour sejour;

    public Integer getId() {
        return id;
    }

    public Photo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public Photo setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
        return this;
    }

    public LocalDate getDateajoutphoto() {
        return dateajoutphoto;
    }

    public Photo setDateajoutphoto(LocalDate dateajoutphoto) {
        this.dateajoutphoto = dateajoutphoto;
        return this;
    }

    public Sejour getSejour() {
        return sejour;
    }

    public Photo setSejour(Sejour idSejour) {
        this.sejour = sejour;
        return this;
    }
}
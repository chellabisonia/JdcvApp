package com.ada.rncp.controller;


import com.ada.rncp.entity.Reservation;
import com.ada.rncp.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    public static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<?> getAllReservations() {
        try {
            List<?> reservations = reservationService.getAllReservation();
            return ResponseEntity.ok(reservations);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}" + ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneReservationById(@PathVariable Integer id) {
        try {
            Reservation oneReservation = reservationService.getOneReservationById(id);
            return ResponseEntity.ok(oneReservation);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneReservationById(@PathVariable Integer id) {
        logger.info("Requête pour supprimer la réservation avec l'ID {}" + id);

        try {
            reservationService.deleteOneReservationById(id);
            return ResponseEntity.ok("Réservation supprimée avec succés!");
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Reservation reservationDetails) {
        try {
            Reservation nouvelleReservation = reservationService.createOneReservation(reservationDetails);
            return ResponseEntity.ok(nouvelleReservation);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Reservation reservationDetails) {
        try {
            Reservation reservationMiseAJour = reservationService.updateReservation(id, reservationDetails);
            return ResponseEntity.ok(reservationMiseAJour);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

}

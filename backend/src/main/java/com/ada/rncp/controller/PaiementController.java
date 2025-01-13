package com.ada.rncp.controller;


import com.ada.rncp.entity.Paiement;
import com.ada.rncp.service.PaiementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiement")
public class PaiementController {
    public static final Logger logger = LoggerFactory.getLogger(PaiementController.class);
    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPayments() {
        try {
            List<?> paiements = paiementService.getAllPayments();
            return ResponseEntity.ok(paiements);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}" + ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOnePaymentById(@PathVariable Integer id) {
        try {
            Paiement paiement = paiementService.getOnePaiementById(id);
            return ResponseEntity.ok(paiement);
        } catch (RuntimeException ex) {
            logger.error("Erreur {}" + ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOnePaymentById(@PathVariable Integer id) {
        logger.info("Requête pour supprimer le paiement avec l'ID {}" + id);
        try {
            paiementService.deleteOnePaymentById(id);
            return ResponseEntity.ok("Paiement supprimé avec succés!");
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}" + ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Paiement paiementDetails) {
        try {
            Paiement nouveauPaiement = paiementService.createOnePayment(paiementDetails);
            return ResponseEntity.ok(nouveauPaiement);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Paiement paymentDetails) {
        try {
            Paiement paiementMisAJour = paiementService.updateOnePaymentById(id, paymentDetails);
            return ResponseEntity.ok(paiementMisAJour);
        } catch (RuntimeException ex) {
            logger.info("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());

        }
    }
}

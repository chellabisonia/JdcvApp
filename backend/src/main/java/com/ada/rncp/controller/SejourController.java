package com.ada.rncp.controller;

import com.ada.rncp.entity.Sejour;
import com.ada.rncp.service.SejourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/séjours")
public class SejourController {
    private static final Logger logger = LoggerFactory.getLogger(SejourController.class);
    private final SejourService sejourService;

    public SejourController(SejourService sejourService) {
        this.sejourService = sejourService;
    }

    @GetMapping
    public ResponseEntity<?> getAllStays() {
        try {
            List<?> sejours = sejourService.getAllSejour();
            return ResponseEntity.ok(sejours);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneStay(@PathVariable Integer id) {
        try {
            Sejour oneSejour = sejourService.getOneSejourById(id);
            return ResponseEntity.ok(oneSejour);
        } catch (RuntimeException ex) {
            logger.error("Erreur : {} ", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSejour(@PathVariable Integer id) {
        logger.info("Requête pour supprimer le séjour avec l'ID {} " + id);

        try {
            sejourService.deleteOneSejourById(id);
            return ResponseEntity.ok("Séjour upprimé avec succés!");
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Sejour sejour) {
        try {
            Sejour nouveauSejour = sejourService.createSejour(sejour);
            return ResponseEntity.ok(nouveauSejour);
        } catch (Exception ex) {
            logger.error("Erreur lors de la création du séjour : {}", ex.getMessage());
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Sejour sejourDetails) {
        try {
            Sejour sejourMisAJour = sejourService.updateSejour(id, sejourDetails);
            return ResponseEntity.ok(sejourMisAJour);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

}

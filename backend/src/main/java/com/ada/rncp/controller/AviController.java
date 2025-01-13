package com.ada.rncp.controller;

import com.ada.rncp.entity.Avi;
import com.ada.rncp.service.AviService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avi")
public class AviController {
    public static final Logger logger = LoggerFactory.getLogger(AviController.class);
    private final AviService aviService;

    public AviController(AviService aviService) {
        this.aviService = aviService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAvis() {
        try {
            List<?> avis = aviService.getAllAvis();
            if (avis.isEmpty()) {
                return ResponseEntity.status(204).body("Data not found!");
            } else {
                return ResponseEntity.ok(avis);
            }
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneAviById(@PathVariable Integer id) {
        try {
            Avi unAvi = aviService.getOneAviById(id);
            return ResponseEntity.ok(unAvi);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneAviById(@PathVariable Integer id) {
        logger.info("Requête pour supprimer le'avis avec l'ID {}" + id);
        try {
            aviService.deleteOneAviById(id);
            return ResponseEntity.ok("avi supprimé avec succés!");
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestBody Avi aviDetails) {
        try {
            Avi nouveauAvi = aviService.createOneAvi(aviDetails);
            return ResponseEntity.ok(nouveauAvi);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Avi aviDetails) {
        try {
            Avi aviMisAJour = aviService.updateOneAviById(id, aviDetails);
            return ResponseEntity.ok(aviMisAJour);
        } catch (RuntimeException ex) {
            logger.error("Erreur: {}", ex.getMessage());
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }
}


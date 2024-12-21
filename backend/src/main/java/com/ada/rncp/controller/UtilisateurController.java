package com.ada.rncp.controller;

import com.ada.rncp.entity.Utilisateur;
import com.ada.rncp.service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;
    private final static Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            List<?> utilisateurs = utilisateurService.getAllUtilisateur();
            return ResponseEntity.ok(utilisateurs);
        } catch (RuntimeException ex) {
            logger.error("Erreur : {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOneUtilisateurById(@PathVariable Integer id) {
        try {
            Utilisateur OneUtilisateur = utilisateurService.getOneUtilisateurById(id);
            return ResponseEntity.ok(OneUtilisateur);
        } catch (RuntimeException ex) {
            logger.error("Erreur : {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUtilisateurByID(@PathVariable Integer id) {
        logger.info("Requête pour supprimer l'utilisateur avec l'ID {}", id);
        try {
            utilisateurService.deleteOneUtilisateurById(id);
            return ResponseEntity.ok("Utilisateur supprimé avec succès");
        } catch (RuntimeException ex) {
            logger.error("Erreur : {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Utilisateur utilisateur) {
        try {
            Utilisateur nouvelUtilisateur = utilisateurService.createUtilisateur(utilisateur);
            return ResponseEntity.ok(nouvelUtilisateur);
        } catch (Exception ex) {
            logger.error("Erreur lors de la création de l'utilisateur : {}", ex.getMessage());
            return ResponseEntity.status(400).body("Erreur lors de la création de l'utilisateur.");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Utilisateur utilisateurDetails) {
        try {
            Utilisateur utilisateurMisAJour = utilisateurService.updateUtilisateur(id, utilisateurDetails);
            return ResponseEntity.ok(utilisateurMisAJour);
        } catch (RuntimeException ex) {
            logger.error("Erreur : {}", ex.getMessage());
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }
}

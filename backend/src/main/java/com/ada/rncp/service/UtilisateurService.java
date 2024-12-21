package com.ada.rncp.service;

import com.ada.rncp.entity.Utilisateur;
import com.ada.rncp.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Service
public class UtilisateurService {
    private static final Logger logger = LoggerFactory.getLogger(UtilisateurService.class);
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    public List<?> getAllUtilisateur() {
        List<?> utilisateurs = utilisateurRepository.findAll();
        logger.info("Utilisateurs récupérés : {}", utilisateurs);
        return utilisateurs; // Retourne une liste vide si aucun utilisateur n'est trouvé
    }


    public Utilisateur getOneUtilisateurById(Integer id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));
    }

    public void deleteOneUtilisateurById(Integer id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : l'utilisateur avec l'ID " + id + " n'existe pas.");
        }
        utilisateurRepository.deleteById(id);
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new RuntimeException("Un utilisateur avec cet email existe déjà!");
        }
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur updateUtilisateur(Integer id, Utilisateur utilisateurDetails) {
        Utilisateur utilisateurExistant = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID " + id));

        utilisateurExistant.setNom(utilisateurDetails.getNom());
        utilisateurExistant.setPrenom(utilisateurDetails.getPrenom());
        utilisateurExistant.setAdresse(utilisateurDetails.getAdresse());
        utilisateurExistant.setDescriptionpersonnelle(utilisateurDetails.getDescriptionpersonnelle());
        utilisateurExistant.setEmail(utilisateurDetails.getEmail());
        utilisateurExistant.setTelephone(utilisateurDetails.getTelephone());

        return utilisateurRepository.save(utilisateurExistant);
    }


}

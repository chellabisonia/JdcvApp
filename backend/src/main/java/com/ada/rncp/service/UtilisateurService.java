package com.ada.rncp.service;

import com.ada.rncp.entity.Utilisateur;
import com.ada.rncp.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getAllUtilisateur() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        if (utilisateurs.isEmpty()) {
            throw new RuntimeException("Aucun utilisateur n'est trouvé");
        }
        return utilisateurs;
    }
}

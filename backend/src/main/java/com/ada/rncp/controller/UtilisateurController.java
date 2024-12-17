package com.ada.rncp.controller;

import com.ada.rncp.entity.Utilisateur;
import com.ada.rncp.service.UtilisateurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    public  UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }
    @GetMapping
    List<Utilisateur> getAllUsers(){
        return utilisateurService.getAllUtilisateur();
    }
}

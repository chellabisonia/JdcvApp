package com.ada.rncp.service;


import com.ada.rncp.entity.Avi;
import com.ada.rncp.repository.AviRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AviService {
    public static final Logger logger = LoggerFactory.getLogger(AviService.class);
    private final AviRepository aviRepository;

    public AviService(AviRepository aviRepository) {
        this.aviRepository = aviRepository;
    }

    public List<?> getAllAvis() {
        List<Avi> avis = aviRepository.findAll();
        logger.info("Avis réccupérés : {}" + avis);
        return avis;
    }

    public Avi getOneAviById(Integer id) {
        return aviRepository.findById(id).orElseThrow(() -> new RuntimeException("Avis non trouvé avec l'ID {}" + id));
    }

    public void deleteOneAviById(Integer id) {
        if (!aviRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer: l'avis avec l'ID {} n'existe pas" + id);
        }
        aviRepository.deleteById(id);
    }

    public Avi createOneAvi(Avi aviDetails) {
        if (aviDetails.getId() != null && aviRepository.existsById(aviDetails.getId())) {
            throw new RuntimeException("L'avis avec l'ID {} existe déjà!");
        }
        return aviRepository.save(aviDetails);
    }

    public Avi updateOneAviById(Integer id, Avi aviDetails) {
        Avi aviExistant = aviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("L'avis avec l'ID {} n'existe pas" + id));

        aviExistant.setCommentaire(aviDetails.getCommentaire());
        aviExistant.setDateAvis(aviDetails.getDateAvis());
        aviExistant.setNote(aviDetails.getNote());
        aviExistant.setSejour(aviDetails.getSejour());
        aviExistant.setUtilisateur(aviDetails.getUtilisateur());

        return aviRepository.save(aviExistant);
    }
}

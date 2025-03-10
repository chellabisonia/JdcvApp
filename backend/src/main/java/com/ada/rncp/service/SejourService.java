package com.ada.rncp.service;

import com.ada.rncp.entity.Sejour;
import com.ada.rncp.repository.SejourRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SejourService {
    private static final Logger logger = LoggerFactory.getLogger(SejourService.class);
    private final SejourRepository sejourRepository;

    public SejourService(SejourRepository sejourRepository) {
        this.sejourRepository = sejourRepository;
    }

    public List<?> getAllSejour() {
        List<?> sejours = sejourRepository.findAll();
        logger.info("Séjours réccupérés : {}", sejours);
        return sejours;
    }

    public Sejour getOneSejourById(Integer id) {
        return sejourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Séjour non trouvé avec l'ID {} " + id));
    }

    public void deleteOneSejourById(Integer id) {
        if (!sejourRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer: le séjour avec l'ID " + id + "n'existe pas!");
        }
        sejourRepository.deleteById(id);
    }


    public Sejour createSejour(Sejour sejour) {
        if (sejourRepository.existsByTitre(sejour.getTitre())) {
            throw new RuntimeException("Un séjour avec ce titre existe déjà!");
        }
        return sejourRepository.save(sejour);
    }

    public Sejour updateSejour(Integer id, Sejour sejourDetails) {
        Sejour sejourExistant = sejourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Séjour non trouvé avec l'ID " + id));

        sejourExistant.setTitre(sejourDetails.getTitre());
        sejourDetails.setDescription(sejourDetails.getDescription());
        sejourExistant.setVille(sejourDetails.getVille());
        sejourExistant.setTypehebergement(sejourDetails.getTypehebergement());
        sejourExistant.setPrixparnuit(sejourDetails.getPrixparnuit());
        sejourExistant.setDatedebutdispo(sejourDetails.getDatedebutdispo());
        sejourExistant.setDatefindispo(sejourDetails.getDatefindispo());

        return sejourRepository.save(sejourExistant);
    }


}

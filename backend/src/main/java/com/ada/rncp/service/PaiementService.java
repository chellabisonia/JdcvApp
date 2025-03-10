package com.ada.rncp.service;

import com.ada.rncp.entity.Paiement;
import com.ada.rncp.repository.PaiementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {
    public static final Logger logger = LoggerFactory.getLogger(PaiementService.class);
    private final PaiementRepository paiementRepository;

    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }


    public List<?> getAllPayments() {
        List<Paiement> paiements = paiementRepository.findAll();
        logger.info("Paiments réccupérées : {}" + paiements);
        return paiements;
    }

    public Paiement getOnePaiementById(Integer id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec l'ID {}" + id));
    }

    public void deleteOnePaymentById(Integer id) {
        if (!paiementRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer: le paiemeent avce l'ID {}" + id);
        }
        paiementRepository.deleteById(id);
    }

    public Paiement createOnePayment(Paiement paymentDetails) {
        if (paymentDetails.getId() != null && paiementRepository.existsById(paymentDetails.getId())) {
            throw new RuntimeException("Un paiement avec l'ID {} existe déjà!" + paymentDetails.getId());
        }
        return paiementRepository.save(paymentDetails);
    }

    public Paiement updateOnePaymentById(Integer id, Paiement paymentDetails) {
        Paiement paymentExistant = paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Le paiemant avec l'ID {} n'existe pas" + id));

        paymentExistant.setDatePaiement(paymentDetails.getDatePaiement());
        paymentExistant.setModePaiement(paymentDetails.getModePaiement());
        paymentExistant.setMontant(paymentDetails.getMontant());
        paymentExistant.setNumtransaction(paymentDetails.getNumtransaction());
        paymentExistant.setStatut(paymentDetails.getStatut());
        paymentExistant.setIdReservation(paymentDetails.getReservation());

        return paiementRepository.save(paymentExistant);
    }
}

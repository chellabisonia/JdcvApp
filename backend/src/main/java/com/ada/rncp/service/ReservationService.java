package com.ada.rncp.service;

import com.ada.rncp.entity.Reservation;
import com.ada.rncp.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    public static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public List<?> getAllReservation() {
        List<?> reservations = reservationRepository.findAll();
        logger.info("Réservations récuppérées: {}" + reservations);
        return reservations;
    }

    public Reservation getOneReservationById(Integer id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Réservation non trouvée avec l'ID {}" + id));
    }


    public void deleteOneReservationById(Integer id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer: la réservation avec l'ID {}" + id);
        }
        reservationRepository.deleteById(id);
    }

    public Reservation createOneReservation(Reservation reservationDetails) {

        if (reservationDetails.getId() != null && reservationRepository.existsById(reservationDetails.getId())) {
            throw new RuntimeException("Une réservation avec cet ID {} existe déjà " + reservationDetails.getId());
        }
        return reservationRepository.save(reservationDetails);
    }


    public Reservation updateReservation(Integer id, Reservation reservationDetails) {
        Reservation reservationExistante = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("La réservation avec l'ID {} n'esxiste pas" + id));


        reservationExistante.setDateReservation(reservationDetails.getDateReservation());
        reservationExistante.setNombreParticipants(reservationDetails.getNombreParticipants());
        reservationExistante.setStatut(reservationDetails.getStatut());
        reservationExistante.setDatedebutreservationsejour(reservationDetails.getDatedebutreservationsejour());
        reservationExistante.setDatefinreservationsejour(reservationDetails.getDatefinreservationsejour());

        return reservationRepository.save(reservationExistante);
    }
}

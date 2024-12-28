package com.ada.rncp.repository;

import com.ada.rncp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Integer>{
    boolean existsById(Integer id);
}

package com.ada.rncp.repository;

import com.ada.rncp.entity.Sejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SejourRepository extends JpaRepository <Sejour, Integer > {
    boolean existsByTitre(String titre);
}

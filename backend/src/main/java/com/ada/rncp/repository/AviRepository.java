package com.ada.rncp.repository;

import com.ada.rncp.entity.Avi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AviRepository extends JpaRepository<Avi, Integer> {
}

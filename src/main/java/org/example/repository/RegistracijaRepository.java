package org.example.repository;

import org.example.entity.Registracija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistracijaRepository extends JpaRepository<Registracija, Long> {

    List<Registracija> findByAsmuoId(Long asmuoId);

    // Papildomi užklausų metodai
    List<Registracija> findByRegistreacijosDataBetween(LocalDateTime startDate, LocalDateTime endDate);

}


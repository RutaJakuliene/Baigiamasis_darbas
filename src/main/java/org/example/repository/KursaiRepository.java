package org.example.repository;

import org.example.entity.Kursai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface KursaiRepository extends JpaRepository<Kursai, Long> {

    List<Kursai> findByPavadinimas(String pavadinimas);

    List<Kursai> findByPradziosDataAfter(LocalDate date);

    List<Kursai> findByPabaigosDataBefore(LocalDate date);

    // Papildomi užklausų metodai
    List<Kursai> findByPavadinimasContainingIgnoreCase(String keyword);

}

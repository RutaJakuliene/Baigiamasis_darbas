package org.example.repository;

import org.example.entity.Sertifikatas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SertifikatasRepository extends JpaRepository<Sertifikatas, Long> {

    List<Sertifikatas> findByPavadinimas(String pavadinimas);

    // Papildomi užklausų metodai
    List<Sertifikatas> findByGaliojimoDataAfter(LocalDate date);

}

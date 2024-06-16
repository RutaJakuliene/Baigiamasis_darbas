package org.example.repository;

import org.example.entity.Asmuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsmuoRepository extends JpaRepository<Asmuo, Long> {

    List<Asmuo> findByVardas(String vardas);

    List<Asmuo> findByPavarde(String pavarde);

    List<Asmuo> findByElPastas(String elPastas);

    // Papildomi užklausų metodai
    List<Asmuo> findByVardasAndPavarde(String vardas, String pavarde);

    List<Asmuo> findByVardasOrPavarde(String vardas, String pavarde);

}

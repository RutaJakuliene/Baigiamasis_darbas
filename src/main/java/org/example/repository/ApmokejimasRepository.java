package org.example.repository;
import org.example.entity.Apmokejimas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ApmokejimasRepository extends JpaRepository<Apmokejimas, Long> {

    List<Apmokejimas> findByAsmuoId(Long asmuoId);

    // Papildomi užklausų metodai
    List<Apmokejimas> findBySumaGreaterThan(BigDecimal suma);

}

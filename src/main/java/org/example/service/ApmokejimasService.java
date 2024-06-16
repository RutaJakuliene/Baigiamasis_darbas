package org.example.service;
import org.example.dto.ApmokejimasDto;
import java.util.List;
public interface ApmokejimasService {
    List<ApmokejimasDto> gautiVisusApmokejimus();
    ApmokejimasDto gautiApmokejimaPagalId(Long id);
    ApmokejimasDto sukurtiApmokejima(ApmokejimasDto apmokejimasDto);
    ApmokejimasDto atnaujintiApmokejima(Long id, ApmokejimasDto apmokejimasDto);
    ApmokejimasDto createApmokejimas(ApmokejimasDto apmokejimasDto);
    ApmokejimasDto updateApmokejimas(Long id, ApmokejimasDto apmokejimasDto);
    void deleteApmokejimas(Long id);
    ApmokejimasDto getApmokejimasById(Long id);
    List<ApmokejimasDto> getAllApmokejimas();
}

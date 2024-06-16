package org.example.service;

import org.example.dto.SertifikatasDto;

import java.util.List;

public interface SertifikatasService {

    List<SertifikatasDto> getAllSertifikatai();

    SertifikatasDto getSertifikatasById(Long id);

    SertifikatasDto createSertifikatas(SertifikatasDto sertifikatasDto);

    SertifikatasDto updateSertifikatas(Long id, SertifikatasDto sertifikatasDto);

    void deleteSertifikatas(Long id);

    List<SertifikatasDto> gautiVisusSertifikatus();

    SertifikatasDto sukurtiSertifikata(SertifikatasDto sertifikatasDto);

    SertifikatasDto gautiSertifikataPagalId(Long id);

    SertifikatasDto atnaujintiSertifikata(Long id, SertifikatasDto sertifikatasDto);

    void istrintiSertifikata(Long id);
}

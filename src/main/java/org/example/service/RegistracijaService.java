package org.example.service;

import org.example.dto.RegistracijaDto;

import java.util.List;

public interface RegistracijaService {

    List<RegistracijaDto> getAllRegistracijos();

    RegistracijaDto getRegistracijaById(Long id);

    RegistracijaDto createRegistracija(RegistracijaDto registracijaDto);

    RegistracijaDto updateRegistracija(Long id, RegistracijaDto registracijaDto);

    void deleteRegistracija(Long id);

    List<RegistracijaDto> gautiVisasRegistracijas();

    RegistracijaDto sukurtiRegistracija(RegistracijaDto registracijaDto);

    RegistracijaDto gautiRegistracijaPagalId(Long id);

    RegistracijaDto atnaujintiRegistracija(Long id, RegistracijaDto registracijaDto);

    void istrintiRegistracija(Long id);
}

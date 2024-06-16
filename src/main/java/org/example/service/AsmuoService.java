package org.example.service;

import org.example.dto.AsmuoDto;
import org.example.entity.Asmuo;

import java.util.List;

public interface AsmuoService {

    List<AsmuoDto> getAllAsmenys();

    AsmuoDto getAsmuoById(Long id);

    AsmuoDto createAsmuo(AsmuoDto asmuoDto);

    AsmuoDto updateAsmuo(Long id, AsmuoDto asmuoDto);

    void deleteAsmuo(Long id);

    List<AsmuoDto> gautiVisusAsmenis();

    AsmuoDto sukurtiAsmeni(AsmuoDto asmuoDto);

    AsmuoDto gautiAsmeniPagalId(Long id);

    void istrintiAsmeni(Long id);

    AsmuoDto atnaujintiAsmeni(Long id, AsmuoDto asmuoDto);
}


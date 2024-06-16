package org.example.service.impl;

import org.example.dto.SertifikatasDto;
import org.example.entity.Sertifikatas;
import org.example.repository.SertifikatasRepository;
import org.example.service.SertifikatasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SertifikatasServiceImpl implements SertifikatasService {

    private final SertifikatasRepository sertifikatasRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SertifikatasServiceImpl(SertifikatasRepository sertifikatasRepository, ModelMapper modelMapper) {
        this.sertifikatasRepository = sertifikatasRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SertifikatasDto> getAllSertifikatai() {
        return null;
    }

    @Override
    public SertifikatasDto getSertifikatasById(Long id) {
        return null;
    }

    @Override
    public SertifikatasDto createSertifikatas(SertifikatasDto sertifikatasDto) {
        return null;
    }

    @Override
    public SertifikatasDto updateSertifikatas(Long id, SertifikatasDto sertifikatasDto) {
        return null;
    }

    @Override
    public void deleteSertifikatas(Long id) {

    }

    @Override
    public List<SertifikatasDto> gautiVisusSertifikatus() {
        List<Sertifikatas> sertifikatai = sertifikatasRepository.findAll();
        return sertifikatai.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SertifikatasDto gautiSertifikataPagalId(Long id) {
        Sertifikatas sertifikatas = sertifikatasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sertifikatas nerastas pagal id: " + id));
        return convertToDto(sertifikatas);
    }

    @Override
    public SertifikatasDto sukurtiSertifikata(SertifikatasDto sertifikatasDto) {
        Sertifikatas sertifikatas = convertToEntity(sertifikatasDto);
        sertifikatas = sertifikatasRepository.save(sertifikatas);
        return convertToDto(sertifikatas);
    }

    @Override
    public SertifikatasDto atnaujintiSertifikata(Long id, SertifikatasDto sertifikatasDto) {
        Sertifikatas sertifikatas = sertifikatasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sertifikatas nerastas pagal id: " + id));

        sertifikatas.setPavadinimas(sertifikatasDto.getPavadinimas());
        sertifikatas.setSertifikavimoData(sertifikatasDto.getSertifikavimoData());
        sertifikatas.setGaliojimoData(sertifikatasDto.getGaliojimoData());

        sertifikatas = sertifikatasRepository.save(sertifikatas);
        return convertToDto(sertifikatas);
    }

    @Override
    public void istrintiSertifikata(Long id) {
        sertifikatasRepository.deleteById(id);
    }

    private SertifikatasDto convertToDto(Sertifikatas sertifikatas) {
        return modelMapper.map(sertifikatas, SertifikatasDto.class);
    }

    private Sertifikatas convertToEntity(SertifikatasDto sertifikatasDto) {
        return modelMapper.map(sertifikatasDto, Sertifikatas.class);
    }
}

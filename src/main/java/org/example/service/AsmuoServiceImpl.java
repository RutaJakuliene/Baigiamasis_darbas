package org.example.service.impl;

import org.example.dto.AsmuoDto;
import org.example.entity.Asmuo;
import org.example.repository.AsmuoRepository;
import org.example.service.AsmuoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsmuoServiceImpl implements AsmuoService {

    private final AsmuoRepository asmuoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AsmuoServiceImpl(AsmuoRepository asmuoRepository, ModelMapper modelMapper) {
        this.asmuoRepository = asmuoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AsmuoDto> getAllAsmenys() {
        List<Asmuo> asmenys = asmuoRepository.findAll();
        return asmenys.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AsmuoDto getAsmuoById(Long id) {
        Asmuo asmuo = asmuoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asmuo not found with id: " + id));
        return convertToDto(asmuo);
    }

    @Override
    public AsmuoDto createAsmuo(AsmuoDto asmuoDto) {
        Asmuo newAsmuo = convertToEntity(asmuoDto);
        Asmuo savedAsmuo = asmuoRepository.save(newAsmuo);
        return convertToDto(savedAsmuo);
    }

    @Override
    public AsmuoDto updateAsmuo(Long id, AsmuoDto asmuoDto) {
        Asmuo existingAsmuo = asmuoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asmuo not found with id: " + id));

        modelMapper.map(asmuoDto, existingAsmuo);

        Asmuo updatedAsmuo = asmuoRepository.save(existingAsmuo);
        return convertToDto(updatedAsmuo);
    }

    @Override
    public void deleteAsmuo(Long id) {
        asmuoRepository.deleteById(id);
    }

    @Override
    public List<AsmuoDto> gautiVisusAsmenis() {
        return null;
    }

    @Override
    public AsmuoDto sukurtiAsmeni(AsmuoDto asmuoDto) {
        return null;
    }

    @Override
    public AsmuoDto gautiAsmeniPagalId(Long id) {
        return null;
    }

    @Override
    public void istrintiAsmeni(Long id) {

    }

    @Override
    public AsmuoDto atnaujintiAsmeni(Long id, AsmuoDto asmuoDto) {
        return null;
    }

    private AsmuoDto convertToDto(Asmuo asmuo) {
        return modelMapper.map(asmuo, AsmuoDto.class);
    }

    private Asmuo convertToEntity(AsmuoDto asmuoDto) {
        return modelMapper.map(asmuoDto, Asmuo.class);
    }
}

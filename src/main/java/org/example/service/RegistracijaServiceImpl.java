package org.example.service.impl;

import org.example.dto.RegistracijaDto;
import org.example.entity.Registracija;
import org.example.repository.RegistracijaRepository;
import org.example.service.RegistracijaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistracijaServiceImpl implements RegistracijaService {

    private final RegistracijaRepository registracijaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RegistracijaServiceImpl(RegistracijaRepository registracijaRepository, ModelMapper modelMapper) {
        this.registracijaRepository = registracijaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RegistracijaDto> getAllRegistracijos() {
        List<Registracija> registracijos = registracijaRepository.findAll();
        return registracijos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RegistracijaDto getRegistracijaById(Long id) {
        Registracija registracija = registracijaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registracija not found with id: " + id));
        return convertToDto(registracija);
    }

    @Override
    public RegistracijaDto createRegistracija(RegistracijaDto registracijaDto) {
        Registracija newRegistracija = convertToEntity(registracijaDto);
        Registracija savedRegistracija = registracijaRepository.save(newRegistracija);
        return convertToDto(savedRegistracija);
    }

    @Override
    public RegistracijaDto updateRegistracija(Long id, RegistracijaDto registracijaDto) {
        Registracija existingRegistracija = registracijaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registracija not found with id: " + id));

        modelMapper.map(registracijaDto, existingRegistracija);

        Registracija updatedRegistracija = registracijaRepository.save(existingRegistracija);
        return convertToDto(updatedRegistracija);
    }

    @Override
    public void deleteRegistracija(Long id) {
        registracijaRepository.deleteById(id);
    }

    @Override
    public List<RegistracijaDto> gautiVisasRegistracijas() {
        return null;
    }

    @Override
    public RegistracijaDto sukurtiRegistracija(RegistracijaDto registracijaDto) {
        return null;
    }

    @Override
    public RegistracijaDto gautiRegistracijaPagalId(Long id) {
        return null;
    }

    @Override
    public RegistracijaDto atnaujintiRegistracija(Long id, RegistracijaDto registracijaDto) {
        return null;
    }

    @Override
    public void istrintiRegistracija(Long id) {

    }

    private RegistracijaDto convertToDto(Registracija registracija) {
        return modelMapper.map(registracija, RegistracijaDto.class);
    }

    private Registracija convertToEntity(RegistracijaDto registracijaDto) {
        return modelMapper.map(registracijaDto, Registracija.class);
    }
}

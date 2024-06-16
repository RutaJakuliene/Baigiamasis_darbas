package org.example.service.impl;
import org.example.dto.ApmokejimasDto;
import org.example.entity.Apmokejimas;
import org.example.repository.ApmokejimasRepository;
import org.example.service.ApmokejimasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ApmokejimasServiceImpl implements ApmokejimasService {
    private final ApmokejimasRepository apmokejimasRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public ApmokejimasServiceImpl(ApmokejimasRepository apmokejimasRepository, ModelMapper modelMapper) {
        this.apmokejimasRepository = apmokejimasRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<ApmokejimasDto> gautiVisusApmokejimus() {
        List<Apmokejimas> apmokejimai = apmokejimasRepository.findAll();
        return apmokejimai.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @Override
    public ApmokejimasDto gautiApmokejimaPagalId(Long id) {
        Apmokejimas apmokejimas = apmokejimasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apmokejimas nerastas pagal id: " + id));
        return convertToDto(apmokejimas);
    }
    @Override
    public ApmokejimasDto sukurtiApmokejima(ApmokejimasDto apmokejimasDto) {
        Apmokejimas apmokejimas = convertToEntity(apmokejimasDto);
        apmokejimas = apmokejimasRepository.save(apmokejimas);
        return convertToDto(apmokejimas);
    }
    @Override
    public ApmokejimasDto atnaujintiApmokejima(Long id, ApmokejimasDto apmokejimasDto) {
        Apmokejimas apmokejimas = apmokejimasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apmokejimas nerastas pagal id: " + id));
        apmokejimas.setSuma(apmokejimasDto.getSuma());
        apmokejimas.setSuma(apmokejimasDto.getData());
        apmokejimas = apmokejimasRepository.save(apmokejimas);
        return convertToDto(apmokejimas);
    }
    @Override
    public ApmokejimasDto createApmokejimas(ApmokejimasDto apmokejimasDto) {
        return null;
    }
    @Override
    public ApmokejimasDto updateApmokejimas(Long id, ApmokejimasDto apmokejimasDto) {
        return null;
    }
    @Override
    public void deleteApmokejimas(Long id) {
        apmokejimasRepository.deleteById(id);
    }
    @Override
    public ApmokejimasDto getApmokejimasById(Long id) {
        return null;
    }
    @Override
    public List<ApmokejimasDto> getAllApmokejimas() {
        return null;
    }
    private ApmokejimasDto convertToDto(Apmokejimas apmokejimas) {
        return modelMapper.map(apmokejimas, ApmokejimasDto.class);
    }
    private Apmokejimas convertToEntity(ApmokejimasDto apmokejimasDto) {
        return modelMapper.map(apmokejimasDto, Apmokejimas.class);
    }
}

package org.example.service;

import org.example.dto.KursaiDto;
import org.example.entity.Kursai;
import org.example.repository.KursaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KursaiServiceImpl implements KursaiService {

    @Autowired
    private KursaiRepository kursaiRepository;

    @Override
    public KursaiDto createKursai(KursaiDto kursaiDto) {
        Kursai kursai = new Kursai();
        kursai.setPavadinimas(kursaiDto.getPavadinimas());
        kursai.setPradziosData(kursaiDto.getPradziosData());
        kursai.setPabaigosData(kursaiDto.getPabaigosData());
        kursai = kursaiRepository.save(kursai);
        return mapToDto(kursai);
    }

    @Override
    public KursaiDto updateKursai(Long id, KursaiDto kursaiDto) {
        Optional<Kursai> optionalKursai = kursaiRepository.findById(id);
        if (optionalKursai.isPresent()) {
            Kursai kursai = optionalKursai.get();
            kursai.setPavadinimas(kursaiDto.getPavadinimas());
            kursai.setPradziosData(kursaiDto.getPradziosData());
            kursai.setPabaigosData(kursaiDto.getPabaigosData());
            kursai = kursaiRepository.save(kursai);
            return mapToDto(kursai);
        }
        return null;
    }

    @Override
    public void deleteKursai(Long id) {
        kursaiRepository.deleteById(id);
    }

    @Override
    public KursaiDto getKursaiById(Long id) {
        Optional<Kursai> optionalKursai = kursaiRepository.findById(id);
        return optionalKursai.map(this::mapToDto).orElse(null);
    }

    @Override
    public List<KursaiDto> getAllKursai() {
        List<Kursai> kursaiList = kursaiRepository.findAll();
        return kursaiList.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<KursaiDto> gautiVisusKursus() {
        return null;
    }

    @Override
    public KursaiDto sukurtiKursa(KursaiDto kursaiDto) {
        return null;
    }

    @Override
    public KursaiDto gautiKursaPagalId(Long id) {
        return null;
    }

    @Override
    public KursaiDto atnaujintiKursa(Long id, KursaiDto kursaiDto) {
        return null;
    }

    @Override
    public void istrintiKursa(Long id) {

    }

    private KursaiDto mapToDto(Kursai kursai) {
        KursaiDto kursaiDto = new KursaiDto();
        kursaiDto.setId(kursai.getId());
        kursaiDto.setPavadinimas(kursai.getPavadinimas());
        kursaiDto.setPradziosData(kursai.getPradziosData());
        kursaiDto.setPabaigosData(kursai.getPabaigosData());
        return kursaiDto;
    }
}

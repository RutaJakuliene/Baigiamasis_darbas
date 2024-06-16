package org.example.service;

import org.example.dto.KursaiDto;

import java.util.List;

public interface KursaiService {
    KursaiDto createKursai(KursaiDto kursaiDto);
    KursaiDto updateKursai(Long id, KursaiDto kursaiDto);
    void deleteKursai(Long id);
    KursaiDto getKursaiById(Long id);
    List<KursaiDto> getAllKursai();

    List<KursaiDto> gautiVisusKursus();

    KursaiDto sukurtiKursa(KursaiDto kursaiDto);

    KursaiDto gautiKursaPagalId(Long id);

    KursaiDto atnaujintiKursa(Long id, KursaiDto kursaiDto);

    void istrintiKursa(Long id);
}

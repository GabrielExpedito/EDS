package com.example.EDS.service;

import com.example.EDS.entity.Terceirizacao;
import com.example.EDS.repository.TerceirizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerceirizacaoService {

    @Autowired
    TerceirizacaoRepository terceirizacaoRepository;

    public void inserirTerceirizacao(Terceirizacao terceirizacao) {
        terceirizacaoRepository.save(terceirizacao);
    }

    public List<Terceirizacao> obterTerceirizacao() {
        return terceirizacaoRepository.findAll();
    }

    public Terceirizacao obterTerceirizacaoByID(Integer id) {
        Optional<Terceirizacao> terceirizacao = terceirizacaoRepository.findById(id);
        if (terceirizacao.isEmpty()) {
            throw new RuntimeException("Terceirização não encontrada");
        }
        return terceirizacao.get();
    }


}

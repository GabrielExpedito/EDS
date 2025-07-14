package com.example.EDS.service;

import com.example.EDS.entity.Terceirizacao;
import com.example.EDS.repository.TerceirizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerceirizacaoService {

    @Autowired
    TerceirizacaoRepository terceirizacaoRepository;

    public void inserirTerceirizacao(Terceirizacao terceirizacao) {
        terceirizacaoRepository.save(terceirizacao);
    }


}

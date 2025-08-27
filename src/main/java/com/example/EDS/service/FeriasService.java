package com.example.EDS.service;

import com.example.EDS.entity.Ferias;
import com.example.EDS.repository.FeriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeriasService {

    @Autowired
    FeriasRepository feriasRepository;

    public FeriasService(FeriasRepository feriasRepository) {
        this.feriasRepository = feriasRepository;
    }

    public List<Ferias> listarFeriasFuturas() {
        return feriasRepository.findByDtInicioAfter(LocalDate.now());
    }

    public List<Ferias> listarFeriasNoPeriodo(LocalDate inicio, LocalDate fim) {
        return feriasRepository.findByAprovadoTrueAndDtInicioBetween(inicio, fim);
    }

    public List<Ferias> listarFeriasFuncionario(Integer nre) {
        return feriasRepository.findByFuncionario_Nre(nre);
    }


}

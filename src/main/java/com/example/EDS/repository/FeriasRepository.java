package com.example.EDS.repository;

import com.example.EDS.entity.Ferias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FeriasRepository extends JpaRepository<Ferias, Integer> {

    List<Ferias> findByDtInicioGreaterThanEqual(LocalDate data);

    List<Ferias> findByAprovadoTrueAndDtInicioBetween(LocalDate inicio, LocalDate fim);

    List<Ferias> findByFuncionario_Nre(Integer nre);


}

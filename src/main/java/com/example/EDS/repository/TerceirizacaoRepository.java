package com.example.EDS.repository;

import com.example.EDS.entity.Terceirizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerceirizacaoRepository extends JpaRepository<Terceirizacao, Integer> {
}

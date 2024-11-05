package com.fiap.gerenciamento_de_trafego.repository;

import com.fiap.gerenciamento_de_trafego.model.EventoManutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoManutencaoRepository extends JpaRepository<EventoManutencao, Long> {
}


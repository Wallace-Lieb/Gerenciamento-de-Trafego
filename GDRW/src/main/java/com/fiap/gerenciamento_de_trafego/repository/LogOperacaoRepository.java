package com.fiap.gerenciamento_de_trafego.repository;

import com.fiap.gerenciamento_de_trafego.model.LogOperacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogOperacaoRepository extends JpaRepository<LogOperacao, Long> {
}

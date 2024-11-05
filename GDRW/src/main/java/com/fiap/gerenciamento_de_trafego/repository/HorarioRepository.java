package com.fiap.gerenciamento_de_trafego.repository;

import com.fiap.gerenciamento_de_trafego.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findBySemaforoId(Long idSemaforo);
}

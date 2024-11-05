package com.fiap.gerenciamento_de_trafego.service;

import com.fiap.gerenciamento_de_trafego.model.*;
import com.fiap.gerenciamento_de_trafego.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemaforoService {

    @Autowired
    private SemaforoRepository semaforoRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private EventoManutencaoRepository eventoManutencaoRepository;

    @Autowired
    private LogOperacaoRepository logOperacaoRepository;

    public List<Semaforo> getAllSemaforos() {
        return semaforoRepository.findAll();
    }

    public Semaforo createSemaforo(Semaforo semaforo) {
        return semaforoRepository.save(semaforo);
    }

    public Semaforo updateSemaforo(Long id, Semaforo semaforoAtualizado) {
        Semaforo semaforo = semaforoRepository.findById(id).orElseThrow();
        semaforo.setLocalizacao(semaforoAtualizado.getLocalizacao());
        semaforo.setEstado(semaforoAtualizado.getEstado());
        semaforo.setFluxoVeiculos(semaforoAtualizado.getFluxoVeiculos());
        return semaforoRepository.save(semaforo);
    }

    public boolean deleteSemaforo(Long id) {
        if (semaforoRepository.existsById(id)) {
            semaforoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Horario> getHorariosPorSemaforo(Long idSemaforo) {
        return horarioRepository.findBySemaforoId(idSemaforo);
    }

    public Horario createHorario(Long idSemaforo, Horario horario) {
        Semaforo semaforo = semaforoRepository.findById(idSemaforo).orElseThrow();
        horario.setSemaforo(semaforo);
        return horarioRepository.save(horario);
    }

    public EventoManutencao createEventoManutencao(Long idSemaforo, EventoManutencao evento) {
        Semaforo semaforo = semaforoRepository.findById(idSemaforo).orElseThrow();
        evento.setSemaforo(semaforo);
        return eventoManutencaoRepository.save(evento);
    }

    public LogOperacao createLogOperacao(Long idSemaforo, LogOperacao log) {
        Semaforo semaforo = semaforoRepository.findById(idSemaforo).orElseThrow();
        log.setSemaforo(semaforo);
        return logOperacaoRepository.save(log);
    }

    // Métodos para atualizar e deletar Horário, EventoManutencao e LogOperacao também podem ser adicionados aqui
}

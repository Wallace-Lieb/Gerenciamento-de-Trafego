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
    private Long semaforoId;

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

    // Métodos para atualizar e deletar Horário

    public Horario updateHorario(Long id, Horario horarioAtualizado) {
        Horario horario = horarioRepository.findById(id).orElseThrow();
        horario.setHoraInicio(horarioAtualizado.getHoraInicio());
        horario.setHoraFim(horarioAtualizado.getHoraFim());
        return horarioRepository.save(horario);
    }

    public boolean deleteHorario(Long id) {
        if (horarioRepository.existsById(id)) {
            horarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

// Métodos para atualizar e deletar EventoManutencao

    public EventoManutencao updateEventoManutencao(Long id, EventoManutencao eventoAtualizado) {
        EventoManutencao evento = eventoManutencaoRepository.findById(id).orElseThrow();
        evento.setDescricao(eventoAtualizado.getDescricao());
        evento.setDataEvento(eventoAtualizado.getDataEvento());
        return eventoManutencaoRepository.save(evento);
    }

    public boolean deleteEventoManutencao(Long id) {
        if (eventoManutencaoRepository.existsById(id)) {
            eventoManutencaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

// Métodos para atualizar e deletar LogOperacao

    public LogOperacao updateLogOperacao(Long id, LogOperacao logAtualizado) {
        LogOperacao log = logOperacaoRepository.findById(id).orElseThrow();
        log.setOperacao(logAtualizado.getOperacao());
        log.setDataLog(logAtualizado.getDataLog());
        return logOperacaoRepository.save(log);
    }

    public boolean deleteLogOperacao(Long id) {
        if (logOperacaoRepository.existsById(id)) {
            logOperacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<LogOperacao> getAllLogsOperacao(Long semaforoId) {
        return logOperacaoRepository.findBySemaforoId(semaforoId)
    }
}

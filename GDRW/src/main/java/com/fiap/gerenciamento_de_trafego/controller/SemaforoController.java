package com.fiap.gerenciamento_de_trafego.controller;

import com.fiap.gerenciamento_de_trafego.model.*;
import com.fiap.gerenciamento_de_trafego.service.SemaforoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semaforos")
public class SemaforoController {

    @Autowired
    private SemaforoService semaforoService;

    @GetMapping
    public List<Semaforo> getAllSemaforos() {
        return semaforoService.getAllSemaforos();
    }

    @PostMapping
    public Semaforo createSemaforo(@RequestBody Semaforo semaforo) {
        return semaforoService.createSemaforo(semaforo);
    }

    @PutMapping("/{id}")
    public Semaforo updateSemaforo(@PathVariable Long id, @RequestBody Semaforo semaforo) {
        return semaforoService.updateSemaforo(id, semaforo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSemaforo(@PathVariable Long id) {
        boolean isDeleted = semaforoService.deleteSemaforo(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Semáforo deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Semáforo não encontrado.");
        }
    }

    // Endpoints para Horarios

    @GetMapping("/{semaforoId}/horarios")
    public List<Horario> getAllHorarios(@PathVariable Long semaforoId) {
        return semaforoService.getAllHorarios(semaforoId);
    }

    @PostMapping("/{semaforoId}/horarios")
    public Horario createHorario(@PathVariable Long semaforoId, @RequestBody Horario horario) {
        return semaforoService.createHorario(semaforoId, horario);
    }

    @PutMapping("/horarios/{id}")
    public Horario updateHorario(@PathVariable Long id, @RequestBody Horario horario) {
        return semaforoService.updateHorario(id, horario);
    }

    @DeleteMapping("/horarios/{id}")
    public ResponseEntity<String> deleteHorario(@PathVariable Long id) {
        boolean isDeleted = semaforoService.deleteHorario(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Horário deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Horário não encontrado.");
        }
    }

    // Endpoints para Eventos de Manutenção

    @GetMapping("/{semaforoId}/eventos-manutencao")
    public List<EventoManutencao> getAllEventosManutencao(@PathVariable Long semaforoId) {
        return semaforoService.getAllEventosManutencao(semaforoId);
    }

    @PostMapping("/{semaforoId}/eventos-manutencao")
    public EventoManutencao createEventoManutencao(@PathVariable Long semaforoId, @RequestBody EventoManutencao evento) {
        return semaforoService.createEventoManutencao(semaforoId, evento);
    }

    @PutMapping("/eventos-manutencao/{id}")
    public EventoManutencao updateEventoManutencao(@PathVariable Long id, @RequestBody EventoManutencao evento) {
        return semaforoService.updateEventoManutencao(id, evento);
    }

    @DeleteMapping("/eventos-manutencao/{id}")
    public ResponseEntity<String> deleteEventoManutencao(@PathVariable Long id) {
        boolean isDeleted = semaforoService.deleteEventoManutencao(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Evento de manutenção deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Evento de manutenção não encontrado.");
        }
    }

    // Endpoints para Logs de Operação

    @GetMapping("/{semaforoId}/logs-operacao")
    public List<LogOperacao> getAllLogsOperacao(@PathVariable Long semaforoId) {
        return semaforoService.getAllLogsOperacao(semaforoId);
    }

    @PostMapping("/{semaforoId}/logs-operacao")
    public LogOperacao createLogOperacao(@PathVariable Long semaforoId, @RequestBody LogOperacao log) {
        return semaforoService.createLogOperacao(semaforoId, log);
    }

    @PutMapping("/logs-operacao/{id}")
    public LogOperacao updateLogOperacao(@PathVariable Long id, @RequestBody LogOperacao log) {
        return semaforoService.updateLogOperacao(id, log);
    }

    @DeleteMapping("/logs-operacao/{id}")
    public ResponseEntity<String> deleteLogOperacao(@PathVariable Long id) {
        boolean isDeleted = semaforoService.deleteLogOperacao(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Log de operação deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Log de operação não encontrado.");
        }
    }
}

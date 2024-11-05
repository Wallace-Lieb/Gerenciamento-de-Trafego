CREATE SEQUENCE SEQ_SEMAFORO
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE semaforo (
    id BIGINT DEFAULT SEQ_SEMAFORO.NEXTVAL PRIMARY KEY,
    localizacao VARCHAR(255) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fluxo_veiculos INTEGER NOT NULL
);

CREATE TABLE Horario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_semaforo BIGINT,
    hora_inicio TIMESTAMP,
    hora_fim TIMESTAMP,
    FOREIGN KEY (id_semaforo) REFERENCES Semaforo(id)
);

CREATE TABLE EventoManutencao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_semaforo BIGINT,
    descricao VARCHAR(255),
    data_evento TIMESTAMP,
    FOREIGN KEY (id_semaforo) REFERENCES Semaforo(id)
);

CREATE TABLE LogOperacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_semaforo BIGINT,
    operacao VARCHAR(50),
    data_log TIMESTAMP,
    FOREIGN KEY (id_semaforo) REFERENCES Semaforo(id)
);

//package com.fiap.gerenciamento_de_trafego.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
//import lombok.*;
//
//@Entity
//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//public class Semaforo {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotEmpty(message = "A localização não pode ser vazia")
//    private String localizacao;
//
//    @NotEmpty(message = "O estado não pode ser vazio")
//    private String estado;
//
//    @NotNull(message = "O fluxo de veículos não pode ser nulo")
//    private Integer fluxoVeiculos;
//}
package com.fiap.gerenciamento_de_trafego.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Semaforo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "A localização não pode ser vazia")
    private String localizacao;

    @NotEmpty(message = "O estado não pode ser vazio")
    private String estado;

    @NotNull(message = "O fluxo de veículos não pode ser nulo")
    private Integer fluxoVeiculos;

    @OneToMany(mappedBy = "semaforo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Horario> horarios;

    @OneToMany(mappedBy = "semaforo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventoManutencao> eventosManutencao;

    @OneToMany(mappedBy = "semaforo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LogOperacao> logsOperacao;
}
package com.proj.funcionarios_filial.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proj.funcionarios_filial.enums.CargoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "funcionario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idFunc;
    private String nomeFunc;
    @Column(unique = true)
    private String cpfFunc;
    private Double salarioFunc;

    @Enumerated(EnumType.STRING)
    private CargoEnum cargo;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "filial_id", //nome da coluna fk
            nullable = false
    )
    @JsonBackReference
    private FilialModel filial;

}

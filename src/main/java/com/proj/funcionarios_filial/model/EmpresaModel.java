package com.proj.funcionarios_filial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmpresaModel {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idEmpresa;
    private String nomeEmpresa;
    private String cnpjEmpresa;

    @OneToMany(
            mappedBy = "empresa",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<FilialModel> filiais;
}

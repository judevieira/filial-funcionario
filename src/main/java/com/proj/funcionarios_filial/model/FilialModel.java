package com.proj.funcionarios_filial.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "filial")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FilialModel {
    private Integer idFilial;
    private String nomeFilial;
    private String enderecoFilial;

    @OneToMany(
            mappedBy = "filial",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true // remove a Tarefa órfã ao tirá-la da lista
    )
    @JsonManagedReference
    private List<FuncionarioModel> funcionarios;

}

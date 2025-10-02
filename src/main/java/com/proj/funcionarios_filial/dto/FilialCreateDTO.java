package com.proj.funcionarios_filial.dto;

import com.proj.funcionarios_filial.model.FuncionarioModel;

import java.util.List;

public record FilialCreateDTO (
        String nomeFilial,
        String endereco,
        List<FuncionarioResponseDTO> funcionarios
){
}

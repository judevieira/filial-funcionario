package com.proj.funcionarios_filial.dto;

import com.proj.funcionarios_filial.model.FuncionarioModel;

import java.util.List;

public record FilialResponseDTO(
        Integer id, String nomeFilial, String endereco, List<FuncionarioModel> funcionarios
) {
}

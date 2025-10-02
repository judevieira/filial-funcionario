package com.proj.funcionarios_filial.dto;

import com.proj.funcionarios_filial.model.FilialModel;

import java.util.List;

public record EmpresaCreateDTO(
        String nomeEmpresa, String cnpjEmpresa, List<FilialCreateDTO> filiais
) {
}

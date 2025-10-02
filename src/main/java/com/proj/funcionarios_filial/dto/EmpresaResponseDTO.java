package com.proj.funcionarios_filial.dto;


import java.util.List;

public record EmpresaResponseDTO(
        Integer idEmpresa, String nomeEmpresa, String cnpjEmpresa, List<FilialResumoDTO> filiais
) {
}

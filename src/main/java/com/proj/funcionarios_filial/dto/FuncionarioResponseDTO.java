package com.proj.funcionarios_filial.dto;

import com.proj.funcionarios_filial.enums.CargoEnum;
import com.proj.funcionarios_filial.model.FilialModel;

public record FuncionarioResponseDTO(
        Integer idFunc, String nomeFunc, String cpfFunc, Double salarioFunc,
        CargoEnum cargo, FilialModel filial
) {
}

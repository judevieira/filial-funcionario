package com.proj.funcionarios_filial.dto;

import com.proj.funcionarios_filial.enums.CargoEnum;
import com.proj.funcionarios_filial.model.FilialModel;

public record FuncionarioCreateDTO(
        String nome, String cpf, Double salario, CargoEnum cargo, Integer filialId
) {
}

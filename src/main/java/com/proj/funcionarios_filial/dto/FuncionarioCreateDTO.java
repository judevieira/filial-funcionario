package com.proj.funcionarios_filial.dto;

import com.proj.funcionarios_filial.enums.CargoEnum;
import com.proj.funcionarios_filial.model.FilialModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionarioCreateDTO(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        Double salario,
        @NotBlank
        CargoEnum cargo,
        @NotBlank
        Integer filialId
) {
}

package com.proj.funcionarios_filial.enums;

public enum CargoEnum {
    AUXILIAR,
    ASSISTENTE,
    ANALISTA,
    GERENTE;

    public static CargoEnum from(String cargo) {
        if (cargo == null) throw new IllegalArgumentException("Cargo é obrigatório");
        try {
            return CargoEnum.valueOf(cargo.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Cargo inválido. Use um destes: AUXILIAR, ASSISTENTE, ANALISTA, GERENTE"
            );
        }
    }
}

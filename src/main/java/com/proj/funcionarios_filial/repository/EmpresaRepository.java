package com.proj.funcionarios_filial.repository;

import com.proj.funcionarios_filial.model.EmpresaModel;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {
    Optional<EmpresaModel> findByCnpjEmpresa (String cnpj);
    Optional<EmpresaModel> findByIdEmpresa (Integer id);
}

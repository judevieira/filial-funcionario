package com.proj.funcionarios_filial.repository;

import com.proj.funcionarios_filial.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
    Optional<FuncionarioModel> findByIdFunc (Integer id);
    Optional<FuncionarioModel> findByCpfFunc (String cpf);
    List<FuncionarioModel> findByFilialIdFilial (Integer id);
}
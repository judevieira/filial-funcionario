package com.proj.funcionarios_filial.repository;

import com.proj.funcionarios_filial.model.FilialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilialRepository extends JpaRepository<FilialModel, Integer> {
    Optional<FilialModel> findByIdFilial (Integer id);
    Optional<FilialModel> findByNomeFilial (String nome);

    boolean existsByIdFilial(Integer integer);
}

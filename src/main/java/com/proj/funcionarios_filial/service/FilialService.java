package com.proj.funcionarios_filial.service;

import com.proj.funcionarios_filial.dto.FuncionarioCreateDTO;
import com.proj.funcionarios_filial.model.FilialModel;
import com.proj.funcionarios_filial.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilialService {
    @Autowired
    private FilialRepository filialRepository;

}

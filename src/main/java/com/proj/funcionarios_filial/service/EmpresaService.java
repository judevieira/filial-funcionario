package com.proj.funcionarios_filial.service;

import com.proj.funcionarios_filial.dto.EmpresaCreateDTO;
import com.proj.funcionarios_filial.dto.EmpresaResponseDTO;
import com.proj.funcionarios_filial.dto.FilialResponseDTO;
import com.proj.funcionarios_filial.dto.FilialResumoDTO;
import com.proj.funcionarios_filial.model.EmpresaModel;
import com.proj.funcionarios_filial.model.FilialModel;
import com.proj.funcionarios_filial.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaResponseDTO criarEmpresa(EmpresaCreateDTO dto){
        EmpresaModel novaEmpresa = new EmpresaModel();

        novaEmpresa.setNomeEmpresa(dto.nomeEmpresa());
        novaEmpresa.setCnpjEmpresa(dto.cnpjEmpresa());
        novaEmpresa.setFiliais(new ArrayList<>());

        empresaRepository.save(novaEmpresa);

        var salva = empresaRepository.save(novaEmpresa);

        List<FilialResumoDTO> filiais = salva.getFiliais().stream().map(
                f -> new FilialResumoDTO(
                        f.getIdFilial(),
                        f.getNomeFilial(),
                        f.getEnderecoFilial()
                )).toList();

        return new EmpresaResponseDTO(novaEmpresa.getIdEmpresa(), novaEmpresa.getNomeEmpresa(), novaEmpresa.getCnpjEmpresa(), filiais);
    }

}

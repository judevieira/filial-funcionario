package com.proj.funcionarios_filial.service;

import com.proj.funcionarios_filial.dto.FuncionarioCreateDTO;
import com.proj.funcionarios_filial.dto.FuncionarioResponseDTO;
import com.proj.funcionarios_filial.model.FuncionarioModel;
import com.proj.funcionarios_filial.repository.FilialRepository;
import com.proj.funcionarios_filial.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FilialRepository filialRepository;

    public FuncionarioResponseDTO criarFuncionario (FuncionarioCreateDTO dto){

        var filial = filialRepository.findByIdFilial(dto.filialId())
                .orElseThrow(()->new IllegalArgumentException("Filial nao encontrada!"));

        FuncionarioModel novoFunc = new FuncionarioModel();

        novoFunc.setNomeFunc(dto.nome());
        novoFunc.setCpfFunc(dto.cpf());
        novoFunc.setSalarioFunc(dto.salario());
        novoFunc.setCargo(dto.cargo());
        novoFunc.setFilial(filial);

        funcionarioRepository.save(novoFunc);

        return new FuncionarioResponseDTO(novoFunc.getIdFunc(), novoFunc.getNomeFunc(),
                novoFunc.getCpfFunc(), novoFunc.getSalarioFunc(), novoFunc.getCargo(), novoFunc.getFilial());
    }

    public FuncionarioResponseDTO buscarFuncPorId(Integer id){
        var usuario = funcionarioRepository.findByIdFunc(id)
                .orElseThrow(()-> new IllegalArgumentException("Usuario não encontrado"));

        return new FuncionarioResponseDTO(usuario.getIdFunc(), usuario.getNomeFunc(),
                usuario.getCpfFunc(), usuario.getSalarioFunc(), usuario.getCargo(), usuario.getFilial());
    }

    public FuncionarioResponseDTO buscarFuncPorCpf(String cpf){
        var usuario = funcionarioRepository.findByCpfFunc(cpf)
                .orElseThrow(()-> new IllegalArgumentException("Numero de CPF não está vincilado a um funcionario!"));

        return new FuncionarioResponseDTO(usuario.getIdFunc(), usuario.getNomeFunc(),
                usuario.getCpfFunc(), usuario.getSalarioFunc(), usuario.getCargo(), usuario.getFilial());
    }

    public List<FuncionarioResponseDTO> buscarFuncionariosPorIdFilial(Integer filialId){

        if(!filialRepository.existsByIdFilial(filialId)) throw new IllegalArgumentException("Id de filial não existe!");

        return funcionarioRepository.findByFilialIdFilial(filialId)
                .stream()
                .map(f -> new FuncionarioResponseDTO(
                        f.getIdFunc(), f.getNomeFunc(), f.getCpfFunc(),
                        f.getSalarioFunc(), f.getCargo(), f.getFilial()
                )).toList();
    }


}

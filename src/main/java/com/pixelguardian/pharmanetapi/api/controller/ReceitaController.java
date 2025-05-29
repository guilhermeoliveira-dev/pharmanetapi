package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.ReceitaDTO;
import com.pixelguardian.pharmanetapi.model.entity.Funcionario;
import com.pixelguardian.pharmanetapi.model.entity.Pagamento;
import com.pixelguardian.pharmanetapi.model.entity.Receita;
import com.pixelguardian.pharmanetapi.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/receitas")
@RequiredArgsConstructor
@CrossOrigin
public class ReceitaController {

    private final FuncionarioService funcionarioService;

    public Receita converter(ReceitaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Receita receita = modelMapper.map(dto, Receita.class);
        if (dto.getIdFuncionario() != null) {
            Optional<Funcionario> funcionario = funcionarioService.getFuncionarioById(dto.getIdFuncionario());
            if (funcionario.isPresent()) {
                receita.setFuncionario(funcionario.get());
            } else {
                receita.setFuncionario(null);
            }
        }
        return receita;
    }
}

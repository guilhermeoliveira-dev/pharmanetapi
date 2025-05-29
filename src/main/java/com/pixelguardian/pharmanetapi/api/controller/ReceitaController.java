package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.ReceitaDTO;
import com.pixelguardian.pharmanetapi.api.dto.VendaDTO;
import com.pixelguardian.pharmanetapi.model.entity.Funcionario;
import com.pixelguardian.pharmanetapi.model.entity.Pagamento;
import com.pixelguardian.pharmanetapi.model.entity.Receita;
import com.pixelguardian.pharmanetapi.model.entity.Venda;
import com.pixelguardian.pharmanetapi.service.FuncionarioService;
import com.pixelguardian.pharmanetapi.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/receitas")
@RequiredArgsConstructor
@CrossOrigin
public class ReceitaController {

    private final ReceitaService service;
    private final FuncionarioService funcionarioService;

    @GetMapping()
    public ResponseEntity get() {
        List<Receita> receitas = service.getReceitas();
        return ResponseEntity.ok(receitas.stream().map(ReceitaDTO::create).collect(Collectors.toList()));
    }

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

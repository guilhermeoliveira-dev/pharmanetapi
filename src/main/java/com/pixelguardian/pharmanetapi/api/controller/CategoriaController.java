package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.CategoriaDTO;
import com.pixelguardian.pharmanetapi.api.dto.ClienteDTO;
import com.pixelguardian.pharmanetapi.model.entity.Categoria;
import com.pixelguardian.pharmanetapi.model.entity.Cliente;
import com.pixelguardian.pharmanetapi.service.CategoriaService;
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
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
@CrossOrigin
public class CategoriaController {

    private final CategoriaService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Categoria> categorias = service.getCategorias();
        return ResponseEntity.ok(categorias.stream().map(CategoriaDTO::create).collect(Collectors.toList()));
    }

    public Categoria converter(CategoriaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Categoria categoria = modelMapper.map(dto, Categoria.class);
        if (dto.getIdCategoriaPai() != null) {
            Optional<Categoria> categoriaPai = service.getCategoriaById(dto.getIdCategoriaPai());
            if (categoriaPai.isPresent()) {
                categoria.setCategoriaPai(categoriaPai.get());
            } else {
                categoria.setCategoriaPai(null);
            }
        }
        return categoria;
    }
}

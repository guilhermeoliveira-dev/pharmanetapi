package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.CategoriaDTO;
import com.pixelguardian.pharmanetapi.model.entity.Categoria;
import com.pixelguardian.pharmanetapi.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
@CrossOrigin
public class CategoriaController {

    private final CategoriaService categoriaService;

    public Categoria converter(CategoriaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Categoria categoria = modelMapper.map(dto, Categoria.class);
        if (dto.getIdCategoriaPai() != null) {
            Optional<Categoria> categoriaPai = categoriaService.getCategoriaById(dto.getIdCategoriaPai());
            if (categoriaPai.isPresent()) {
                categoria.setCategoriaPai(categoriaPai.get());
            } else {
                categoria.setCategoriaPai(null);
            }
        }
        return categoria;
    }
}

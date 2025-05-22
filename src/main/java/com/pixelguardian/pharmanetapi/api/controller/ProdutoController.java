package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.ProdutoDTO;
import com.pixelguardian.pharmanetapi.model.entity.Categoria;
import com.pixelguardian.pharmanetapi.model.entity.Produto;
import com.pixelguardian.pharmanetapi.model.entity.Tarja;
import com.pixelguardian.pharmanetapi.service.CategoriaService;
import com.pixelguardian.pharmanetapi.service.TarjaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class ProdutoController {

    private final TarjaService tarjaService;
    private final CategoriaService categoriaService;

    public Produto converter(ProdutoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Produto produto = modelMapper.map(dto, Produto.class);
        if (dto.getIdTarja() != null) {
            Optional<Tarja> tarja = tarjaService.getTarjaById(dto.getIdTarja());
            if (tarja.isPresent()) {
                produto.setTarja(tarja.get());
            } else {
                produto.setTarja(null);
            }
        }
        if (dto.getIdCategoria() != null) {
            Optional<Categoria> categoria = categoriaService.getCategoriaById(dto.getIdCategoria());
            if (categoria.isPresent()) {
                produto.setCategoria(categoria.get());
            } else {
                produto.setCategoria(null);
            }
        }
        return produto;
    }
}

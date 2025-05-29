package com.pixelguardian.pharmanetapi.api.controller;

import com.pixelguardian.pharmanetapi.api.dto.ProdutoDTO;
import com.pixelguardian.pharmanetapi.api.dto.ReceitaDTO;
import com.pixelguardian.pharmanetapi.model.entity.Categoria;
import com.pixelguardian.pharmanetapi.model.entity.Produto;
import com.pixelguardian.pharmanetapi.model.entity.Receita;
import com.pixelguardian.pharmanetapi.model.entity.Tarja;
import com.pixelguardian.pharmanetapi.service.CategoriaService;
import com.pixelguardian.pharmanetapi.service.ProdutoService;
import com.pixelguardian.pharmanetapi.service.TarjaService;
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
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
@CrossOrigin
public class ProdutoController {

    private final ProdutoService service;
    private final TarjaService tarjaService;
    private final CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity get() {
        List<Produto> produtos = service.getProdutos();
        return ResponseEntity.ok(produtos.stream().map(ProdutoDTO::create).collect(Collectors.toList()));
    }

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

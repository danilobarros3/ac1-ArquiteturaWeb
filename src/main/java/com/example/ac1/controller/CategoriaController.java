package com.example.ac1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.entity.CategoriaProduto;
import com.example.ac1.repository.CategoriaProdutoRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/arquitetura-web")
public class CategoriaController {
  private CategoriaProdutoRepository categoriaProdutoRepository;

  CategoriaController(CategoriaProdutoRepository categoriaProdutoRepository) {
    this.categoriaProdutoRepository = categoriaProdutoRepository;
  }

  @PostMapping()
  public void inserir(@RequestBody CategoriaProduto categoriaProduto) {
    categoriaProdutoRepository.inserir(categoriaProduto);
  }  

  @GetMapping()
  public List<CategoriaProduto> obterTodos() {
    return this.categoriaProdutoRepository.getAll();
  }

  
}

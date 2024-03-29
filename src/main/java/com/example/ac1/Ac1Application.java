package com.example.ac1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.entity.CategoriaProduto;
import com.example.ac1.entity.Produto;
import com.example.ac1.repository.CategoriaProdutoRepository;
import com.example.ac1.repository.ProdutoRepository;

import java.util.List;

@SpringBootApplication
public class Ac1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

	@Bean
	public CommandLineRunner init(@Autowired CategoriaProdutoRepository categoriaProdutoRepository,
		@Autowired ProdutoRepository produtoRepository
	) {
		return args -> {
			// Inserção de categorias
			categoriaProdutoRepository.inserir((new CategoriaProduto(0,"Licor","Uma bebida alcoolica adocicada")));
			categoriaProdutoRepository.inserir((new CategoriaProduto(0,"Whisky","Bebida destilada de rico")));
			categoriaProdutoRepository.inserir((new CategoriaProduto(0,"Vodka","Destilado cristalino")));
			categoriaProdutoRepository.inserir((new CategoriaProduto(0,"Cerveja","Paladares rustícos")));

			// Inserrção de  produtos
			produtoRepository.inserir((new Produto(0,2,"Licor 43")));
			produtoRepository.inserir((new Produto(0,20,"Jack de maça verde")));
			produtoRepository.inserir((new Produto(0,50,"Balalaika")));

			// Select categorias 
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.getAll();
			// List<CategoriaProduto> listaCategoriasById = categoriaProdutoRepository.getById(1);
			
			System.out.println("===== Imprimindo as listas de  categorias =====");
			listaCategorias.forEach(c -> {
				System.out.println(c.toString());
			});
			
			// PRODUTOS 
			List<Produto> listaProdutos = produtoRepository.getAll();
			Produto p1 = listaProdutos.get(0);
			Produto p2 = listaProdutos.get(1);
			Produto p3 = listaProdutos.get(2);

			p1.setCategoriaProduto(listaCategorias.get(2));
			p2.setCategoriaProduto(listaCategorias.get(2));
			p3.setCategoriaProduto(listaCategorias.get(2));

			produtoRepository.update(p1);
			produtoRepository.update(p2);
			produtoRepository.update(p3);

			System.out.println("===== Imprimindo as listas de  produtos =====");
			listaProdutos.forEach(c -> {
				System.out.println(c.toString());
			});

		};
	}
}

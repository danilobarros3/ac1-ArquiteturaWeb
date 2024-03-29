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
			@Autowired ProdutoRepository produtoRepository) {
		return args -> {
			// Inserção de categorias
			categoriaProdutoRepository.inserir((new CategoriaProduto(0, "Licor", "Uma bebida alcoolica adocicada")));
			categoriaProdutoRepository.inserir((new CategoriaProduto(0, "Whisky", "Bebida destilada de rico")));
			categoriaProdutoRepository.inserir((new CategoriaProduto(0, "Vodka", "Destilado cristalino")));
			categoriaProdutoRepository.inserir((new CategoriaProduto(0, "Cerveja", "Paladares rustícos")));

			// Inserção de produtos
			produtoRepository.inserir((new Produto(0, 2, "Licor 43")));
			produtoRepository.inserir((new Produto(0, 20, "Jack Daniels")));
			produtoRepository.inserir((new Produto(0, 50, "Balalaika")));

			// Selecionar categorias
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.getAll();

			// Exibir as categorias
			System.out.println("Listando todas as categorias:");
			listaCategorias.forEach(categoria -> {
				System.out.println(categoria.toString());
			});

			// Listar todos os produtos
			List<Produto> listaProdutos = produtoRepository.getAll();

			// Associar categorias aos produtos
			Produto produto1 = listaProdutos.get(0);
			Produto produto2 = listaProdutos.get(1);
			Produto produto3 = listaProdutos.get(2);

			produto1.setCategoriaProduto(listaCategorias.get(2));
			produto2.setCategoriaProduto(listaCategorias.get(2));
			produto3.setCategoriaProduto(listaCategorias.get(2));

			// Atualizar os produtos no repositório
			produtoRepository.update(produto1);
			produtoRepository.update(produto2);
			produtoRepository.update(produto3);

			// Exibir os produtos atualizados
			System.out.println("Listando todos os produtos:");
			listaProdutos.forEach(produto -> {
				System.out.println(produto.toString());
			});

		};
	}
}

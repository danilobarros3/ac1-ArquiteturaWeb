# Projeto de Arquitetura Web em Java

Este projeto consiste na implementação de classes de repositórios para manipulação de produtos e categorias de produtos, bem como na criação de uma classe de controle para gerenciar a inserção e exibição de categorias. Além disso, inclui um teste em console para inserir produtos e categorias, e exibir todos os registros. Por fim, também abrange a realização de chamadas HTTP utilizando o Thunder Client para inserir uma categoria e exibir todas as categorias inseridas.

## Classes de Repositórios

- `ProdutoRepository`: Classe responsável por gerenciar a manipulação de produtos no banco de dados. Possui métodos para inserir, editar, excluir, selecionar todos e selecionar por ID.

- `CategoriaProdutoRepository`: Classe responsável por gerenciar a manipulação de categorias de produtos no banco de dados. Também possui métodos para inserir, editar, excluir, selecionar todos e selecionar por ID.

## Classe `CategoriaController`

- `CategoriaController`: Classe de controle que gerencia a inserção e exibição de categorias de produtos. Contém métodos para inserir uma nova categoria e exibir todas as categorias cadastradas.

## Teste em Console

Um teste em console é realizado para inserir categorias e produtos, em seguida, exibir todos os registros, associando produtos às categorias correspondentes.

## Como Executar o Projeto

1. Clone o repositório para o seu ambiente local.

2. Certifique-se de ter as dependências necessárias instaladas, como um servidor web para execução da aplicação e uma ferramenta para fazer chamadas HTTP, como o Thunder Client.

3. Execute o aplicativo.

4. Execute o teste em console para inserir categorias e produtos e exibir todos os registros.

5. Utilize o Thunder Client para realizar a chamada HTTP, inserindo uma categoria e mostrando todas as categorias inseridas.

## Exemplo de Uso

```java
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

        // Inserção de produtos
        produtoRepository.inserir((new Produto(0,2,"Licor 43")));
        produtoRepository.inserir((new Produto(0,20,"Jack de maça verde")));
        produtoRepository.inserir((new Produto(0,50,"Balalaika")));

        // Selecionar categorias 
        List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.getAll();

        System.out.println("===== Imprimindo as listas de categorias =====");
        listaCategorias.forEach(c -> {
            System.out.println(c.toString());
        });
        
        // Produtos 
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

        System.out.println("Impressão da lista de produtos");
        listaProdutos.forEach(c -> {
            System.out.println(c.toString());
        });

    };
}

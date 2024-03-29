# Projeto de Arquitetura Web em Java

Este projeto consiste na implementação de classes de repositórios para manipulação de produtos e categorias de produtos, bem como na criação de uma classe de controle para gerenciar a inserção e exibição de categorias. Além disso, inclui um teste em console para inserir produtos e categorias, e exibir todos os registros. Por fim, também abrange a realização de chamadas HTTP utilizando o Thunder Client para inserir uma categoria e exibir todas as categorias inseridas.

## Classes de Repositórios

- `ProdutoRepository`: Classe responsável por gerenciar a manipulação de produtos no banco de dados. Possui métodos para inserir, editar, excluir, selecionar todos e selecionar por ID.

- `CategoriaProdutoRepository`: Classe responsável por gerenciar a manipulação de categorias de produtos no banco de dados. Também possui métodos para inserir, editar, excluir, selecionar todos e selecionar por ID.

## Classe `CategoriaController`

- `CategoriaController`: Classe de controle que gerencia a inserção e exibição de categorias de produtos. Contém métodos para inserir uma nova categoria e exibir todas as categorias cadastradas.

## Teste em Console

Um teste em console é realizado para inserir categorias e produtos, em seguida, exibir todos os registros, associando produtos às categorias correspondentes.

## Classes de Entidade

### `Produto`

A classe `Produto` representa um produto em estoque. Ela possui atributos como ID, quantidade em estoque, nome e uma referência à categoria à qual o produto pertence. Essa classe inclui métodos para obter e definir os atributos do produto.

### `CategoriaProduto`

A classe `CategoriaProduto` representa uma categoria de produtos. Ela possui atributos como ID, nome e descrição da categoria, bem como uma lista de produtos associados a essa categoria. Além disso, inclui métodos para obter e definir os atributos da categoria.


## Como Executar o Projeto

1. Clone o repositório para o seu ambiente local.

2. Certifique-se de ter as dependências necessárias instaladas, como um servidor web para execução da aplicação e uma ferramenta para fazer chamadas HTTP, como o Thunder Client.

3. Execute o aplicativo.

4. Execute o teste em console para inserir categorias e produtos e exibir todos os registros.

5. Utilize o Thunder Client para realizar a chamada HTTP, inserindo uma categoria e mostrando todas as categorias inseridas.


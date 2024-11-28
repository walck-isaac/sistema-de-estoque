package com.supermercado.controller;

import com.supermercado.model.Produto;
import com.supermercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController //Informa ao Spring que essa classe é um controlador REST, responsável por responder a requisições HTTP
@RequestMapping("/api/produtos") //Define que todas as URLs começando com /api/produtos serão tratadas por esse controlador
public class ProdutoController { //Função responsavel por manter os controles do CRUD.

    @Autowired //Usado para a utilização das instâncias do ProdutoService.
    private ProdutoService produtoService;

    @PostMapping //Indica que este método responde a requisições HTTP POST.
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {  // O parâmetro @ResquestBody é deserializado do corpo da requisição JSON para um objeto Produto.
        Produto novoProduto = produtoService.criarProduto(produto);
        return ResponseEntity.ok(novoProduto); //Retorna uma resposta HTTP 200 OK com o novo produto criado.
    }

    @GetMapping  //Indica que este método responde a requisições HTTP GET.
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoService.buscarTodosProdutos(); // Busca todos os produtos disponiveis no banco
        return ResponseEntity.ok(produtos); //Retorna uma lista de produtos com status HTTP 200 OK.
    }

    @GetMapping("/{codigoBarras}") //Mapeia para URLs que incluam o código de barras do produto.
    public ResponseEntity<Produto> buscarProduto(@PathVariable String codigoBarras) { //@PathVariable extrai o valor {codigoBarras} da URL.
        return produtoService.buscarProdutoPorId(codigoBarras) //Pesquisa de um produto expecifico pelo código de barras.
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build()); //Tratativa de erro.
    }

    @PutMapping("/{codigoBarras}") //Indica que este método responde a requisições HTTP PUT.
    public ResponseEntity<Produto> atualizarProduto(@PathVariable String codigoBarras, @RequestBody Produto produto) { //Usa o código de barras e o corpo da requisição para atualizar o produto existente.
        Produto produtoAtualizado = produtoService.atualizarProduto(codigoBarras, produto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{codigoBarras}") //Indica que este método responde a requisições HTTP DELETE.
    public ResponseEntity<Void> excluirProduto(@PathVariable String codigoBarras) {
        produtoService.excluirProduto(codigoBarras);
        return ResponseEntity.noContent().build(); //Retorna uma resposta HTTP 204 No Content.
    }

    @GetMapping("/nome/{nome}") //Mapeia para URLs que incluam o nome do produto.
    public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome) {
        List<Produto> produtos = produtoService.buscarProdutosPorNome(nome);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/categoria/{categoria}") //Mapeia para URLs que incluam a categoria do produto.
    public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable String categoria) {
        List<Produto> produtos = produtoService.buscarProdutosPorCategoria(categoria);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/preco-abaixo/{preco}") //Mapeia para URLs que incluam o preço limite.
    public ResponseEntity<List<Produto>> buscarAbaixoPreco(@PathVariable BigDecimal preco) {
        List<Produto> produtos = produtoService.buscarProdutosAbaixoPreco(preco);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/estoque-baixo/{quantidade}") //Mapeia para URLs que incluam a quantidade limite.
    public ResponseEntity<List<Produto>> buscarEstoqueBaixo(@PathVariable Integer quantidade) {
        List<Produto> produtos = produtoService.buscarProdutosEstoqueBaixo(quantidade);
        return ResponseEntity.ok(produtos);
    }

    @PatchMapping("/{codigoBarras}/estoque") // Indica que este método responde a requisições HTTP PATCH.
    public ResponseEntity<Produto> atualizarEstoque(@PathVariable String codigoBarras, @RequestParam Integer quantidade) { //@RequestParam Integer quantidade: Recebe a quantidade como parâmetro da requisição.
        Produto produtoAtualizado = produtoService.atualizarEstoque(codigoBarras, quantidade);
        return ResponseEntity.ok(produtoAtualizado);
        //Atualiza a quantidade em estoque do produto especificado.
    }
}


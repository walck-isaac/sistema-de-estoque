package com.supermercado.service; //Define que esta classe faz parte do pacote com.supermercado.service.

//Importa as classes e interfaces necessárias.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermercado.model.Produto;
import com.supermercado.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(String codigoBarras) {
        return produtoRepository.findById(codigoBarras);
    }

    public Produto atualizarProduto(String codigoBarras, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(codigoBarras)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setDataValidade(produtoAtualizado.getDataValidade());
        return produtoRepository.save(produto);
    }

    public void excluirProduto(String codigoBarras) {
        produtoRepository.deleteById(codigoBarras);
    }

    public List<Produto> buscarProdutosPorNome(String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    public List<Produto> buscarProdutosPorCategoria(String categoria) {
        return produtoRepository.findByCategoria(categoria);
    }

    public List<Produto> buscarProdutosAbaixoPreco(BigDecimal preco) {
        return produtoRepository.findByPrecoLessThan(preco);
    }

    public List<Produto> buscarProdutosEstoqueBaixo(Integer quantidade) {
        return produtoRepository.findByQuantidadeLessThan(quantidade);
    }

    public Produto atualizarEstoque(String codigoBarras, Integer quantidade) {
        Produto produto = produtoRepository.findById(codigoBarras)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setQuantidade(quantidade);
        return produtoRepository.save(produto);
    }
}

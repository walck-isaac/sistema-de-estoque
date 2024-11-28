package com.supermercado.repository; //Define que esta interface faz parte do pacote

//Importa as classes e interfaces necessárias.
import com.supermercado.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository //Indica que esta interface é um repositório Spring. Repositórios são componentes que encapsulam a lógica de acesso ao banco de dados.
public interface ProdutoRepository extends JpaRepository<Produto, String> {
    List<Produto> findByNomeContaining(String nome);
    List<Produto> findByCategoria(String categoria);
    List<Produto> findByPrecoLessThan(BigDecimal preco);
    List<Produto> findByQuantidadeLessThan(Integer quantidade);
}

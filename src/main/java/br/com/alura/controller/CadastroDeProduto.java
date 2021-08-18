package br.com.alura.controller;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {

        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produto = new ProdutoDao(em);

        Produto p = produto.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> todos = produto.buscarPorNomeDaCategoria("CELULARES");
        todos.forEach(p2 -> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produto.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
        System.out.println("Preço do produto: " + precoDoProduto);


    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES") ;
        Produto celular =
                new Produto("Xiaomi Redmi", "Décima geração",
                        new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin(); //Devido o Transaction ser local Resource Local, temos que inicar a transaction
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }


}

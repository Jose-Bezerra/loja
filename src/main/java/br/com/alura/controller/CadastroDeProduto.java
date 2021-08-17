package br.com.alura.controller;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {

        Produto celular =
                new Produto("Xiaomi Redmi", "Décima geração",
                        new BigDecimal("800"), Categoria.CELULARES);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin(); //Devido o Transaction ser local Resource Local, temos que inicar a transaction
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();

    }


}

package br.com.alura.controller;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {

        Categoria celulares = new Categoria("CELULARES") ;


        EntityManager em = JPAUtil.getEntityManager();


        em.getTransaction().begin(); //Devido o Transaction ser local Resource Local, temos que inicar a transaction

        em.persist(celulares); // Sai do estado Transient para o Managed
        celulares.setNome("XPTO");

        em.flush(); //atualiza banco de dados sem finalizar a transação. O Commit
        //finalizaria a transação
        em.clear(); //limpa entidades gerenciadas

        celulares = em.merge(celulares);
        celulares.setNome("1234");
        em.flush();
        em.clear();
        em.remove(celulares);
        em.flush();

    }


}

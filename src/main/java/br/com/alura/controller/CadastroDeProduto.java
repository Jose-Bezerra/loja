package br.com.alura.controller;

import br.com.alura.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {

        Produto celular = new Produto();
        celular.setNome("Xiaomi Redmi");
        celular.setDescricao("Décima geração");
        celular.setPreco(new BigDecimal("800"));

        //EntityManager é uma interface, logo nãopodemos dar new EntityManager().
        //Poderíamos instanciar uma classe que impplementa o interface
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("loja");
        EntityManager em  = factory.createEntityManager();

        em.getTransaction().begin(); //Devido o Transaction ser local Resource Local, temos que inicar a transaction
        em.persist(celular);
        em.getTransaction().commit();
        em.close();

    }


}

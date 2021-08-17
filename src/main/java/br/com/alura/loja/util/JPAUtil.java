package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//EntityManager é uma interface, logo não podemos dar new EntityManager().
//Poderíamos instanciar uma classe que implementa o interface
public class JPAUtil {
    private static final EntityManagerFactory FACTORY =  Persistence
            .createEntityManagerFactory("loja");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}

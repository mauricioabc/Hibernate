package com.hibernate.Main;

import com.hibernate.Entities.Pedido;
import com.hibernate.Entities.Produto;
import com.hibernate.Entities.ProdutoPedido;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        //Cria produtos com nome e preço
        Produto produto1 = new Produto("Pão", 2.90);
        Produto produto2 = new Produto("Café", 13.90);
        
        //Criado pedido com nome do cliente e data
        Pedido pedido = new Pedido("João", "09/04/2023");
        
        //Cria a relação pedido produto, um pedido contém n produtos
        ProdutoPedido item1 = new ProdutoPedido(pedido, produto1, 2);
        ProdutoPedido item2 = new ProdutoPedido(pedido, produto2, 3);

        //Salva os dados no banco de dados
        em.getTransaction().begin();
        em.persist(produto1);
        em.persist(produto2);
        em.persist(pedido);
        em.persist(item1);
        em.persist(item2);
        em.getTransaction().commit();

        em.close();
        emf.close();
        
    }
}

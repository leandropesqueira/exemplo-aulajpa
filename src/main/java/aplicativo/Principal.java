package aplicativo;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

    public static void main(String[] args) {

//        Pessoa p1 = new Pessoa(null, "Maria Antonia", "maria@gmail.com");
//        Pessoa p2 = new Pessoa(null, "Joaquim Duarte", "joaquim@hotmail.com");
//        Pessoa p3 = new Pessoa(null, "Ana Maria", "anamaria@uol.com.br");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//        em.getTransaction().commit();
        Pessoa p = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        System.out.println("Pronto!");
        em.close();
        emf.close();
    }
}

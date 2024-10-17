package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.*;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashopdb");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction tx =  em.getTransaction();
        tx.begin();
        try{

            Book book = new Book();
            book.setName("JPA교재");
            book.setAuthor("김영한");
            em.persist(book);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

package jpabook.jpashop;

import javax.persistence.*;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashopdb");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction tx =  em.getTransaction();
        tx.begin();
        try{
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

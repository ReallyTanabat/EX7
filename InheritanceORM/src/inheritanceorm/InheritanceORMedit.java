/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceorm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

/**
 *
 * @author Tanabat
 */
public class InheritanceORMedit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FulltimeEmployee emp1 = new FulltimeEmployee();
        System.out.print("Please Enter Your name 1 : ");
        String name1 = in.nextLine();
        emp1.setName(name1);
        emp1.setSalary(5000);
        ParttimeEmployee emp2 = new ParttimeEmployee();
        System.out.print("Please Enter Your name  : ");
        String name2 = in.nextLine();
        emp1.setName(name2);
        emp2.setHoursWork(4);
        persist(emp1);
        persist(emp2);
        emp1.remove(name1);
                
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public class remove{
    private String remove;

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }
    }
    
}

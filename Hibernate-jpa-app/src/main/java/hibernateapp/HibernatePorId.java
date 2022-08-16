package hibernateapp;

import hibernateapp.entity.Cliente;
import hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class HibernatePorId {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        /*
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.id=?1", Cliente.class);
        System.out.print("Ingrese una id: ");
        Long id = s.nextLong();
        query.setParameter(1, id);
        query.setMaxResults(1);
        Cliente c = (Cliente) query.getSingleResult();
        System.out.println(c);
        em.close();*/

        System.out.print("Ingrese el id: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);
        em.close();
    }
}

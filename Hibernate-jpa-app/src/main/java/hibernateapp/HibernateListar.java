package hibernateapp;

import hibernateapp.entity.Cliente;
import jakarta.persistence.EntityManager;
import hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}

package hibernateapp;
import com.mysql.cj.log.Log;
import hibernateapp.dominio.ClienteDto;
import hibernateapp.entity.Cliente;
import hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.List;


public class HibernateQL {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("===== Consultar todos =====");
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("===== Consulta por id =====");
        Cliente cliente = em.createQuery("SELECT c FROM Cliente c WHERE c.id=:id", Cliente.class)
                .setParameter("id",1L)
                .getSingleResult();
        System.out.println(cliente);

        System.out.println("===== Consulta solo el nombre por el id =====");
        String nombreCliente = em.createQuery("SELECT c.nombre FROM Cliente c WHERE c.id=:id", String.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(nombreCliente);

        System.out.println("===== Consulta por campos personalizados =====");
        Object[] objetoCliente = em.createQuery("SELECT c.id, c.nombre, c.apellido FROM Cliente c WHERE c.id=:id", Object[].class)
                .setParameter("id", 1L)
                .getSingleResult();
        Long id = (Long) objetoCliente[0];
        String nombre = (String) objetoCliente[1];
        String apellido = (String) objetoCliente[2];
        System.out.println("id: " + id + ", nombre: " + nombre + ", apellido: " + apellido);

        System.out.println("========= consulta por campos personalizados lista ==========");
        List<Object[]> registros = em.createQuery("SELECT c.id, c.nombre, c.apellido FROM Cliente c", Object[].class)
                .getResultList();
        registros.forEach(reg -> {
            Long idCli = (Long) reg[0];
            String nombreCli = (String) reg[1];
            String apellidoCli = (String) reg[2];
            System.out.println("id: " + idCli + ", nombre: " + nombreCli + ", apellido: " + apellidoCli);
        });

        //nombre y forma de pago
        System.out.println("============ consulta por cliente y forma de pago");
        registros = em.createQuery("SELECT c, c.formaPago FROM Cliente c", Object[].class)
                        .getResultList();
        registros.forEach(reg -> {
            Cliente c = (Cliente) reg[0];
            String formaPago = (String) reg[1];
            System.out.println("formaPago:" + formaPago+ ", " + c);
        });

        System.out.println("===== consulta que puebla y devuelve objeto entity de una clase personalizada");
        clientes = em.createQuery("SELECT new Cliente(c.nombre, c.apellido) FROM Cliente c", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("===== consulta que puebla y devuelve objeto otro de una clase personalizada");
        List<ClienteDto> clientesDto = em.createQuery("SELECT new hibernateapp.dominio.ClienteDto(c.nombre, c.apellido) " +
                "FROM Cliente c", ClienteDto.class).getResultList();
        clientesDto.forEach(System.out::println);

        System.out.println("===== consulta con nombres de clientes =====");
        List<String> nombres = em.createQuery("SELECT c.nombre FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("==== consulta con nombres unicos de clientes =====");
        nombres = em.createQuery("SELECT DISTINCT(c.nombre) FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("==== consulta con formas de pago unicas =====");
        List<String> formasPago = em.createQuery("SELECT DISTINCT(c.formaPago) FROM Cliente c", String.class)
                .getResultList();
        formasPago.forEach(System.out::println);

        System.out.println("===== consulta con numero de formas de pago unicas ======");
        Long totalFormasPago = em.createQuery("SELECT COUNT (DISTINCT c.formaPago) FROM Cliente c", Long.class)
                .getSingleResult();
        System.out.println(totalFormasPago);

        System.out.println("===== consulta con nombre y apellido concatenados =======");
        /*nombres = em.createQuery("SELECT CONCAT(c.nombre, ' ', c.apellido) AS nombreCompleto FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);*/

        nombres = em.createQuery("SELECT c.nombre || ' ' || c.apellido AS nombreCompleto FROM Cliente c", String.class)
                .getResultList();

        nombres.forEach(System.out::println);

        System.out.println("=== consulta con nombre y apellido concatenados en mayuscula ========");
        nombres = em.createQuery("SELECT UPPER(CONCAT(c.nombre, ' ', c.apellido)) AS nombreCompleto FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("====== consulta para buscar por nombre ======");
        String param = "NA";
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE UPPER(c.nombre) LIKE UPPER(:parametro)", Cliente.class)
                .setParameter("parametro", "%" + param + "%")
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("==== consultas por rangos =====");
        //clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.id BETWEEN 2 AND 5", Cliente.class).getResultList();
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre BETWEEN 'J' AND 'Q'", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("========= consulta con orden ==========");
        clientes = em.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre ASC, c.apellido ASC",
                Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("===== consulta con total de registros de la tabla ===========");
        Long total = em.createQuery("SELECT COUNT(c) AS total FROM Cliente c", Long.class)
                .getSingleResult();
        System.out.println(total);

        System.out.println("==== consulta con valor minimo del id ======");
        Long minId = em.createQuery("SELECT MIN(c.id) AS minimo FROM Cliente c", Long.class).getSingleResult();
        System.out.println(minId);

        System.out.println("============ consulta con max/ultimo id ===========");
        Long maxId = em.createQuery("SELECT MAX(c.id) AS maximo FROM Cliente c", Long.class).getSingleResult();
        System.out.println(maxId);

        System.out.println("======== consulta con nombre y su largo ========");
        registros = em.createQuery("SELECT c.nombre, LENGTH(c.nombre) FROM Cliente c", Object[].class).getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre: " + nom + ", largo: " + largo);
        });

        System.out.println("============ consulta con el nombre mas corto ===========");
        Integer minLargoNombre = em.createQuery("SELECT MIN(LENGTH(c.nombre)) FROM Cliente c", Integer.class)
                .getSingleResult();
        System.out.println(minLargoNombre);

        System.out.println("============= consulta con el nombre mas largo =============");
        Integer maxLargoNombre = em.createQuery("SELECT MAX(LENGTH(c.nombre)) FROM Cliente c", Integer.class)
                .getSingleResult();
        System.out.println(maxLargoNombre);

        System.out.println("======= consultas resumen funciones agregadas count min max avg sum ===========");
        Object[] estadisticas = em.createQuery("SELECT MIN(c.id), MAX (c.id), SUM(c.id), COUNT(c.id)," +
                        " AVG(LENGTH(c.nombre)) FROM Cliente c", Object[].class).getSingleResult();
        Long min = (Long) estadisticas[0];
        Long max = (Long) estadisticas[1];
        Long sum = (Long) estadisticas[2];
        Long count = (Long) estadisticas[3];
        Double avg = (Double) estadisticas[4];
        System.out.println("min: " + min + ", max: " + max + ", sum: " + sum + ", count: " + count + ", avg: " + avg);

        System.out.println("========= consulta con el nombre mas corto y su largo =========");
        registros = em.createQuery("SELECT c.nombre, LENGTH(c.nombre) FROM Cliente c WHERE " +
                "LENGTH(c.nombre) = (SELECT MIN(LENGTH(c.nombre)) FROM Cliente c)", Object[].class)
                .getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre: " + nom + ", largo: " + largo);
        });

        System.out.println("======== consulta para obtener el ultimo registro =========");
        Cliente ultimoCliente = em.createQuery("SELECT c FROM Cliente c WHERE c.id = (SELECT MAX(c.id) FROM Cliente c)",
                Cliente.class).getSingleResult();
        System.out.println(ultimoCliente);

        System.out.println("========= consulta where in ===========");
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.id in :ids", Cliente.class)
                .setParameter("ids", Arrays.asList(1L, 3L, 4L, 5L))
                .getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}
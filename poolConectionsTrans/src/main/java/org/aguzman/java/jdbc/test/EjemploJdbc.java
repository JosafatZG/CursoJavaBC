package org.aguzman.java.jdbc.test;
import org.aguzman.java.jdbc.dao.CategoriaRepositorioImpl;
import org.aguzman.java.jdbc.dao.ConexionBaseDatos;
import org.aguzman.java.jdbc.dao.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.dao.Repositorio;
import org.aguzman.java.jdbc.dto.Categoria;
import org.aguzman.java.jdbc.dto.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {
                Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                System.out.println("=============== insertar nueva categoria ====================");
                Categoria categoria = new Categoria();
                categoria.setNombre("Electrohogar");
                Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                System.out.println("Categoria guardada con exito: " + nuevaCategoria.getId());

                System.out.println("=============== listar categorias ====================");
                repositorioCategoria.listar().forEach(System.out::println);

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                System.out.println("============== listar productos ============");
                repositorio.listar().forEach(System.out::println);

                System.out.println("=============== obtener por id ===============");
                System.out.println(repositorio.porId(1L));

                /*
                System.out.println("======================= insertar nuevo producto =======================");
                Producto producto = new Producto();
                producto.setNombre("Notebook Omen HP");
                producto.setPrecio(2900);
                producto.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito");
                repositorio.listar().forEach(System.out::println);*/

                /*

                System.out.println("================ Actualizando producto =================");
                Producto producto = new Producto();
                producto.setId(2L);
                producto.setNombre("Ventilador Gamer");
                producto.setPrecio(500);
                producto.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                repositorioProducto.guardar(producto);
                System.out.println("Producto guardado con exito");
                repositorioProducto.listar().forEach(System.out::println);

                System.out.println("================= eliminar producto ====================");
                repositorioProducto.eliminar(3L);
                System.out.println("Producto eliminado con exito");
                repositorioProducto.listar().forEach(System.out::println);*/

                System.out.println("========== insertar nuevo producto ===============");
                Producto producto = new Producto();
                producto.setNombre("Refrigerador Samsung");
                producto.setPrecio(9900);
                producto.setFechaRegistro(new Date());
                producto.setSku("abcdefg123");

                producto.setCategoria(nuevaCategoria);
                repositorio.guardar(producto);
                System.out.println("Producto guardado con éxito: " + producto.getId());
                repositorio.listar().forEach(System.out::println);

                conn.commit();
            } catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}

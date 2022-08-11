package org.aguzman.java.jdbc.test;
import org.aguzman.java.jdbc.dao.CategoriaRepositorioImpl;
import org.aguzman.java.jdbc.dao.ConexionBaseDatos;
import org.aguzman.java.jdbc.dao.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.dao.Repositorio;
import org.aguzman.java.jdbc.dto.Categoria;
import org.aguzman.java.jdbc.dto.Producto;
import org.aguzman.java.jdbc.servicio.CatalogoServicio;
import org.aguzman.java.jdbc.servicio.Servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        Servicio servicio = new CatalogoServicio();
        System.out.println("=================== listar ==============");
        servicio.listar().forEach(System.out::println);
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");

        Producto producto = new Producto();
        producto.setNombre("Lampara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefgh12");
        servicio.guardarProductoConCategoria(producto, categoria);
        System.out.println("Producto guardado con exito: " + producto.getId());
        servicio.listar().forEach(System.out::println);
    }
}

package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.excepciones.*;

public interface CatalogoPeliculas {
    public abstract void agregar(String nombrePelicula, String nombreArchivo) throws EscrituraDatosEx;
    public abstract void listarPeliculas(String nombreArchivo) throws LecturaDatosEx;
    public abstract void buscarPelicula(String nombreArchivo, String buscar) throws LecturaDatosEx;
    public abstract void iniciarArchivo(String nombreArchivo) throws AccesoDatosEx;
}

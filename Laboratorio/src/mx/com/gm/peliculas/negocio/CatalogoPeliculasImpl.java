package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.excepciones.*;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{

    private AccesoDatos datos;
    @Override
    public void agregar(String nombrePelicula, String nombreArchivo) throws EscrituraDatosEx {

    }

    @Override
    public void listarPeliculas(String nombreArchivo) throws LecturaDatosEx {

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) throws LecturaDatosEx {

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) throws AccesoDatosEx {

    }
}

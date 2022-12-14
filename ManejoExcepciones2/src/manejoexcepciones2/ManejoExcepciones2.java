package manejoexcepciones2;
import datos.*;
import excepciones.*;

public class ManejoExcepciones2 {

    public static void main(String[] args) {

        AccesoDatos datos = new ImplementacionMySql();
        datos.simularError(true);
        ejecutar(datos, "listar");

        datos.simularError(true);
        System.out.println("");
        ejecutar(datos, "insertar");
    }

    public static void ejecutar(AccesoDatos datos, String accion){
        if("listar".equals(accion)){
            try{
                datos.listar();
            } catch (LecturaDatosEx ex){
                System.out.println("Error lectura: Procesa la excepción mas" +
                        " especifica de lectura de datos");
            } catch (AccesoDatosEx ex){
                System.out.println("Error acceso datos: Procesa la excepcion más" +
                        " generica de acceso a datos");
            } catch (Exception ex){
                System.out.println("Error general");
            } finally {
                System.out.println("Procesar finally es opcional, siempre se" +
                        " ejecutara sin importar si hubo error o no");
            }
        } else if ("insertar".equals(accion)){
            try{
                datos.insertar();
            } catch (AccesoDatosEx ex){
                System.out.println("Error acceso datos: Procesa la excepcion más" +
                        " generica de acceso a datos");
            } finally {
                System.out.println("Procesar finally es opcional, siempre se" +
                        " ejecutara sin importar si hubo error o no");
            }
        } else {
            System.out.println("No se proporciono ninguna accion conocida");
        }
    }
}

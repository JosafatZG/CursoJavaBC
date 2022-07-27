package excepciones;
import datos.*;
import ejercicioexcepciones.*;

public class ManejoExcepciones {
    public static void main(String[] args) {
        AccesoDatos mysql = new ImplementacionMySql();
        AccesoDatos oracle = new ImplementacionOracle();
        AccesoDatos postgresql = new ImplementacionPostgreSql();
        AccesoDatos sqlserver = new ImplementacionSqlServer();

        mysql.simularError(true);
        oracle.simularError(false);
        postgresql.simularError(false);
        sqlserver.simularError(true);

        ejecutar(mysql, "create");
        ejecutar(oracle, "read");
        ejecutar(postgresql, "update");
        ejecutar(sqlserver, "delete");
    }

    public static void ejecutar(AccesoDatos datos, String accion){
        switch (accion){
            case "create":
                create(datos);
                break;
            case "read":
                read(datos);
                break;
            case "update":
                update(datos);
                break;
            case "delete":
                delete(datos);
                break;
            default:
        }
    }

    public static void create(AccesoDatos datos){
        try {
            datos.create();
        } catch (CreateDatosEx cd){
            System.out.println("Error create");
            System.out.println(cd.getMessage());
        } catch (ReadDatosEx rd){
            System.out.println("Error read");
            System.out.println(rd.getMessage());
        } catch (UpdateDatosEx ud){
            System.out.println("Error update");
            System.out.println(ud.getMessage());
        } catch (DeleteDatosEx dd){
            System.out.println("Error delete");
            System.out.println(dd.getMessage());
        } catch (AccesoDatosEx e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Comprobación terminada\n");
        }
    }

    public static void read(AccesoDatos datos){
        try {
            datos.read();
        } catch (CreateDatosEx cd){
            System.out.println("Error create");
            System.out.println(cd.getMessage());
        } catch (ReadDatosEx rd){
            System.out.println("Error read");
            System.out.println(rd.getMessage());
        } catch (UpdateDatosEx ud){
            System.out.println("Error update");
            System.out.println(ud.getMessage());
        } catch (DeleteDatosEx dd){
            System.out.println("Error delete");
            System.out.println(dd.getMessage());
        } catch (AccesoDatosEx e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Comprobación terminada\n");
        }
    }

    public static void update(AccesoDatos datos){
        try {
            datos.update();
        } catch (CreateDatosEx cd){
            System.out.println("Error create");
            System.out.println(cd.getMessage());
        } catch (ReadDatosEx rd){
            System.out.println("Error read");
            System.out.println(rd.getMessage());
        } catch (UpdateDatosEx ud){
            System.out.println("Error update");
            System.out.println(ud.getMessage());
        } catch (DeleteDatosEx dd){
            System.out.println("Error delete");
            System.out.println(dd.getMessage());
        } catch (AccesoDatosEx e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Comprobación terminada\n");
        }
    }

    public static void delete(AccesoDatos datos){
        try {
            datos.delete();
        } catch (CreateDatosEx cd){
            System.out.println("Error create");
            System.out.println(cd.getMessage());
        } catch (ReadDatosEx rd){
            System.out.println("Error read");
            System.out.println(rd.getMessage());
        } catch (UpdateDatosEx ud){
            System.out.println("Error update");
            System.out.println(ud.getMessage());
        } catch (DeleteDatosEx dd){
            System.out.println("Error delete");
            System.out.println(dd.getMessage());
        } catch (AccesoDatosEx e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Comprobación terminada\n");
        }
    }
}

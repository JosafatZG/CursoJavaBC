package datos;

import ejercicioexcepciones.*;

public class ImplementacionPostgreSql implements AccesoDatos{

    private boolean simularError;
    @Override
    public void create() throws AccesoDatosEx {
        if(simularError){
            throw new CreateDatosEx("Error de Create en PostgreSql");
        } else {
            System.out.println("Create desde PostgreSql");
        }
    }

    @Override
    public void read() throws AccesoDatosEx {
        if(simularError){
            throw new ReadDatosEx("Error de Read en PostgreSql");
        } else {
            System.out.println("Read desde PostgreSql");
        }
    }

    @Override
    public void update() throws AccesoDatosEx {
        if(simularError){
            throw new UpdateDatosEx("Error de Update en PostgreSql");
        } else {
            System.out.println("Update desde PostgreSql");
        }
    }

    @Override
    public void delete() throws AccesoDatosEx {
        if(simularError){
            throw new DeleteDatosEx("Error de Delete en PostgreSql");
        } else {
            System.out.println("Delete desde PostgreSql");
        }
    }

    @Override
    public void simularError(boolean simularError) {
        this.simularError = simularError;
    }
}

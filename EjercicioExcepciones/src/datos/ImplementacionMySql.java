package datos;

import ejercicioexcepciones.*;

public class ImplementacionMySql implements AccesoDatos{

    private boolean simularError;
    @Override
    public void create() throws AccesoDatosEx {
        if(simularError){
            throw new CreateDatosEx("Error de Create en MySql");
        } else {
            System.out.println("Create desde MySql");
        }
    }

    @Override
    public void read() throws AccesoDatosEx {
        if(simularError){
            throw new ReadDatosEx("Error de Read en MySql");
        } else {
            System.out.println("Read desde MySql");
        }
    }

    @Override
    public void update() throws AccesoDatosEx {
        if(simularError){
            throw new UpdateDatosEx("Error de Update en MySql");
        } else {
            System.out.println("Update desde MySql");
        }
    }

    @Override
    public void delete() throws AccesoDatosEx {
        if(simularError){
            throw new DeleteDatosEx("Error de Delete en MySql");
        } else {
            System.out.println("Delete desde MySql");
        }
    }

    @Override
    public void simularError(boolean simularError) {
        this.simularError = simularError;
    }
}

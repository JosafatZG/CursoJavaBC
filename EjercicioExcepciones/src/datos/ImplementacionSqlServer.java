package datos;

import ejercicioexcepciones.*;

public class ImplementacionSqlServer implements AccesoDatos{

    private boolean simularError;
    @Override
    public void create() throws AccesoDatosEx {
        if(simularError){
            throw new CreateDatosEx("Error de Create en SqlServer");
        } else {
            System.out.println("Create desde SqlServer");
        }
    }

    @Override
    public void read() throws AccesoDatosEx {
        if(simularError){
            throw new ReadDatosEx("Error de Read en SqlServer");
        } else {
            System.out.println("Read desde SqlServer");
        }
    }

    @Override
    public void update() throws AccesoDatosEx {
        if(simularError){
            throw new CreateDatosEx("Error de Update en SqlServer");
        } else {
            System.out.println("Update desde SqlServer");
        }
    }

    @Override
    public void delete() throws AccesoDatosEx {
        if(simularError){
            throw new CreateDatosEx("Error de Delete en SqlServer");
        } else {
            System.out.println("Delete desde SqlServer");
        }
    }

    @Override
    public void simularError(boolean simularError) {
        this.simularError = simularError;
    }
}

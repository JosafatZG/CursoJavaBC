package datos;

import ejercicioexcepciones.*;

public class ImplementacionOracle implements AccesoDatos{

    private boolean simularError;
    @Override
    public void create() throws AccesoDatosEx {
        if(simularError){
            throw new CreateDatosEx("Error de Create en Oracle");
        } else {
            System.out.println("Create desde Oracle");
        }
    }

    @Override
    public void read() throws AccesoDatosEx {
        if(simularError){
            throw new ReadDatosEx("Error de Read en Oracle");
        } else {
            System.out.println("Read desde Oracle");
        }
    }

    @Override
    public void update() throws AccesoDatosEx {
        if(simularError){
            throw new UpdateDatosEx("Error de Update en Oracle");
        } else {
            System.out.println("Update desde Oracle");
        }
    }

    @Override
    public void delete() throws AccesoDatosEx {
        if(simularError){
            throw new DeleteDatosEx("Error de Delete en Oracle");
        } else {
            System.out.println("Delete desde Oracle");
        }
    }

    @Override
    public void simularError(boolean simularError) {
        this.simularError = simularError;
    }
}

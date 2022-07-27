package datos;

import ejercicioexcepciones.AccesoDatosEx;

public interface AccesoDatos {
    public abstract void create() throws AccesoDatosEx;
    public abstract void read() throws AccesoDatosEx;
    public abstract void update() throws AccesoDatosEx;
    public abstract void delete() throws AccesoDatosEx;
    public abstract void simularError(boolean simularError);
}

package service;

import dto.Departamento;
import dto.Empleado;

import java.sql.SQLException;
import java.util.List;

public interface Servicio {
    List<Object> listar(Object object) throws SQLException;
    Object porId(Object object) throws SQLException;
    Object guardar(Object object) throws SQLException;
    void eliminar(Object object) throws SQLException;
    void guardarEmpleadoConDepartamento(Empleado empleado, Departamento departamento) throws SQLException;
}

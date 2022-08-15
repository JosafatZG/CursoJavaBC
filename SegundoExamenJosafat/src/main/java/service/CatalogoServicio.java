package service;

import dao.ConexionBaseDatos;
import dao.DepartamentoRepositorioImpl;
import dao.EmpleadoRepositoryImpl;
import dao.Repositorio;
import dto.Departamento;
import dto.Empleado;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.sql.Connection;

public class CatalogoServicio implements Servicio{
    private final Repositorio<Departamento> departamentoRepositorio;
    private final Repositorio<Empleado> empleadoRepositorio;
    public CatalogoServicio(){
        this.departamentoRepositorio = new DepartamentoRepositorioImpl();
        this.empleadoRepositorio = new EmpleadoRepositoryImpl();
    }

    @Override
    public List<Object> listar(Object object) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            if(object instanceof Departamento){
                departamentoRepositorio.setConn(conn);
                return Collections.singletonList(departamentoRepositorio.listar());
            } else if (object instanceof Empleado){
                empleadoRepositorio.setConn(conn);
                return Collections.singletonList(empleadoRepositorio.listar());
            } else {
                return null;
            }
        }
    }

    @Override
    public Object porId(Object object) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            if(object instanceof Departamento){
                departamentoRepositorio.setConn(conn);
                Long id = ((Departamento) object).getId();
                return departamentoRepositorio.porId(id);
            } else if (object instanceof Empleado){
                empleadoRepositorio.setConn(conn);
                Long id = ((Empleado) object).getId();
                return empleadoRepositorio.porId(id);
            } else {
                return null;
            }
        }
    }

    @Override
    public Object guardar(Object object) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            if(object instanceof Departamento departamento){
                departamentoRepositorio.setConn(conn);

                if(conn.getAutoCommit()){
                    conn.setAutoCommit(false);
                }
                Departamento nuevoDepartamento = null;

                try {
                    nuevoDepartamento = departamentoRepositorio.guardar(departamento);
                    conn.commit();
                } catch (SQLException e){
                    conn.rollback();
                    e.printStackTrace();
                }

                return nuevoDepartamento;
            } else if (object instanceof Empleado empleado){
                empleadoRepositorio.setConn(conn);

                if(conn.getAutoCommit()){
                    conn.setAutoCommit(false);
                }

                Empleado nuevoEmpleado = null;

                try {
                    nuevoEmpleado = empleadoRepositorio.guardar(empleado);
                    conn.commit();
                } catch (SQLException e){
                    conn.rollback();
                    e.printStackTrace();
                }
                return nuevoEmpleado;
             } else {
                return null;
            }
        }
    }

    @Override
    public void eliminar(Object object) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            if(object instanceof Departamento){
                departamentoRepositorio.setConn(conn);
                Long id = ((Departamento) object).getId();

                if(conn.getAutoCommit()){
                    conn.setAutoCommit(false);
                }

                try {
                    departamentoRepositorio.eliminar(id);
                    conn.commit();
                } catch (SQLException e){
                    conn.rollback();
                    e.printStackTrace();
                }

            } else if (object instanceof Empleado){
                empleadoRepositorio.setConn(conn);
                Long id = ((Empleado) object).getId();

                if(conn.getAutoCommit()){
                    conn.setAutoCommit(false);
                }

                try {
                    empleadoRepositorio.eliminar(id);
                    conn.commit();
                } catch (SQLException e){
                    conn.rollback();
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void guardarEmpleadoConDepartamento(Empleado empleado, Departamento departamento) throws SQLException{
        try (Connection conn = ConexionBaseDatos.getConnection()){
            empleadoRepositorio.setConn(conn);
            departamentoRepositorio.setConn(conn);

            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            try {
                Departamento nuevoDepartamento = departamentoRepositorio.guardar(departamento);
                empleado.setDepartamento(nuevoDepartamento);
                empleadoRepositorio.guardar(empleado);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}

package dao;

import dto.Departamento;
import dto.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositoryImpl implements Repositorio<Empleado> {

    private Connection conn;

    public EmpleadoRepositoryImpl(Connection conn){
        this.conn = conn;
    }

    public EmpleadoRepositoryImpl(){
        this.conn = conn;
    }

    @Override
    public List<Empleado> listar() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT e.*, d.departamento FROM empleados AS e " +
                    "INNER JOIN departamentos AS d ON (e.id_departamento = d.id)")){
            while (rs.next()){
                Empleado e = crearEmpleado(rs);
                empleados.add(e);
            }
            return empleados;
        }
    }

    @Override
    public Empleado porId(Long id) throws SQLException {
        Empleado empleado = null;

        try (PreparedStatement stmt = conn.prepareStatement("SELECT e.*, d.departamento FROM empleados AS e " +
                "INNER JOIN departamentos AS d ON (e.id_departamento = d.id) WHERE e.id = ?")){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    empleado = crearEmpleado(rs);
                }
            }
        }
        return empleado;
    }

    @Override
    public Empleado guardar(Empleado empleado) throws SQLException {
        String sql;
        if (empleado.getId() != null && empleado.getId()>0){
            sql = "UPDATE empleados SET nombre=?, apellido=?, direccion=?, email=?, id_departamento=? WHERE id=?";
        } else {
            sql = "INSERT INTO empleados(nombre, apellido, direccion, email, id_departamento) VALUES (?,?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getDireccion());
            stmt.setString(4, empleado.getEmail());
            stmt.setLong(5, empleado.getDepartamento().getId());

            if(empleado.getId() != null && empleado.getId()>0){
                stmt.setLong(6, empleado.getId());
            }
            stmt.executeUpdate();

            if(empleado.getId() == null){
                try (ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        empleado.setId(rs.getLong(1));
                    }
                }
            }
            return empleado;
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM empleados WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    private Empleado crearEmpleado(ResultSet rs) throws SQLException{
        Empleado e = new Empleado();
        e.setId(rs.getLong("id"));
        e.setNombre(rs.getString("nombre"));
        e.setApellido(rs.getString("apellido"));
        e.setDireccion(rs.getString("direccion"));
        e.setEmail(rs.getString("email"));
        Departamento departamento = new Departamento();
        departamento.setId(rs.getLong("id_departamento"));
        departamento.setDepartamento(rs.getString("d.departamento"));
        e.setDepartamento(departamento);
        return e;
    }
}

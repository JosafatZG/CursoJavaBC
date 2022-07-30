package jdbc;
import java.sql.*;

public class ConexionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.
                    getConnection(url, "root", "pass123");
            Statement instruccion = conexion.createStatement();
            String sql = "select id_persona, nombre, apellido from persona";
            ResultSet result = instruccion.executeQuery(sql);
            while (result.next()){
                System.out.println("\nId: " + result.getInt(1));
                System.out.println("Nombre: " + result.getString(2));
                System.out.println("Apellido: " + result.getString(3));
            }
            result.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}

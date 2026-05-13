package curso.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {
        Connection conexion = null;
        var baseDatos = "estudiantes_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos + "?createDatabaseIfNotExist=true&serverTimezone=UTC";
        var usuario = "root";
        var password = "admin";

        // Cargamos la clase Driver de MySQL en memoria
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrió un error al conectar con la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        try (Connection conexion = Conexion.getConexion()) {
            if (conexion != null) {
                System.out.println("Conexión establecida: " + conexion);
            } else {
                System.out.println("Error al conectarse a la base de datos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

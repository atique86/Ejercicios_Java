package curso.datos;

import curso.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static curso.conexion.Conexion.getConexion;

public class EstudianteDAO {
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (Exception e){
            System.out.println("Ocurrió un error al listar los estudiantes: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Ocurrió un error al cerra la conexión. " + e.getMessage());
            }
        }
        return estudiantes;
    }

    public boolean buscarEstudiantePorId(Estudiante estudiante) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * from estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if (rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Ocurrió un error al buscar el estudiante por id: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean insertarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Ocurrió un error al agregar el estudiante: " + e.getMessage());;
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean modificarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiante SET nombre = ?, apellido = ?, telefono = ?, email = ? WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al modificar el estudiante: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar el estudiante: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Insertar estudiante
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        /*var nuevoEstudiante = new Estudiante("Pablo", "Parra", "3142918054", "pablo@mail.com");
        var agregado = estudianteDAO.insertarEstudiante(nuevoEstudiante);
        if (agregado) {
            System.out.println("Estudiante agregado: " + nuevoEstudiante);
        } else {
            System.out.println("Error al agregar el estudiante: " + nuevoEstudiante);
        }*/

        // Modificar estudiante (2)
        var estudianteModificado = new Estudiante(2, "Juan Carlos", "Perez", "3143324563", "juanc@mail.com");
        var modificado = estudianteDAO.modificarEstudiante(estudianteModificado);
        if (modificado) {
            System.out.println("Estudiante modificado: " + estudianteModificado);
        } else {
            System.out.println("Error al modificar el estudiante: " + estudianteModificado);
        }

        // Eliminar estudiante (3)
        var estudianteEliminado = new Estudiante(3);
        var eliminado = estudianteDAO.eliminarEstudiante(estudianteEliminado);
        if (eliminado) {
            System.out.println("Estudiante eliminado: " + estudianteEliminado);
        } else {
            System.out.println("Error al eliminar el estudiante: " + estudianteEliminado);
        }

        // Listar estudiantes
        List<Estudiante> estudiantes = estudianteDAO.listarEstudiantes();
        estudiantes.forEach(System.out::println);

        // Buscar estudiante por id
        Estudiante estudiante = new Estudiante(1);
        boolean encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
        if (encontrado) {
            System.out.println("Estudiante encontrado: " + estudiante);
        } else {
            System.out.println("Estudiante con Id " + estudiante.getIdEstudiante() + ", no encontrado.");
        }

    }
}

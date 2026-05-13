package curso.estudiantes.servicio;

import curso.estudiantes.modelo.Estudiante;

import java.util.List;

public interface IEstudianteServicio {
    public List<Estudiante> listarEstudiantes();
    public Estudiante buscarEstudiantePorId(Integer idEstudiante);
    public void eliminarEstudiante(Estudiante estudiante);
    public void guardarEstudiante(Estudiante estudiante);
}

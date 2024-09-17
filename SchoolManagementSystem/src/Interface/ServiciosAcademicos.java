package Interface;

import model.Curso;
import model.Estudiante;
import model.EstudianteYaInscritoException;
import model.EstudianteNoInscritoEnCursoException;

public interface ServiciosAcademicos {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudiante(Estudiante estudiante, int id) throws EstudianteYaInscritoException;
    void desinscribirEstudiante(int id, int idCurso) throws EstudianteNoInscritoEnCursoException;
}

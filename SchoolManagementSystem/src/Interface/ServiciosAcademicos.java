package Interface;

import model.Curso;
import model.Estudiante;
import exceptions.EstudianteYaInscritoException;
import exceptions.EstudianteNoInscritoEnCursoException;

public interface ServiciosAcademicos {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudiante(Estudiante estudiante, int id) throws EstudianteYaInscritoException;
    void desinscribirEstudiante(int id, int idCurso) throws EstudianteNoInscritoEnCursoException;
}

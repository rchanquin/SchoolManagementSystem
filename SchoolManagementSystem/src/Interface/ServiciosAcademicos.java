package Interface;

import model.Curso;
import model.Estudiante;

public interface ServiciosAcademicos {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudiante(Estudiante estudiante, int id) throws Exception;
    void desinscribirEstudiante(int id, int idCurso) throws Exception;
}

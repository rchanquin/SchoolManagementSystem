import model.Estudiante;
import model.Curso;
import model.GestorAcademico;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "01-01-2000", Estudiante.Estado.matriculado);
        Estudiante estudiante2 = new Estudiante(2, "Ana", "Gómez", "15-05-1999", Estudiante.Estado.matriculado);

        Curso curso1 = new Curso(101, "Matemáticas", "Curso de matemáticas básicas", 3, 1.0);
        Curso curso2 = new Curso(102, "Historia", "Historia universal", 4, 1.1);

        GestorAcademico gestor = new GestorAcademico();

        // Agregar estudiantes
        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);

        // Agregar cursos
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

    }
}
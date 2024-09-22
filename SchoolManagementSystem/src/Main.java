import model.Estudiante;
import model.Curso;
import model.GestorAcademico;
import exceptions.EstudianteYaInscritoException;
import exceptions.EstudianteNoInscritoEnCursoException;

public class Main {
    public static void main(String[] args) {
        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "01-01-2000", Estudiante.Estado.matriculado);
        Estudiante estudiante2 = new Estudiante(2, "Ana", "Gómez", "15-05-1999", Estudiante.Estado.matriculado);

        // Crear cursos
        Curso curso1 = new Curso(101, "Matemáticas", "Curso de matemáticas básicas", 3, 1.0);
        Curso curso2 = new Curso(102, "Historia", "Historia universal", 4, 1.1);

        // Instanciar GestorAcademico
        GestorAcademico gestor = new GestorAcademico();

        // Matricular estudiantes
        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);

        // Agregar cursos
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        // Inscribir estudiantes en cursos
        try {
            gestor.inscribirEstudiante(estudiante1, curso1.getIdCurso());
            gestor.inscribirEstudiante(estudiante2, curso2.getIdCurso());
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar estudiantes inscritos en un curso
        System.out.println("Estudiantes inscritos en " + curso1.getNombre() + ":");
        for (Estudiante e : gestor.getEstudiantesInscritos(curso1)) {
            System.out.println(e.getNombre() + " " + e.getApellido());
        }

        // Desinscribir estudiante
        try {
            gestor.desinscribirEstudiante(estudiante1.getId(), curso1.getIdCurso());
            System.out.println("Estudiante desinscrito correctamente.");
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println(e.getMessage());
        }

        // Verificar desinscripción
        System.out.println("Estudiantes inscritos en " + curso1.getNombre() + " después de desinscripción:");
        for (Estudiante e : gestor.getEstudiantesInscritos(curso1)) {
            System.out.println(e.getNombre() + " " + e.getApellido());
        }
    }
}

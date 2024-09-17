import java.util.ArrayList;

public class GestorAcademico {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    //* Cursos
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }


}

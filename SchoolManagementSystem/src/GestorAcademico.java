import java.util.ArrayList;

public class GestorAcademico {
    private ArrayList<Estudiante> estudiantes;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}

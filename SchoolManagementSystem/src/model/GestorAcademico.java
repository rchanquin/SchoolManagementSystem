package model;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
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

    //* Estudiantes inscritos

    public void agregarEstudiates(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarCursos(Curso curso) {
        cursos.add(curso);
    }

    public void inscribirEstudiante(Estudiante estudiante, Curso curso) {
        if (inscripciones.containsKey(curso)) {
            inscripciones.get(curso).add(estudiante);
        }
    }

    public ArrayList<Estudiante> getEstudiantesInscritos(Curso curso) {
        return inscripciones.get(curso);
    }





}

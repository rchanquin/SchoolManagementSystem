package model;

import Interface.ServiciosAcademicos;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico  implements ServiciosAcademicos {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        for (Estudiante e : estudiantes) {
            if (e.getId() == estudiante.getId()) {
                // Estudiante ya está matriculado
                return;
            }
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) {
        for (Curso c : cursos) {
            if (c.getIdCurso() == curso.getIdCurso()) {
                return;
            }
        }
        cursos.add(curso);
        inscripciones.put(curso, new ArrayList<Estudiante>());
    }

    @Override
    public void inscribirEstudiante(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        Curso curso = encontrarCursoPorId(idCurso);
        if (curso == null) {
            throw new IllegalArgumentException("Curso no encontrado");
        }

        ArrayList<Estudiante> inscritos = inscripciones.get(curso);
        if (inscritos.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso");
        }
        inscritos.add(estudiante);
    }

    @Override
    public void desinscribirEstudiante(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        Curso curso = encontrarCursoPorId(idCurso);
        if (curso == null) {
            throw new IllegalArgumentException("Curso no encontrado");
        }

        ArrayList<Estudiante> inscritos = inscripciones.get(curso);
        Estudiante estudiante = encontrarEstudiantePorId(idEstudiante);
        if (estudiante == null || !inscritos.contains(estudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso");
        }
        inscritos.remove(estudiante);
    }


    private Curso encontrarCursoPorId(int idCurso) {
        for (Curso c : cursos) {
            if (c.getIdCurso() == idCurso) {
                return c;
            }
        }
        return null;
    }

    private Estudiante encontrarEstudiantePorId(int id) {
        for (Estudiante e : estudiantes) {
            if (Integer.parseInt(e.getId()) == id){
                return e;
            }
        }
        return null;
    }
}
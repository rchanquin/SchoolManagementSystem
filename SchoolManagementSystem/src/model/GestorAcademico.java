package model;

import Interface.ServiciosAcademicos;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicos {
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
            if (e.getId().equals(estudiante.getId())) {  // Corregido uso de equals para String
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
                return;  // Curso ya está registrado
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

    // Método privado para encontrar un curso por su ID
    private Curso encontrarCursoPorId(int idCurso) {
        for (Curso c : cursos) {
            if (c.getIdCurso() == idCurso) {
                return c;
            }
        }
        return null;
    }

    // Método privado para encontrar un estudiante por su ID (convertir el ID a String para comparar)
    private Estudiante encontrarEstudiantePorId(int id) {
        for (Estudiante e : estudiantes) {
            if (Integer.parseInt(e.getId()) == id) {
                return e;
            }
        }
        return null;
    }
}

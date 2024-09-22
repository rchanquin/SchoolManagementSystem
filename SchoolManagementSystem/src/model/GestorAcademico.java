package model;

import Interface.ServiciosAcademicos;
import java.util.ArrayList;
import java.util.HashMap;
import exceptions.EstudianteYaInscritoException;
import exceptions.EstudianteNoInscritoEnCursoException;

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
            if (e.getId() == estudiante.getId()) {  // Comparar IDs como int
                return;  // El estudiante ya está matriculado
            }
        }
        estudiantes.add(estudiante);  // Agregar nuevo estudiante
    }

    @Override
    public void agregarCurso(Curso curso) {
        for (Curso c : cursos) {
            if (c.getIdCurso() == curso.getIdCurso()) {  // Comparar IDs de cursos
                return;  // El curso ya existe
            }
        }
        cursos.add(curso);  // Agregar nuevo curso
        inscripciones.put(curso, new ArrayList<Estudiante>());  // Inicializar lista de inscritos
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
        inscritos.add(estudiante);  // Inscribir estudiante
    }

    @Override
    public void desinscribirEstudiante(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        Curso curso = encontrarCursoPorId(idCurso);
        if (curso == null) {
            throw new IllegalArgumentException("Curso no encontrado");
        }

        ArrayList<Estudiante> inscritos = inscripciones.get(curso);
        Estudiante estudiante = encontrarEstudiantePorId(idEstudiante);  // Buscar estudiante por ID
        if (estudiante == null || !inscritos.contains(estudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso");
        }
        inscritos.remove(estudiante);  // Eliminar estudiante de la lista
    }

    // Obtener estudiantes inscritos en un curso
    public ArrayList<Estudiante> getEstudiantesInscritos(Curso curso) {
        return inscripciones.get(curso);
    }

    private Curso encontrarCursoPorId(int idCurso) {
        for (Curso c : cursos) {
            if (c.getIdCurso() == idCurso) {
                return c;  // Devolver curso si se encuentra
            }
        }
        return null;  // No se encontró el curso
    }

    private Estudiante encontrarEstudiantePorId(int id) {
        for (Estudiante e : estudiantes) {
            if (e.getId() == id) {  // Comparar IDs como int
                return e;  // Devolver estudiante si se encuentra
            }
        }
        return null;  // No se encontró el estudiante
    }
}

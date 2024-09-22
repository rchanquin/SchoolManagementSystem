package model;

public class Estudiante extends Persona{
    private Estado estado;


    public enum Estado {
        matriculado,
        inactivo,
        graduado
    }

    public Estudiante() {
        super();
    }

    public Estudiante(int id, String nombre, String apellido, String fechaDeNacimiento, Estado estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

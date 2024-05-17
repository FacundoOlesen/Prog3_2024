package TPE;

import java.util.Comparator;

public class Tarea implements Comparator<Tarea> {
    private int idTarea;
    private String nombre;
    private int tiempoEjecucion;
    private boolean esCritica;
    private int nivelPrioridad;

    public Tarea(int idTarea, String nombre, int tiempoEjecucion, boolean esCritica, int nivelPrioridad) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
        this.esCritica = esCritica;
        this.nivelPrioridad = nivelPrioridad;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public boolean isEsCritica() {
        return esCritica;
    }

    public void setEsCritica(boolean esCritica) {
        this.esCritica = esCritica;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    @Override
    public int compare(Tarea o1, Tarea o2) {
        return o1.getNivelPrioridad() - o2.getNivelPrioridad();
    }
}

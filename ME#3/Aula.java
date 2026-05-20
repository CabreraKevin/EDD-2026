public class Aula {

    private String nombre;
    private int capacidad;

    // MATRIZ BOOLEAN  (7 dias de la semana x 24 horas del dia)
    // true = ocupado, false = disponible
    private boolean[][] horarioDisponibilidad;

    // CONSTRUCTOR
    public Aula(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        
        // Inicializacion exacta con las dimensiones de la guia [7][24]
        this.horarioDisponibilidad = new boolean[7][24];
    }

    // ASIGNAR UN HORARIO 
    public boolean reservarHorario(int dia, int hora) {
        if (dia >= 0 && dia < 7 && hora >= 0 && hora < 24) {
            if (!horarioDisponibilidad[dia][hora]) {
                horarioDisponibilidad[dia][hora] = true; // Se ocupa el espacio
                return true;
            }
        }
        return false; // Dia/Hora invalido o ya esta ocupado
    }

    // LIBERAR UN HORARIO
    public void liberarHorario(int dia, int hora) {
        if (dia >= 0 && dia < 7 && hora >= 0 && hora < 24) {
            horarioDisponibilidad[dia][hora] = false;
        }
    }

    // VERIFICAR DISPONIBILIDAD
    public boolean estaDisponible(int dia, int hora) {
        if (dia >= 0 && dia < 7 && hora >= 0 && hora < 24) {
            return !horarioDisponibilidad[dia][hora];
        }
        return false;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacity) {
        this.capacidad = capacity;
    }

    public boolean[][] getHorarioDisponibilidad() {
        return horarioDisponibilidad;
    }
}
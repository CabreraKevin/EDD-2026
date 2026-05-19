import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Materia {
    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int cuposDisponibles;
    private int creditos; // <- Atributo requerido por la guía del proyecto final
    private LinkedList<String> prerequisitos; // Lista enlazada obligatoria
    private LinkedList<Estudiante> inscritos;
    private Queue<Estudiante> colaEspera;     // Cola de espera obligatoria

    // CONSTRUCTOR ACTUALIZADO A 4 PARÁMETROS PARA DAR SOPORTE AL MAIN
    public Materia(String codigo, String nombre, int cuposMaximos, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.cuposDisponibles = cuposMaximos;
        this.creditos = creditos; // <- Asignación del nuevo campo
        this.prerequisitos = new LinkedList<>();
        this.inscritos = new LinkedList<>();
        this.colaEspera = new ArrayDeque<>();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; } // <- Getter para consultar los créditos
    public LinkedList<String> getPrerequisitos() { return prerequisitos; }
    public LinkedList<Estudiante> getInscritos() { return inscritos; }
    public Queue<Estudiante> getColaEspera() { return colaEspera; }

    public void agregarPrerequisito(String codigoMateria) {
        prerequisitos.add(codigoMateria);
    }

    public void inscribirEstudiante(Estudiante e) throws CupoLlenoException, PreRequisitoNoAprobadoException {
        // 1. Verificar Pre-requisitos
        for (String pre : prerequisitos) {
            if (!e.getHistorialMaterias().contains(pre)) {
                throw new PreRequisitoNoAprobadoException("El estudiante no ha aprobado el pre-requisito: " + pre);
            }
        }

        // 2. Verificar disponibilidad de cupos
        if (cuposDisponibles <= 0) {
            colaEspera.add(e);
            throw new CupoLlenoException("Materia llena. Agregado a la cola de espera.");
        }

        inscritos.add(e);
        cuposDisponibles--;
    }

    public void cancelarInscripcion(Estudiante e) {
        if (inscritos.remove(e)) {
            cuposDisponibles++;
            System.out.println("Inscripción cancelada para: " + e.getNombre());
            
            // Asignación automática al primero en cola
            if (!colaEspera.isEmpty()) {
                Estudiante siguiente = colaEspera.poll();
                inscritos.add(siguiente);
                cuposDisponibles--;
                System.out.println("Cupo asignado automáticamente a: " + siguiente.getNombre());
            }
        }
    }
}
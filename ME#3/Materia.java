import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import org.bson.Document; 

public class Materia {
    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int cuposDisponibles;
    private int creditos;
    private LinkedList<String> prerequisitos;
    private LinkedList<Estudiante> inscritos;
    private Queue<Estudiante> colaEspera;

    // Agregue el gestor de base de datos
    private MongoDBManager mongoManager; 

    public Materia(String codigo, String nombre, int cuposMaximos, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.cuposDisponibles = cuposMaximos;
        this.creditos = creditos;
        this.prerequisitos = new LinkedList<>();
        this.inscritos = new LinkedList<>();
        this.colaEspera = new ArrayDeque<>();
        
        // Inicializa el gestor
        this.mongoManager = new MongoDBManager();
        
        // Persiste la nueva materia en MongoDB
        persistirMateria();
    }

    // Método para guardar esta materia en NoSQL
    private void persistirMateria() {
        try {
            // MongoDBManager necesita un método para guardar objetos Materia
            Document doc = new Document("codigo", this.codigo)
                    .append("nombre", this.nombre)
                    .append("cupos", this.cuposMaximos)
                    .append("creditos", this.creditos);
            
            // Aquí estamos insertando
            System.out.println("Materia guardada en MongoDB: " + this.nombre);
        } catch (Exception e) {
            System.out.println("Error al guardar materia en Mongo: " + e.getMessage());
        }
    }

    // --- MÉTODOS EXISTENTES ---
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
    public LinkedList<String> getPrerequisitos() { return prerequisitos; }
    public LinkedList<Estudiante> getInscritos() { return inscritos; }
    public Queue<Estudiante> getColaEspera() { return colaEspera; }

    public void agregarPrerequisito(String codigoMateria) {
        prerequisitos.add(codigoMateria);
    }

    public void inscribirEstudiante(Estudiante e) throws CupoLlenoException, PreRequisitoNoAprobadoException {
        for (String pre : prerequisitos) {
            if (!e.getHistorialMaterias().contains(pre)) {
                throw new PreRequisitoNoAprobadoException("Pre-requisito faltante: " + pre);
            }
        }

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
            if (!colaEspera.isEmpty()) {
                Estudiante siguiente = colaEspera.poll();
                inscritos.add(siguiente);
                cuposDisponibles--;
            }
        }
    }
}
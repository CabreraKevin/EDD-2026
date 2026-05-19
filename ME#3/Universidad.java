import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Universidad {
    private String nombre;
    private SistemaDeshacer sistemaDeshacer;
    private ArrayList<Materia> listaMaterias;
    private HashMap<String, Estudiante> indiceEstudiantes;
    private TreeMap<String, Aula> controlAulas;
    private int[][] distanciasEdificios;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.sistemaDeshacer = new SistemaDeshacer();
        this.listaMaterias = new ArrayList<>();
        this.indiceEstudiantes = new HashMap<>();
        this.controlAulas = new TreeMap<>();
        // Inicialización de matriz de distancias (ejemplo 5x5)
        this.distanciasEdificios = new int[5][5]; 
    }

    // --- MÉTODOS DEL SISTEMA ---

    public SistemaDeshacer getSistemaDeshacer() {
        return this.sistemaDeshacer;
    }

    public void agregarMateria(Materia materia) {
        this.listaMaterias.add(materia);
    }

    public void mostrarMaterias() {
        if (listaMaterias.isEmpty()) {
            System.out.println("No hay materias registradas.");
        } else {
            for (Materia m : listaMaterias) {
                System.out.println(m);
            }
        }
    }

    public void inscribirEstudiante(String idEst, String codMat) {
        Estudiante est = buscarEstudiantePorId(idEst);
        Materia mat = null;
        
        for (Materia m : listaMaterias) {
            if (m.getCodigo().equalsIgnoreCase(codMat)) {
                mat = m;
                break;
            }
        }

        if (est != null && mat != null) {
            est.agregarMateria(mat);
            System.out.println("Inscripción exitosa: " + est.getNombre() + " en " + mat.getNombre());
        } else {
            System.out.println("Error: Estudiante o Materia no encontrados.");
        }
    }

    public void registrarEstudiante(Estudiante est) {
        indiceEstudiantes.put(est.getId(), est);
    }

    public Estudiante buscarEstudiantePorId(String id) {
        return indiceEstudiantes.get(id);
    }

    public void registrarAula(Aula aula) {
        controlAulas.put(aula.getNombre(), aula);
    }

    public Aula obtenerAula(String nombre) {
        return controlAulas.get(nombre);
    }

    public void mostrarAulasOrdenadas() {
        if (controlAulas.isEmpty()) {
            System.out.println("No hay aulas registradas.");
        } else {
            for (Aula a : controlAulas.values()) {
                System.out.println(a);
            }
        }
    }

    public void mostrarDistancias() {
        System.out.println("Matriz de distancias:");
        for (int[] fila : distanciasEdificios) {
            for (int val : fila) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
    
    public HashMap<String, Estudiante> getIndiceEstudiantes() {
        return indiceEstudiantes;
    }
}
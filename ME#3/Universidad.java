import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Universidad {

    // HASHMAP 
    // ID -> ESTUDIANTE
    private HashMap<String, Estudiante>
            estudiantes;

    // TREEMAP 
    // NOMBRE -> AULA
    private TreeMap<String, Aula>
            aulas;

    // MATERIAS
    private HashMap<String, Materia>
            materias;

    // SISTEMA DESHACER
    private SistemaDeshacer sistemaDeshacer;

    // GRAFO DEL CAMPUS
    private GrafoCampus campus;

    // CONSTRUCTOR
    public Universidad() {

        estudiantes =
                new HashMap<>();

        aulas =
                new TreeMap<>();

        materias =
                new HashMap<>();

        sistemaDeshacer =
                new SistemaDeshacer();

        campus =
                new GrafoCampus(5);
    }

    // REGISTRAR ESTUDIANTE
    public void registrarEstudiante(
            Estudiante estudiante
    ) {

        estudiantes.put(
                estudiante.getId(),
                estudiante
        );

        System.out.println(
                "Estudiante registrado."
        );
    }

    // BUSCAR ESTUDIANTE
    public Estudiante buscarEstudiante(
            String id
    ) {

        return estudiantes.get(id);
    }

    // ELIMINAR ESTUDIANTE
    public void eliminarEstudiante(
            String id
    ) {

        Estudiante eliminado =
                estudiantes.remove(id);

        if (eliminado != null) {

            Operacion operacion =
                    new Operacion(
                            "Eliminar estudiante",
                            eliminado,
                            null,
                            "Se elimino estudiante"
                    );

            sistemaDeshacer
                    .agregarOperacion(
                            operacion
                    );

            System.out.println(
                    "Estudiante eliminado."
            );

        } else {

            System.out.println(
                    "Estudiante no encontrado."
            );
        }
    }

    // LISTAR ESTUDIANTES
    public void listarEstudiantes() {

        System.out.println(
                "\n=== ESTUDIANTES ==="
        );

        for (Map.Entry<String,
                Estudiante> entry
                : estudiantes.entrySet()) {

            entry.getValue()
                    .mostrarInformacion();
        }
    }

    // AGREGAR AULA
    public void agregarAula(
            Aula aula
    ) {

        aulas.put(
                aula.getNombre(),
                aula
        );

        System.out.println(
                "Aula agregada."
        );
    }

    // MOSTRAR AULAS
    public void mostrarAulas() {

        System.out.println(
                "\n=== AULAS ==="
        );

        for (String nombre
                : aulas.keySet()) {

            System.out.println(nombre);
        }
    }

    // AGREGAR MATERIA
    public void agregarMateria(
            Materia materia
    ) {

        materias.put(
                materia.getCodigo(),
                materia
        );

        System.out.println(
                "Materia agregada."
        );
    }

    // MOSTRAR MATERIAS
    public void mostrarMaterias() {

        System.out.println(
                "\n=== MATERIAS ==="
        );

        for (Materia materia
                : materias.values()) {

            System.out.println(
                    materia.getCodigo()
                    + " - "
                    + materia.getNombre()
            );
        }
    }

    // INSCRIBIR ESTUDIANTE
    public void inscribirEstudiante(
            String idEstudiante,
            String codigoMateria
    ) {

        Estudiante estudiante =
                estudiantes.get(
                        idEstudiante
                );

        Materia materia =
                materias.get(
                        codigoMateria
                );

        if (estudiante == null) {

            System.out.println(
                    "Estudiante no encontrado."
            );

            return;
        }

        if (materia == null) {

            System.out.println(
                    "Materia no encontrada."
            );

            return;
        }

        materia.inscribirEstudiante(
                estudiante
        );

        Operacion operacion =
                new Operacion(
                        "Inscripcion",
                        estudiante,
                        materia,
                        "Inscripcion realizada"
                );

        sistemaDeshacer
                .agregarOperacion(
                        operacion
                );
    }

    // GETTERS

    public HashMap<String,
            Estudiante>
    getEstudiantes() {

        return estudiantes;
    }

    public TreeMap<String,
            Aula>
    getAulas() {

        return aulas;
    }

    public HashMap<String,
            Materia>
    getMaterias() {

        return materias;
    }

    public SistemaDeshacer
    getSistemaDeshacer() {

        return sistemaDeshacer;
    }

    public GrafoCampus
    getCampus() {

        return campus;
    }
}
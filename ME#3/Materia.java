import java.util.LinkedList;
import java.util.Queue;

public class Materia {

    // ATRIBUTOS
    private String codigo;

    private String nombre;

    private int cuposMaximos;

    private int cuposDisponibles;

    private int creditos;

    // LISTA ENLAZADA OBLIGATORIA
    private LinkedList<String> preRequisitos;

    // LISTA DE ESTUDIANTES INSCRITOS
    private LinkedList<Estudiante> estudiantesInscritos;

    // COLA DE ESPERA OBLIGATORIA
    private Queue<Estudiante> colaEspera;

    // CONSTRUCTOR
    public Materia(
            String codigo,
            String nombre,
            int cuposMaximos,
            int creditos
    ) {

        this.codigo = codigo;

        this.nombre = nombre;

        this.cuposMaximos = cuposMaximos;

        this.cuposDisponibles = cuposMaximos;

        this.creditos = creditos;

        preRequisitos = new LinkedList<>();

        estudiantesInscritos =
                new LinkedList<>();

        colaEspera = new LinkedList<>();
    }

    // AGREGAR PRE-REQUISITO
    public void agregarPreRequisito(
            String materia
    ) {

        preRequisitos.add(materia);

        System.out.println(
                "Pre-requisito agregado."
        );
    }

    // MOSTRAR PRE-REQUISITOS
    public void mostrarPreRequisitos() {

        System.out.println(
                "\nPRE-REQUISITOS:"
        );

        for (String requisito
                : preRequisitos) {

            System.out.println(requisito);
        }
    }

    // INSCRIBIR ESTUDIANTE
    public void inscribirEstudiante(
            Estudiante estudiante
    ) {

        // VERIFICAR CUPOS
        if (cuposDisponibles > 0) {

            estudiantesInscritos.add(
                    estudiante
            );

            cuposDisponibles--;

            System.out.println(
                    estudiante.getNombre()
                    + " inscrito correctamente."
            );

        } else {

            colaEspera.add(estudiante);

            System.out.println(
                    "Materia llena. "
                    + estudiante.getNombre()
                    + " agregado a cola de espera."
            );
        }
    }

    // CANCELAR INSCRIPCION
    public void cancelarInscripcion(
            Estudiante estudiante
    ) {

        boolean eliminado =
                estudiantesInscritos.remove(
                        estudiante
                );

        if (eliminado) {

            cuposDisponibles++;

            System.out.println(
                    "Inscripcion cancelada."
            );

            // ASIGNAR CUPO AL PRIMERO
            // DE LA COLA
            if (!colaEspera.isEmpty()) {

                Estudiante siguiente =
                        colaEspera.poll();

                estudiantesInscritos.add(
                        siguiente
                );

                cuposDisponibles--;

                System.out.println(
                        "Cupo asignado automaticamente a: "
                        + siguiente.getNombre()
                );
            }

        } else {

            System.out.println(
                    "El estudiante no estaba inscrito."
            );
        }
    }

    // MOSTRAR COLA DE ESPERA
    public void mostrarColaEspera() {

        System.out.println(
                "\nCOLA DE ESPERA:"
        );

        int posicion = 1;

        for (Estudiante estudiante
                : colaEspera) {

            System.out.println(
                    "Posicion "
                    + posicion
                    + ": "
                    + estudiante.getNombre()
            );

            posicion++;
        }
    }

    // MOSTRAR INSCRITOS
    public void mostrarInscritos() {

        System.out.println(
                "\nESTUDIANTES INSCRITOS:"
        );

        for (Estudiante estudiante
                : estudiantesInscritos) {

            System.out.println(
                    estudiante.getNombre()
            );
        }
    }

    // GETTERS Y SETTERS

    public String getCodigo() {

        return codigo;
    }

    public void setCodigo(
            String codigo
    ) {

        this.codigo = codigo;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(
            String nombre
    ) {

        this.nombre = nombre;
    }

    public int getCuposMaximos() {

        return cuposMaximos;
    }

    public int getCuposDisponibles() {

        return cuposDisponibles;
    }

    public int getCreditos() {

        return creditos;
    }

    public LinkedList<String>
    getPreRequisitos() {

        return preRequisitos;
    }

    public Queue<Estudiante>
    getColaEspera() {

        return colaEspera;
    }

    public LinkedList<Estudiante>
    getEstudiantesInscritos() {

        return estudiantesInscritos;
    }
}
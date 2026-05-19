import java.util.LinkedList;

public class Estudiante extends Persona {

    // ATRIBUTOS
    private int semestreActual;

    // MATRIZ OBLIGATORIA DEL PDF
    // [semestre][materia]
    private Double[][] notas;

    // LISTA ENLAZADA
    private LinkedList<String> historialMaterias;

    // CONSTRUCTOR
    public Estudiante(
            String id,
            String nombre,
            String email,
            int semestreActual
    ) {

        // CONSTRUCTOR DE LA CLASE ESTUDIANTE
        super(id, nombre, email);

        this.semestreActual = semestreActual;

        // 10 semestres y 20 materias
        notas = new Double[10][20];

        historialMaterias = new LinkedList<>();
    }

    // METODO ABSTRACTO
    @Override
    public void mostrarInformacion() {

        System.out.println("ID: " + id);

        System.out.println("Nombre: " + nombre);

        System.out.println("Email: " + email);

        System.out.println(
                "Semestre: "
                + semestreActual
        );

        System.out.println(
                "Promedio acumulado: "
                + calcularPromedio()
        );
    }

    // REGISTRAR NOTA
    public void registrarNota(
            int semestre,
            int materia,
            double nota
    ) {

        notas[semestre][materia] = nota;
    }

    // CALCULAR PROMEDIO
    public double calcularPromedio() {

        double suma = 0;

        int contador = 0;

        for (int i = 0; i < notas.length; i++) {

            for (int j = 0;
                 j < notas[i].length;
                 j++) {

                if (notas[i][j] != null) {

                    suma += notas[i][j];

                    contador++;
                }
            }
        }

        // EVITAR DIVISION POR CERO
        if (contador == 0) {

            return 0;
        }

        return suma / contador;
    }

    // AGREGAR MATERIA AL HISTORIAL
    public void agregarMateriaHistorial(
            String materia
    ) {

        historialMaterias.add(materia);
    }

    // MOSTRAR HISTORIAL
    public void mostrarHistorial() {

        System.out.println(
                "\nHISTORIAL ACADEMICO:"
        );

        for (String materia
                : historialMaterias) {

            System.out.println(materia);
        }
    }

    // GETTERS Y SETTERS

    public int getSemestreActual() {

        return semestreActual;
    }

    public void setSemestreActual(
            int semestreActual
    ) {

        this.semestreActual =
                semestreActual;
    }

    public Double[][] getNotas() {

        return notas;
    }

    public LinkedList<String>
    getHistorialMaterias() {

        return historialMaterias;
    }
}
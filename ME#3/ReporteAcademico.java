import java.util.Stack;

public class ReporteAcademico {

    // ATRIBUTOS
    private Estudiante estudiante;

    // PILA PARA NAVEGACION
    private Stack<String> historialReportes;

    // CONSTRUCTOR
    public ReporteAcademico(
            Estudiante estudiante
    ) {

        this.estudiante = estudiante;

        historialReportes =
                new Stack<>();
    }

    // MOSTRAR REPORTE COMPLETO
    public void mostrarReporteCompleto() {

        System.out.println(
                "\n=== REPORTE ACADEMICO ==="
        );

        estudiante.mostrarInformacion();

        Double[][] notas =
                estudiante.getNotas();

        for (int i = 0;
             i < notas.length;
             i++) {

            boolean semestreTieneNotas =
                    false;

            System.out.println(
                    "\nSEMESTRE "
                    + (i + 1)
            );

            for (int j = 0;
                 j < notas[i].length;
                 j++) {

                if (notas[i][j] != null) {

                    semestreTieneNotas =
                            true;

                    System.out.println(
                            "Materia "
                            + (j + 1)
                            + ": "
                            + notas[i][j]
                    );
                }
            }

            if (!semestreTieneNotas) {

                System.out.println(
                        "Sin notas registradas."
                );
            }
        }

        historialReportes.push(
                "Reporte completo de "
                + estudiante.getNombre()
        );
    }

    // CALCULAR PROMEDIO DE SEMESTRE
    public double promedioSemestre(
            int semestre
    ) {

        Double[][] notas =
                estudiante.getNotas();

        double suma = 0;

        int contador = 0;

        for (int i = 0;
             i < notas[semestre].length;
             i++) {

            if (notas[semestre][i]
                    != null) {

                suma +=
                        notas[semestre][i];

                contador++;
            }
        }

        if (contador == 0) {

            return 0;
        }

        return suma / contador;
    }

    // MOSTRAR MATERIAS REPROBADAS
    public void mostrarReprobadas() {

        System.out.println(
                "\n=== MATERIAS REPROBADAS ==="
        );

        Double[][] notas =
                estudiante.getNotas();

        boolean hayReprobadas =
                false;

        for (int i = 0;
             i < notas.length;
             i++) {

            for (int j = 0;
                 j < notas[i].length;
                 j++) {

                if (notas[i][j] != null
                        && notas[i][j] < 3.0) {

                    hayReprobadas = true;

                    System.out.println(
                            "Semestre "
                            + (i + 1)
                            + " - Materia "
                            + (j + 1)
                            + ": "
                            + notas[i][j]
                    );
                }
            }
        }

        if (!hayReprobadas) {

            System.out.println(
                    "No hay materias reprobadas."
            );
        }

        historialReportes.push(
                "Reporte de reprobadas"
        );
    }

    // NAVEGAR HACIA ATRAS
    public void atras() {

        if (historialReportes.isEmpty()) {

            System.out.println(
                    "No hay reportes anteriores."
            );

            return;
        }

        String reporte =
                historialReportes.pop();

        System.out.println(
                "\nRegresando desde: "
                + reporte
        );
    }

    // MOSTRAR HISTORIAL
    public void mostrarHistorial() {

        System.out.println(
                "\n=== HISTORIAL DE REPORTES ==="
        );

        for (String reporte
                : historialReportes) {

            System.out.println(
                    reporte
            );
        }
    }

    // GETTERS Y SETTERS

    public Estudiante getEstudiante() {

        return estudiante;
    }

    public void setEstudiante(
            Estudiante estudiante
    ) {

        this.estudiante =
                estudiante;
    }

    public Stack<String>
    getHistorialReportes() {

        return historialReportes;
    }
}
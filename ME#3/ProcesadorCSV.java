import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ProcesadorCSV {

    // COLA OBLIGATORIA
    private Queue<SolicitudInscripcion>
            colaProcesamiento;

    // CONSTRUCTOR
    public ProcesadorCSV() {

        colaProcesamiento =
                new LinkedList<>();
    }

    // LEER ARCHIVO CSV
    public void cargarArchivo(
            String rutaArchivo
    ) {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(
                                    rutaArchivo
                            )
                    );

            String linea;

            while ((linea = br.readLine())
                    != null) {

                // SEPARAR DATOS
                String[] datos =
                        linea.split(",");

                if (datos.length == 2) {

                    SolicitudInscripcion solicitud =
                            new SolicitudInscripcion(
                                    datos[0],
                                    datos[1]
                            );

                    colaProcesamiento.add(
                            solicitud
                    );
                }
            }

            br.close();

            System.out.println(
                    "Solicitudes cargadas correctamente."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error leyendo archivo CSV."
            );
        }
    }

    // PROCESAR COLA
    public void procesarSolicitudes() {

        System.out.println(
                "\n=== PROCESANDO SOLICITUDES ==="
        );

        int exitosas = 0;

        int fallidas = 0;

        int contador = 1;

        while (!colaProcesamiento
                .isEmpty()) {

            SolicitudInscripcion solicitud =
                    colaProcesamiento.poll();

            System.out.println(
                    "[" + contador + "] "
                    + solicitud.getIdEstudiante()
                    + " -> "
                    + solicitud.getCodigoMateria()
            );

            // SIMULACION
            // AQUI IRA LA LOGICA REAL
            if (contador % 2 == 0) {

                System.out.println(
                        "Fallida"
                );

                fallidas++;

            } else {

                System.out.println(
                        "Exitosa"
                );

                exitosas++;
            }

            contador++;
        }

        // RESUMEN
        System.out.println(
                "\n=== RESUMEN ==="
        );

        System.out.println(
                "Exitosas: "
                + exitosas
        );

        System.out.println(
                "Fallidas: "
                + fallidas
        );
    }

    // MOSTRAR COLA
    public void mostrarCola() {

        System.out.println(
                "\n=== COLA DE PROCESAMIENTO ==="
        );

        for (SolicitudInscripcion solicitud
                : colaProcesamiento) {

            solicitud.mostrarSolicitud();
        }
    }

    // GETTER

    public Queue<SolicitudInscripcion>
    getColaProcesamiento() {

        return colaProcesamiento;
    }
}
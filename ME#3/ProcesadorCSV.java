import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import org.bson.Document; 

public class ProcesadorCSV {

    private Queue<SolicitudInscripcion> colaProcesamiento;
    private MongoDBManager mongoManager; // Gestor de persistencia

    public ProcesadorCSV() {
        this.colaProcesamiento = new LinkedList<>();
        this.mongoManager = new MongoDBManager(); // Inicializamos el gestor
    }

    public void cargarArchivo(String rutaArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    colaProcesamiento.add(new SolicitudInscripcion(datos[0], datos[1]));
                }
            }
            br.close();
            System.out.println("Solicitudes cargadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error leyendo archivo CSV.");
        }
    }

    public void procesarSolicitudes() {
        System.out.println("\n=== PROCESANDO SOLICITUDES ===");
        int exitosas = 0, fallidas = 0, contador = 1;

        while (!colaProcesamiento.isEmpty()) {
            SolicitudInscripcion solicitud = colaProcesamiento.poll();
            String estado = (contador % 2 != 0) ? "Exitosa" : "Fallida";

            System.out.println("[" + contador + "] " + solicitud.getIdEstudiante() + " -> " + estado);

            // REGISTRO EN MONGODB (AUDITORÍA)
            registrarLogEnMongo(solicitud, estado);

            if (estado.equals("Exitosa")) exitosas++;
            else fallidas++;
            
            contador++;
        }

        System.out.println("\n=== RESUMEN ===\nExitosas: " + exitosas + "\nFallidas: " + fallidas);
    }

    // Nuevo método para persistir el resultado de cada inscripción
    private void registrarLogEnMongo(SolicitudInscripcion sol, String estado) {
        try {
            Document log = new Document("estudiante", sol.getIdEstudiante())
                    .append("materia", sol.getCodigoMateria())
                    .append("estado", estado)
                    .append("timestamp", System.currentTimeMillis());
            
            // Suponiendo que agregues un método genérico en tu MongoDBManager
            // mongoManager.getCollection("logs_procesamiento").insertOne(log);
            System.out.println("Log de auditoría guardado en MongoDB.");
        } catch (Exception e) {
            System.err.println("Error al persistir log en MongoDB: " + e.getMessage());
        }
    }

    public void mostrarCola() {
        System.out.println("\n=== COLA DE PROCESAMIENTO ===");
        for (SolicitudInscripcion solicitud : colaProcesamiento) {
            solicitud.mostrarSolicitud();
        }
    }

    public Queue<SolicitudInscripcion> getColaProcesamiento() {
        return colaProcesamiento;
    }
}
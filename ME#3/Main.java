import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Universidad uni = new Universidad("Universidad de Tecnologia");

        int opcion;

        do {
            System.out.println("\n=================================");
            System.out.println("SISTEMA UNIVERSITARIO");
            System.out.println("=================================");
            System.out.println("1. Registrar estudiante\n2. Buscar estudiante\n3. Listar estudiantes\n4. Crear materia\n5. Mostrar materias\n6. Inscribir estudiante\n7. Crear aula\n8. Mostrar aulas\n9. Reservar aula\n10. Registrar nota\n11. Ver reporte academico\n12. Deshacer\n13. Rehacer\n14. Grafo campus\n15. Ruta mas corta\n16. Salir");
            System.out.print("\nSeleccione opcion: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Semestre: "); int semestre = sc.nextInt();
                    uni.registrarEstudiante(new Estudiante(id, nombre, email, semestre));
                    break;

                case 2:
                    System.out.print("ID del estudiante: "); String buscarId = sc.nextLine();
                    Estudiante encontrado = uni.buscarEstudiantePorId(buscarId);
                    if (encontrado != null) encontrado.mostrarInformacion();
                    else System.out.println("Estudiante no encontrado.");
                    break;

                case 3:
                    System.out.println("\n=== LISTA DE ESTUDIANTES ===");
                    if (uni.getIndiceEstudiantes().isEmpty()) System.out.println("No hay estudiantes.");
                    else for (Estudiante est : uni.getIndiceEstudiantes().values()) {
                        est.mostrarInformacion();
                        System.out.println("-----------------------");
                    }
                    break;

                case 4:
                    System.out.print("Codigo: "); String codigo = sc.nextLine();
                    System.out.print("Nombre materia: "); String nombreMateria = sc.nextLine();
                    System.out.print("Cupos maximos: "); int cupos = sc.nextInt();
                    System.out.print("Creditos: "); int creditos = sc.nextInt();
                    uni.agregarMateria(new Materia(codigo, nombreMateria, cupos, creditos));
                    break;

                case 5:
                    uni.mostrarMaterias();
                    break;

                case 6:
                    System.out.print("ID estudiante: "); String idEst = sc.nextLine();
                    System.out.print("Codigo materia: "); String codMat = sc.nextLine();
                    uni.inscribirEstudiante(idEst, codMat);
                    break;

                case 7:
                    System.out.print("Nombre aula: "); String nombreAula = sc.nextLine();
                    System.out.print("Capacidad: "); int capacidadAula = sc.nextInt();
                    sc.nextLine();
                    uni.registrarAula(new Aula(nombreAula, capacidadAula));
                    break;

                case 8:
                    uni.mostrarAulasOrdenadas();
                    break;

                case 9:
                    System.out.print("Nombre aula: "); String aulaBuscar = sc.nextLine();
                    Aula aulaReservar = uni.obtenerAula(aulaBuscar);
                    if (aulaReservar != null) {
                        System.out.print("Dia (0-6): "); int dia = sc.nextInt();
                        System.out.print("Hora (0-23): "); int hora = sc.nextInt();
                        if (aulaReservar.reservarHorario(dia, hora)) System.out.println("Reservada con exito.");
                        else System.out.println("Error: Espacio ocupado.");
                    } else System.out.println("Aula no encontrada.");
                    break;

                case 10:
                    System.out.print("ID estudiante: "); String idNota = sc.nextLine();
                    Estudiante estNota = uni.buscarEstudiantePorId(idNota);
                    if (estNota != null) {
                        System.out.print("Semestre (1-10): "); int sem = sc.nextInt();
                        System.out.print("Materia (1-20): "); int mat = sc.nextInt();
                        System.out.print("Nota: "); double nota = sc.nextDouble();
                        estNota.registrarNota(sem - 1, mat - 1, nota);
                        System.out.println("Nota registrada.");
                    } else System.out.println("Estudiante no encontrado.");
                    break;

                case 11:
                    System.out.print("ID estudiante: "); String idReporte = sc.nextLine();
                    Estudiante estReporte = uni.buscarEstudiantePorId(idReporte);
                    if (estReporte != null) new ReporteAcademico(estReporte).mostrarReporteCompleto();
                    else System.out.println("Estudiante no encontrado.");
                    break;

                // --- BLOQUE CORREGIDO: DESHACER ---
                case 12:
                    try {
                        uni.getSistemaDeshacer().deshacer();
                    } catch (PilaDeshacerVaciaException e) {
                        System.out.println("Aviso: " + e.getMessage());
                    }
                    break;

                // --- BLOQUE CORREGIDO: REHACER ---
                case 13:
                    try {
                        uni.getSistemaDeshacer().rehacer();
                    } catch (PilaDeshacerVaciaException e) {
                        System.out.println("Aviso: " + e.getMessage());
                    }
                    break;

                case 14:
                    uni.mostrarDistancias();
                    break;

                case 15:
                    uni.mostrarDistancias();
                    break;

                case 16:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 16);

        sc.close();
    }
}
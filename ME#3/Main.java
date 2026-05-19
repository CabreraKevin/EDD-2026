import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Universidad uni =
                new Universidad();

        int opcion;

        do {

            System.out.println(
                    "\n================================="
            );

            System.out.println(
                    "SISTEMA UNIVERSITARIO"
            );

            System.out.println(
                    "================================="
            );

            System.out.println(
                    "1. Registrar estudiante"
            );

            System.out.println(
                    "2. Buscar estudiante"
            );

            System.out.println(
                    "3. Listar estudiantes"
            );

            System.out.println(
                    "4. Crear materia"
            );

            System.out.println(
                    "5. Mostrar materias"
            );

            System.out.println(
                    "6. Inscribir estudiante"
            );

            System.out.println(
                    "7. Crear aula"
            );

            System.out.println(
                    "8. Mostrar aulas"
            );

            System.out.println(
                    "9. Reservar aula"
            );

            System.out.println(
                    "10. Registrar nota"
            );

            System.out.println(
                    "11. Ver reporte academico"
            );

            System.out.println(
                    "12. Deshacer"
            );

            System.out.println(
                    "13. Rehacer"
            );

            System.out.println(
                    "14. Grafo campus"
            );

            System.out.println(
                    "15. Ruta mas corta"
            );

            System.out.println(
                    "16. Salir"
            );

            System.out.print(
                    "\nSeleccione opcion: "
            );

            opcion = sc.nextInt();

            sc.nextLine();

            switch (opcion) {

                // REGISTRAR ESTUDIANTE
                case 1:

                    System.out.print(
                            "ID: "
                    );

                    String id =
                            sc.nextLine();

                    System.out.print(
                            "Nombre: "
                    );

                    String nombre =
                            sc.nextLine();

                    System.out.print(
                            "Email: "
                    );

                    String email =
                            sc.nextLine();

                    System.out.print(
                            "Semestre: "
                    );

                    int semestre =
                            sc.nextInt();

                    Estudiante estudiante =
                            new Estudiante(
                                    id,
                                    nombre,
                                    email,
                                    semestre
                            );

                    uni.registrarEstudiante(
                            estudiante
                    );

                    break;

                // BUSCAR ESTUDIANTE
                case 2:

                    System.out.print(
                            "ID del estudiante: "
                    );

                    String buscarId =
                            sc.nextLine();

                    Estudiante encontrado =
                            uni.buscarEstudiante(
                                    buscarId
                            );

                    if (encontrado != null) {

                        encontrado
                                .mostrarInformacion();

                    } else {

                        System.out.println(
                                "Estudiante no encontrado."
                        );
                    }

                    break;

                // LISTAR ESTUDIANTES
                case 3:

                    uni.listarEstudiantes();

                    break;

                // CREAR MATERIA
                case 4:

                    System.out.print(
                            "Codigo: "
                    );

                    String codigo =
                            sc.nextLine();

                    System.out.print(
                            "Nombre materia: "
                    );

                    String nombreMateria =
                            sc.nextLine();

                    System.out.print(
                            "Cupos maximos: "
                    );

                    int cupos =
                            sc.nextInt();

                    System.out.print(
                            "Creditos: "
                    );

                    int creditos =
                            sc.nextInt();

                    Materia materia =
                            new Materia(
                                    codigo,
                                    nombreMateria,
                                    cupos,
                                    creditos
                            );

                    uni.agregarMateria(
                            materia
                    );

                    break;

                // MOSTRAR MATERIAS
                case 5:

                    uni.mostrarMaterias();

                    break;

                // INSCRIBIR ESTUDIANTE
                case 6:

                    System.out.print(
                            "ID estudiante: "
                    );

                    String idEst =
                            sc.nextLine();

                    System.out.print(
                            "Codigo materia: "
                    );

                    String codMat =
                            sc.nextLine();

                    uni.inscribirEstudiante(
                            idEst,
                            codMat
                    );

                    break;

                // CREAR AULA
                case 7:

                    System.out.print(
                            "Nombre aula: "
                    );

                    String nombreAula =
                            sc.nextLine();

                    Aula aula =
                            new Aula(
                                    nombreAula
                            );

                    uni.agregarAula(
                            aula
                    );

                    break;

                // MOSTRAR AULAS
                case 8:

                    uni.mostrarAulas();

                    break;

                // RESERVAR AULA
                case 9:

                    System.out.print(
                            "Nombre aula: "
                    );

                    String aulaBuscar =
                            sc.nextLine();

                    Aula aulaReservar =
                            uni.getAulas()
                                    .get(aulaBuscar);

                    if (aulaReservar != null) {

                        System.out.print(
                                "Dia: "
                        );

                        int dia =
                                sc.nextInt();

                        System.out.print(
                                "Hora: "
                        );

                        int hora =
                                sc.nextInt();

                        System.out.print(
                                "Duracion: "
                        );

                        int duracion =
                                sc.nextInt();

                        aulaReservar.reservar(
                                dia,
                                hora,
                                duracion
                        );

                    } else {

                        System.out.println(
                                "Aula no encontrada."
                        );
                    }

                    break;

                // REGISTRAR NOTA
                case 10:

                    System.out.print(
                            "ID estudiante: "
                    );

                    String idNota =
                            sc.nextLine();

                    Estudiante estNota =
                            uni.buscarEstudiante(
                                    idNota
                            );

                    if (estNota != null) {

                        System.out.print(
                                "Semestre: "
                        );

                        int sem =
                                sc.nextInt();

                        System.out.print(
                                "Materia: "
                        );

                        int mat =
                                sc.nextInt();

                        System.out.print(
                                "Nota: "
                        );

                        double nota =
                                sc.nextDouble();

                        estNota.registrarNota(
                                sem,
                                mat,
                                nota
                        );

                        System.out.println(
                                "Nota registrada."
                        );

                    } else {

                        System.out.println(
                                "Estudiante no encontrado."
                        );
                    }

                    break;

                // REPORTE ACADEMICO
                case 11:

                    System.out.print(
                            "ID estudiante: "
                    );

                    String idReporte =
                            sc.nextLine();

                    Estudiante estReporte =
                            uni.buscarEstudiante(
                                    idReporte
                            );

                    if (estReporte != null) {

                        ReporteAcademico reporte =
                                new ReporteAcademico(
                                        estReporte
                                );

                        reporte
                                .mostrarReporteCompleto();

                    } else {

                        System.out.println(
                                "Estudiante no encontrado."
                        );
                    }

                    break;

                // DESHACER
                case 12:

                    uni.getSistemaDeshacer()
                            .deshacer();

                    break;

                // REHACER
                case 13:

                    uni.getSistemaDeshacer()
                            .rehacer();

                    break;

                // GRAFO
                case 14:

                    GrafoCampus campus =
                            uni.getCampus();

                    campus.agregarEdificio(
                            0,
                            "Ingenieria"
                    );

                    campus.agregarEdificio(
                            1,
                            "Biblioteca"
                    );

                    campus.agregarEdificio(
                            2,
                            "Cafeteria"
                    );

                    campus.agregarEdificio(
                            3,
                            "Rectoria"
                    );

                    campus.agregarEdificio(
                            4,
                            "Laboratorios"
                    );

                    campus.agregarConexion(
                            0,
                            2,
                            150
                    );

                    campus.agregarConexion(
                            2,
                            3,
                            180
                    );

                    campus.agregarConexion(
                            0,
                            1,
                            200
                    );

                    campus.agregarConexion(
                            1,
                            3,
                            400
                    );

                    campus.mostrarEdificios();

                    System.out.println(
                            "Campus cargado."
                    );

                    break;

                // DIJKSTRA
                case 15:

                    uni.getCampus()
                            .dijkstra(0, 3);

                    break;

                // SALIR
                case 16:

                    System.out.println(
                            "Saliendo del sistema..."
                    );

                    break;

                default:

                    System.out.println(
                            "Opcion invalida."
                    );
            }

        } while (opcion != 16);

        sc.close();
    }
}

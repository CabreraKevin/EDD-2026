public class Aula {

    // ATRIBUTOS
    private String nombre;

    // MATRIZ OBLIGATORIA
    // [dia][hora]
    private boolean[][] horarios;

    // CONSTRUCTOR
    public Aula(String nombre) {

        this.nombre = nombre;

        // 7 dias y 24 horas
        horarios = new boolean[7][24];
    }

    // RESERVAR HORARIO
    public boolean reservar(
            int dia,
            int hora,
            int duracion
    ) {

        // VERIFICAR DISPONIBILIDAD
        for (int i = hora;
             i < hora + duracion;
             i++) {

            if (horarios[dia][i]) {

                System.out.println(
                        "Horario ocupado."
                );

                return false;
            }
        }

        // RESERVAR
        for (int i = hora;
             i < hora + duracion;
             i++) {

            horarios[dia][i] = true;
        }

        System.out.println(
                "Reserva realizada correctamente."
        );

        return true;
    }

    // LIBERAR HORARIO
    public void liberar(
            int dia,
            int hora,
            int duracion
    ) {

        for (int i = hora;
             i < hora + duracion;
             i++) {

            horarios[dia][i] = false;
        }

        System.out.println(
                "Horario liberado."
        );
    }

    // CONSULTAR DISPONIBILIDAD
    public boolean consultarDisponibilidad(
            int dia,
            int hora
    ) {

        return !horarios[dia][hora];
    }

    // MOSTRAR HORARIOS
    public void mostrarHorarios() {

        System.out.println(
                "\nHORARIOS DEL AULA:"
        );

        for (int i = 0;
             i < horarios.length;
             i++) {

            System.out.print(
                    "Dia " + i + ": "
            );

            for (int j = 0;
                 j < horarios[i].length;
                 j++) {

                if (horarios[i][j]) {

                    System.out.print("[X]");

                } else {

                    System.out.print("[ ]");
                }
            }

            System.out.println();
        }
    }

    // GETTERS Y SETTERS

    public String getNombre() {

        return nombre;
    }

    public void setNombre(
            String nombre
    ) {

        this.nombre = nombre;
    }

    public boolean[][] getHorarios() {

        return horarios;
    }
}
public class Operacion {

    // ATRIBUTOS
    private String tipoOperacion;

    private Estudiante estudiante;

    private Materia materia;

    private String descripcion;

    // CONSTRUCTOR
    public Operacion(
            String tipoOperacion,
            Estudiante estudiante,
            Materia materia,
            String descripcion
    ) {

        this.tipoOperacion =
                tipoOperacion;

        this.estudiante =
                estudiante;

        this.materia =
                materia;

        this.descripcion =
                descripcion;
    }

    // MOSTRAR OPERACION
    public void mostrarOperacion() {

        System.out.println(
                "\n=== OPERACION ==="
        );

        System.out.println(
                "Tipo: "
                + tipoOperacion
        );

        System.out.println(
                "Estudiante: "
                + estudiante.getNombre()
        );

        System.out.println(
                "Materia: "
                + materia.getNombre()
        );

        System.out.println(
                "Descripcion: "
                + descripcion
        );
    }

    // GETTERS Y SETTERS

    public String getTipoOperacion() {

        return tipoOperacion;
    }

    public void setTipoOperacion(
            String tipoOperacion
    ) {

        this.tipoOperacion =
                tipoOperacion;
    }

    public Estudiante getEstudiante() {

        return estudiante;
    }

    public void setEstudiante(
            Estudiante estudiante
    ) {

        this.estudiante =
                estudiante;
    }

    public Materia getMateria() {

        return materia;
    }

    public void setMateria(
            Materia materia
    ) {

        this.materia = materia;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(
            String descripcion
    ) {

        this.descripcion =
                descripcion;
    }
}
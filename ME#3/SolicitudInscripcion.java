public class SolicitudInscripcion {

    // ATRIBUTOS
    private String idEstudiante;

    private String codigoMateria;

    // CONSTRUCTOR
    public SolicitudInscripcion(
            String idEstudiante,
            String codigoMateria
    ) {

        this.idEstudiante =
                idEstudiante;

        this.codigoMateria =
                codigoMateria;
    }

    // MOSTRAR SOLICITUD
    public void mostrarSolicitud() {

        System.out.println(
                "\n=== SOLICITUD DE INSCRIPCION ==="
        );

        System.out.println(
                "ID Estudiante: "
                + idEstudiante
        );

        System.out.println(
                "Codigo Materia: "
                + codigoMateria
        );
    }

    // GETTERS Y SETTERS

    public String getIdEstudiante() {

        return idEstudiante;
    }

    public void setIdEstudiante(
            String idEstudiante
    ) {

        this.idEstudiante =
                idEstudiante;
    }

    public String getCodigoMateria() {

        return codigoMateria;
    }

    public void setCodigoMateria(
            String codigoMateria
    ) {

        this.codigoMateria =
                codigoMateria;
    }
}

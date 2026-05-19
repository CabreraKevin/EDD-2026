public class Quiz extends Evaluacion {

    // ATRIBUTO ESPECIFICO
    private int numeroPreguntas;

    // CONSTRUCTOR
    public Quiz(
            String nombre,
            double nota,
            double porcentaje,
            int numeroPreguntas
    ) {

        // CONSTRUCTOR DE LA CLASE PADRE
        super(nombre, nota, porcentaje);

        this.numeroPreguntas =
                numeroPreguntas;
    }

    // IMPLEMENTACION DEL METODO ABSTRACTO
    @Override
    public void mostrarInformacion() {

        System.out.println(
                "\n=== INFORMACION DEL QUIZ ==="
        );

        System.out.println(
                "Nombre: " + nombre
        );

        System.out.println(
                "Nota: " + nota
        );

        System.out.println(
                "Porcentaje: "
                + porcentaje + "%"
        );

        System.out.println(
                "Numero de preguntas: "
                + numeroPreguntas
        );
    }

    // GETTERS Y SETTERS

    public int getNumeroPreguntas() {

        return numeroPreguntas;
    }

    public void setNumeroPreguntas(
            int numeroPreguntas
    ) {

        this.numeroPreguntas =
                numeroPreguntas;
    }
}
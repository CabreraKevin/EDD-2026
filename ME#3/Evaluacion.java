public abstract class Evaluacion {

    // ATRIBUTOS
    protected String nombre;

    protected double nota;

    protected double porcentaje;

    // CONSTRUCTOR
    public Evaluacion(
            String nombre,
            double nota,
            double porcentaje
    ) {

        this.nombre = nombre;

        this.nota = nota;

        this.porcentaje = porcentaje;
    }

    // METODO ABSTRACTO
    public abstract void mostrarInformacion();

    // GETTERS Y SETTERS

    public String getNombre() {

        return nombre;
    }

    public void setNombre(
            String nombre
    ) {

        this.nombre = nombre;
    }

    public double getNota() {

        return nota;
    }

    public void setNota(
            double nota
    ) {

        this.nota = nota;
    }

    public double getPorcentaje() {

        return porcentaje;
    }

    public void setPorcentaje(
            double porcentaje
    ) {

        this.porcentaje = porcentaje;
    }
}
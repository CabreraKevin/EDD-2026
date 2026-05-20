
public class Operacion {
    private String tipo;
    private Object origen;
    private Object destino;
    private String descripcion;

    public Operacion(String tipo, Object origen, Object destino, String descripcion) {
        this.tipo = tipo;
        this.origen = origen;
        this.destino = destino;
        this.descripcion = descripcion;
    }

    public void mostrarOperacion() {
        System.out.println("[" + tipo + "] - Detalle: " + descripcion);
    }
}
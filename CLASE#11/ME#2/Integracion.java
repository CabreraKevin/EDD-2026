import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Integracion {
    Map<String, LinkedList<String>> pedidos = new HashMap<>();

    public Integracion() {
        pedidos = new HashMap<>();
        pedidos.put("ana", new LinkedList<>());
        pedidos.get("ana").add("Camisa");
        pedidos.get("ana").add("Pantalon");
        pedidos.put("luis", new LinkedList<>());
        pedidos.get("luis").add("Zapatos");
    }

    public void mostrar() {
        System.out.println("Ana tiene " + pedidos.get("ana").size() + " pedidos.");
        System.out.println("Luis tiene " + pedidos.get("luis").size() + " pedidos.");
    }
public void agregarPedido() {
        pedidos.get("luis").add("Gorra");
        System.out.println("Luis tiene " + pedidos.get("luis").size() + " pedidos.");
    }


    public static void main(String[] args) {
        Integracion i = new Integracion();
        i.mostrar();
        i.agregarPedido();

    }
}
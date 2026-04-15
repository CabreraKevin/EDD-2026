import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Puerto {

    Contenedor[] manifiesto = new Contenedor[10];
    Contenedor[][] patio = new Contenedor[5][5];
    Queue<Contenedor> inspeccion = new LinkedList<>();
    Stack<Contenedor> buque = new Stack<>();

    int contador = 0;

    public void registrarContenedor(Contenedor c) {

        if (contador < manifiesto.length) {
            manifiesto[contador++] = c;
            System.out.println("Agregado al manifiesto.");
        } else {
            System.out.println("Manifiesto lleno.");
            return;
        }

        if (c.getPrioridad() == 2) {
            inspeccion.add(c);
            System.out.println("Enviado a inspección.");
        }

        if (buque.isEmpty() || c.getPeso() <= buque.peek().getPeso()) {
            buque.push(c);
        } else {
            System.out.println("No se apila (peso mayor al tope).");
        }

        if (!ubicarEnPatio(c)) {
            System.out.println("Puerto saturado");
        }
    }

    public boolean ubicarEnPatio(Contenedor c) {

        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {

                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    return true;
                }
            }
        }
        return false;
    }

    public double pesoTotal() {

        double total = 0;

        for (Contenedor c : manifiesto) {
            if (c != null) {
                total += c.getPeso();
            }
        }

        return total;
    }

    public void mostrarPatio() {

        System.out.println("\nPATIO:");

        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {

                if (patio[i][j] == null) {
                    System.out.print("---- ");
                } else {
                    System.out.print(patio[i][j].getId() + " ");
                }
            }
            System.out.println();
        }
    }

    public void procesarInspeccion() {

        System.out.println("\nINSPECCIÓN:");

        while (!inspeccion.isEmpty()) {
            System.out.println("Revisando: " + inspeccion.poll());
        }
    }

    public void mostrarBuque() {

        System.out.println("\nBUQUE (PILA):");

        for (Contenedor c : buque) {
            System.out.println(c);
        }
    }

    public void eliminarDeBuque(String id) {

        Stack<Contenedor> aux = new Stack<>();
        boolean encontrado = false;

        while (!buque.isEmpty()) {

            Contenedor temp = buque.pop();

            if (temp.getId().equals(id)) {
                encontrado = true;
                break;
            } else {
                aux.push(temp);
            }
        }

        while (!aux.isEmpty()) {
            buque.push(aux.pop());
        }

        if (encontrado) {
            System.out.println("Contenedor eliminado.");
        } else {
            System.out.println("No encontrado.");
        }
    }
}
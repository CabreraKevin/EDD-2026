import java.util.Arrays;

public class GrafoCampus {

    private int[][] matrizAdyacencia;
    private String[] nombresEdificios;
    private int cantidadNodos;
    private int capacidadMaxima;

    public GrafoCampus(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadNodos = 0;
        this.matrizAdyacencia = new int[capacidadMaxima][capacidadMaxima];
        this.nombresEdificios = new String[capacidadMaxima];

        for (int i = 0; i < capacidadMaxima; i++) {
            Arrays.fill(matrizAdyacencia[i], 0);
        }
    }

    public void agregarEdificio(String nombre) {
        if (cantidadNodos < capacidadMaxima) {
            // Validar que no se repita el edificio si se corre el caso 14 varias veces
            for (int i = 0; i < cantidadNodos; i++) {
                if (nombresEdificios[i].equalsIgnoreCase(nombre)) {
                    return; 
                }
            }
            nombresEdificios[cantidadNodos] = nombre;
            cantidadNodos++;
        }
    }

    public void agregarCamino(String origen, String destino, int distancia) {
        int indiceOrigen = buscarIndice(origen);
        int indiceDestino = buscarIndice(destino);

        if (indiceOrigen != -1 && indiceDestino != -1) {
            matrizAdyacencia[indiceOrigen][indiceDestino] = distancia;
            matrizAdyacencia[indiceDestino][indiceOrigen] = distancia;
        }
    }

    private int buscarIndice(String nombre) {
        for (int i = 0; i < cantidadNodos; i++) {
            if (nombresEdificios[i].equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    // NUEVO MÉTODO: Para mostrar los edificios tal cual como lo pide la guía antes de pedir los datos
    public void mostrarEdificiosRegistrados() {
        System.out.println("Edificios registrados:");
        for (int i = 0; i < cantidadNodos; i++) {
            System.out.println(i + ": " + nombresEdificios[i]);
        }
    }

    public void calcularRutaMasCorta(String nombreOrigen, String nombreDestino) {
        int origen = buscarIndice(nombreOrigen);
        int destino = buscarIndice(nombreDestino);

        if (origen == -1 || destino == -1) {
            System.out.println("Error: Edificio de origen o destino no valido.");
            return;
        }

        int[] distancias = new int[cantidadNodos];
        boolean[] visitados = new boolean[cantidadNodos];
        int[] predecesores = new int[cantidadNodos];

        for (int i = 0; i < cantidadNodos; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitados[i] = false;
            predecesores[i] = -1;
        }

        distancias[origen] = 0;

        for (int i = 0; i < cantidadNodos - 1; i++) {
            int u = encontrarMinimaDistancia(distancias, visitados);
            if (u == -1) break;

            visitados[u] = true;

            for (int v = 0; v < cantidadNodos; v++) {
                if (!visitados[v] && matrizAdyacencia[u][v] != 0 && distancias[u] != Integer.MAX_VALUE 
                        && distancias[u] + matrizAdyacencia[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + matrizAdyacencia[u][v];
                    predecesores[v] = u;
                }
            }
        }

        imprimirResultadoDijkstra(origen, destino, distancias, predecesores);
    }

    private int encontrarMinimaDistancia(int[] distancias, boolean[] visitados) {
        int min = Integer.MAX_VALUE;
        int minIndice = -1;

        for (int v = 0; v < cantidadNodos; v++) {
            if (!visitados[v] && distancias[v] <= min) {
                min = distancias[v];
                minIndice = v;
            }
        }
        return minIndice;
    }

    // ACOMODADO: Formato de impresión secuencial corregido sin alterar variables de cálculo
    private void imprimirResultadoDijkstra(int origen, int destino, int[] distancias, int[] predecesores) {
        if (distancias[destino] == Integer.MAX_VALUE) {
            System.out.println("\nNo existe un camino disponible entre los edificios.");
            return;
        }

        System.out.println("\n--- RESULTADO ---");
        
        // Reconstrucción del camino
        int[] caminoInvertido = new int[cantidadNodos];
        int cuentaPasos = 0;
        int pasoActual = destino;

        while (pasoActual != -1) {
            caminoInvertido[cuentaPasos] = pasoActual;
            cuentaPasos++;
            pasoActual = predecesores[pasoActual];
        }

        // Impresión secuencial corregida: NodoOrigen -> NodoSiguiente (Metros) -> NodoSiguiente (Metros)
        System.out.print("Ruta mas corta: ");
        for (int i = cuentaPasos - 1; i >= 0; i--) {
            int nodoActual = caminoInvertido[i];
            
            if (i == cuentaPasos - 1) {
                // Es el punto de partida inicial
                System.out.print(nombresEdificios[nodoActual]);
            } else {
                // Es un paso intermedio o el destino final, recuperamos el peso del tramo anterior
                int nodoAnterior = caminoInvertido[i + 1];
                int pesoTramo = matrizAdyacencia[nodoAnterior][nodoActual];
                System.out.print(" -> " + nombresEdificios[nodoActual] + " (" + pesoTramo + "m)");
            }
        }
        System.out.println();
        System.out.println("Distancia TOTAL: " + distancias[destino] + " metros");
    }

    public void mostrarMatrizAdyacencia() {
        System.out.println("\n=== MATRIZ DE ADYACENCIA DEL CAMPUS ===");
        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = 0; j < cantidadNodos; j++) {
                System.out.print(matrizAdyacencia[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
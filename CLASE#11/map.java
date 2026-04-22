import java.util.HashMap;
public class map {
    HashMap<Integer, String> mapa;

    public map(){
        mapa=new HashMap<>();
        mapa.put(101,"Laptop");
        mapa.put(102, "Mouse");
        mapa.put(103, "Teclado");
        mapa.put(101, "Monitor");
    }

    public boolean verificar(int clave){
        return mapa.containsKey(clave);
    }

    public void Mostrar(){
    mapa.forEach((key, value) -> {
    System.out.println("Código: [" + key + "] -> Producto: [" + value + "]");
    });
}
    public static void main(String[] args){
        map m=new map();
        System.out.println(m.verificar(102));

        System.out.println(m.mapa.get(101));
        m.Mostrar();
    }
    

    }
    

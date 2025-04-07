public class Herencia{

    // Inicio de la solución
public class PrecioTotal {
    // Atributos
    // Constructores
    // Metodos
    public void calcularTotales() {
    }
    public void mostrarTotales() {
    // Calculo de totales
    calcularTotales();
    System.out.println("Total Equipaje " + totalPrecios);
    System.out.println("Total Bodega " + totalBodega);
    System.out.println("Total Cabina " + totalCabina);
    }
   }
   public class Equipaje {
    // Constantes
    private static final double PESO = 10.0;
    private static final double TAMANIO = 4.5;
    private static final double PRECIO_BASE = 1000.0;
    // Atributos
    private double peso;
    private double tamanio;
    private double precioBase;
    // Constructores
    
    // Metodos
    public double calcularPrecio(){
    return 0.0;
    }
    // getters/setters de ser necesarios
   }
   public class Bodega extends Equipaje {
    // Constantes
    private static final double CAPACIDAD = 8.0;
    // Constructores
    
    // Metodos
    public double calcularPrecio(){
    // Calculos
    return precioFinal;
    }
    // getters/setters de ser necesarios
   }
   public class Cabina extends Equipaje {
    // Constantes
    private final static int TIEMPO = 2;
    // Constructores
    
    // Metodos
    public double calcularPrecio(){
    // Calculos
    return precioFinal;
    }
    // getters/setters de ser necesarios
   }
   // Fin de la solución
}
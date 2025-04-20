public class ActividadEvaluativa {
    public static void main(String[]args) {
        Equipaje equipaje[]= new Equipaje[5];
        equipaje[] = new Bodega (100.0, 10.0);
        equipaje[] = new Bodega (200);
        equipaje[] = new Cabina (150, 20.0);
        equipaje[] = new Cabina ();
        equipaje[] = new Bodega ();

        PrecioTotal solucion = new PrecioTotal (equipaje);
        solucion.mostrarTotales();

    }
}

class PrecioTotal {

    //atributos de la clase PrecioTotal

    private double totalPrecios;
    //acumula la suma de precios de todo los equipajes
    private double totalBodega;
    //acumula solo precios de tipo bodega
    private double totalCabina;
    //acumula solo precios de tipo cabina
    private Equipaje[] equipaje;
    //este arreglo almacena todos los equipajes


    //constructor
    public PrecioTotal(Equipaje[] equipaje) {
        this.equipaje = equipaje;
        //asigna el arreglo que se recibe
        this.totalPrecios = 0.0;
        this.totalBodega = 0.0;
        this.totalCabina = 0.0;
        //Inicia los totales en cero
    }

    public void calcularTotales() {
        for (Equipaje e : equipaje) {
            Totalizador totalizador = new Totalizador(this);
            e.aceptar (totalizador);
            /* e. porque este sabe si es bodega o cabina
            y llama al metodo especifico del totalizador*/
        }
    }

    //metodos acumuladores de precios
    public void agregarAlTotal(double precio) {
        totalPrecios += precio; //suma total general
    }

    public void agregarAlTotalBodega(double precio) {
        totalBodega += precio; //suma solo a bodega
    }

    public void agregarAlTotalCabina(double precio) {
        totalCabina += precio; //suma solo a cabina
    }

    public void mostrarTotales() {
        calcularTotales();// calcula los totales
        System.out.println("Total Equipaje " + totalPrecios); // muestra los resultados
        System.out.println("Total Bodega " + totalBodega);
        System.out.println("Total Cabina " + totalCabina);
    }
}

abstract class Equipaje { 
    protected static final double PESO = 10.0;
    protected static final double TAMAÑO = 4.5;
    protected static final double PRECIO_BASE = 1000.0;

    protected double peso;
    protected double tamaño;
    protected double precioBase;

//protected porque solo esta clase y sus subclases pueden acceder


//constructor
    public Equipaje(){
        this(PESO,TAMAÑO);
    }

    public Equipaje(double precioBase) {
        this();
        this.precioBase = PRECIO_BASE; 
        //constantes como valores default
    }

    //metodos
    public abstract double calcularPrecio();
    public abstract void aceptar(Totalizador totalizador);

    //metodos concretos(getters)
    public double getPeso() {
        return peso;
    }
    public double getTamaño() {
        return tamaño;
    }
    public double getPrecioBase() {
        return precioBase;
    }
}

class Bodega extends Equipaje {
    private static final double CAPACIDAD = 8.0;

    public Bodega() {
        super();
    }

    public Bodega(double precioBase) {
        super(precioBase);
    }

    public Bodega(double peso, double tamaño) {
        super(peso, tamaño);
    
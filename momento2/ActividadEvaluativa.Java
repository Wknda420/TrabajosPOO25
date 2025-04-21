public class ActividadEvaluativa {
    public static void main(String[] args) {
        Equipaje equipaje[] = new Equipaje[5];
        equipaje[0] = new Bodega(100.0, 10.0);
        equipaje[1] = new Bodega(200);
        equipaje[2] = new Cabina(150, 20.0);
        equipaje[3] = new Cabina();
        equipaje[4] = new Bodega();

        PrecioTotal solucion = new PrecioTotal(equipaje);
        solucion.mostrarTotales();
    }
}

abstract class Equipaje {
    protected static final double PESO = 10.0;
    protected static final double TAMAÑO = 4.5;
    protected static final double PRECIO_BASE = 1000.0;

    protected double peso;
    protected double tamaño;
    protected double precioBase;

    public Equipaje() {
        this(PESO, TAMAÑO);
    }

    public Equipaje(double peso, double tamaño) {
        this.peso = peso;
        this.tamaño = tamaño;
        this.precioBase = PRECIO_BASE;
    }

    public Equipaje(double precioBase) {
        this();
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecio();
    public abstract void aceptar(Totalizador totalizador);

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
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase() + (getPeso() * getTamaño() * CAPACIDAD);
    }

    @Override
    public void aceptar(Totalizador totalizador) {
        totalizador.visitarBodega(this);
    }
}

class Cabina extends Equipaje {
    private static final int TIEMPO = 2;

    public Cabina() {
        super();
    }

    public Cabina(double precioBase) {
        super(precioBase);
    }

    public Cabina(double peso, double tamaño) {
        super(peso, tamaño);
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase() + (getPeso() * getTamaño() * TIEMPO);
    }

    @Override
    public void aceptar(Totalizador totalizador) {
        totalizador.visitarCabina(this);
    }
}

class Totalizador {
    private final PrecioTotal precioTotal;

    public Totalizador(PrecioTotal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void visitarBodega(Bodega bodega) {
        double precio = bodega.calcularPrecio();
        precioTotal.agregarAlTotal(precio);
        precioTotal.agregarAlTotalBodega(precio);
    }

    public void visitarCabina(Cabina cabina) {
        double precio = cabina.calcularPrecio();
        precioTotal.agregarAlTotal(precio);
        precioTotal.agregarAlTotalCabina(precio);
    }
}

class PrecioTotal {
    private double totalPrecios;
    private double totalBodega;
    private double totalCabina;
    private Equipaje[] equipaje;

    public PrecioTotal(Equipaje[] equipaje) {
        this.equipaje = equipaje;
        this.totalPrecios = 0.0;
        this.totalBodega = 0.0;
        this.totalCabina = 0.0;
    }

    public void calcularTotales() {
        for (Equipaje e : equipaje) {
            Totalizador totalizador = new Totalizador(this);
            e.aceptar(totalizador);
        }
    }

    public void agregarAlTotal(double precio) {
        totalPrecios += precio;
    }

    public void agregarAlTotalBodega(double precio) {
        totalBodega += precio;
    }

    public void agregarAlTotalCabina(double precio) {
        totalCabina += precio;
    }

    public void mostrarTotales() {
        calcularTotales();
        System.out.println("Total Equipaje " + totalPrecios);
        System.out.println("Total Bodega " + totalBodega);
        System.out.println("Total Cabina " + totalCabina);
    }
}
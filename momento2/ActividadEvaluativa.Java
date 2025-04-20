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
    //caumula la suma de precios de todo los equipajes
    private double totalBodega;
    //acumula solo precios de tipo bodega
    private double totalCabina;
    //acumula solo precios de tipo cabina
    private Equipaje[] equipaje;
    //este arreglo almacena todos los equipajes


    public PrecioTotal(Equipaje[] equipaje) {
        this.equipaje = equipaje;
        this.totalPrecios = 0.0;
        this.totalBodega = 0.0;
        this.totalCabina = 0.0;
    }


}
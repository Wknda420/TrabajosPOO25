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

    
}
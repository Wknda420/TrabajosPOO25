package SaberesMomento3;

public class Ejecutar{//Clase para pruebas principal
    public static void main(String[] args) {
        Cliente cliente = new Cliente("1043653622", "Nicole");
        Producto producto = new Producto(111);
        Pedido pedido = new Pedido(cliente, producto, new java.util.Date(), 153684482);
    
        
        System.out.println("-x-x-x-x-x-x Detalles de su pedido x-x-x-x-x-x-");
        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("N° de producto: " + pedido.getProducto().getNumero());
        //ejemplo de agregacion


    //herencia y polimorfismo
    Foto foto1 = new Foto ("Eladio.jpg");
    foto1.print(); //metodo foto


    Impresion impresion = new Impresion("Monocromatico", foto1);
    impresion.print(); //Sobrescrito (polimorfismo)


    //ej de un objeto independiente
    Camara camara = new Camara("Honor", "X7a");
    System.out.println("Camara: " + camara.getMarca() + " " + camara.getModelo());
  }
}        
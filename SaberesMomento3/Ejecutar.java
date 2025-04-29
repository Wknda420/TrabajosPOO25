package SaberesMomento3;

public class Ejecutar{//Clase para pruebas principal
    public static void main(String[] args) {
        Cliente cliente = new Cliente("1043653622", "Nicole");
        Producto producto = new Producto(111);
        Pedido pedido = new Pedido(cliente, producto, new java.util.Date(), 153684482);
    //ejemplo de agregacion


    //herencia y polimorfismo
    Foto foto1 = new Foto ("Eladio.jpg");
    foto1.print(); //metodo foto
}
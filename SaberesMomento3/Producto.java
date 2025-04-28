package SaberesMomento3;

public class Producto {//esta clase hace que se represente con un numero identificador un producto
    private int numero;

    public Producto(int numero) {
        this.numero = numero;
    }

    //getter y setter

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}


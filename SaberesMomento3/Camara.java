package SaberesMomento3;

public class Camara {
    private String marca;
    private String modelo;

    /*la clase representa un acamara no tienen ninguna relacion de 
    forma directa con otra clase */

    //constructor
    public Camara(String  marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    //get y set
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
}

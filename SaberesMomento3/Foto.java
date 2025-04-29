package SaberesMomento3;

public class Foto {
    private String fichero; /*rpivate para obligarse a usar set y get 
    para poder interactuar con este */

    /*esta clase representa la foto, se puede relacionar
    mediante herencia con la clase impresion*/

    public Foto (String fichero){
        this.fichero = fichero;
    }

    public void print(){/*no devuelve ningun valor y muestra
        el nombre de la foto/archivo */
        System.out.println("Foto: " + fichero);
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }
}

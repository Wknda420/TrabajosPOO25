package SaberesMomento3;

class Cliente {
    private String cedula;
    private String nombre;

    //Esta clase representa un cliente con cedula y nombre

    //Constructor clase cliente
    public Cliente (String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
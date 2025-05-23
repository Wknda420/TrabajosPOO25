package Momentofinal;

public abstract class Competidor {
    protected String nombre;
    protected double peso; //peso en kg
    protected String estilo;
    protected int resistencia;
    protected int golpesEfectivos;
    protected int puntuacionJueces;

    protected static final int RESISTENCIA_INICIAL = 100;
    protected static final int MAX_GOLPE = 25;
    protected static final int MIN_GOLPE = 5;

    public Competidor(String nombre, double peso, String estilo) {
        this.nombre = nombre;
        this.peso = peso;
        this.estilo = estilo;
        this.resistencia = RESISTENCIA_INICIAL;
        this.golpesEfectivos = 0;
        this.puntuacionJueces = 0;
    }

    public abstract void atacar(Competidor oponente);
    public abstract int defender();

    public void recibirGolpe(int daño) {
        int dañoRecibido = (int)(daño*(1.0 - this.defender() / 100.0));
        this.resistencia -= dañoRecibido;
        if (this.resistencia <0) this.resistencia = 0;
    }

    public boolean estaEnPie() {
        return this.resistencia > 20;
    }

    public void añadirPuntuacion(int puntos) {
        this.puntuacionJueces += puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public String getEstilo() {
        return estilo;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getGolpesEfectivos() {
        return golpesEfectivos;
    }

    public int getPuntuacionJueces() {
        return puntuacionJueces;
    }
}
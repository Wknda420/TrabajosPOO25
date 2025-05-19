package Momentofinal;

import java.util.Random;
import java.util.Scanner;

/*La clase que va a representar un competidor amater*/

abstract class Competidor {
    protected String nombre;
    protected double peso; //peso en kg
    protected int resistencia;
    protected int golpesEfectivos;
    protected int puntuacionJueces;

    protected static final int RESISTENCIA_INICIAL = 100;
    protected static final int MAX_GOLPE = 25;
    protected static final int MIN_GOLPE = 5;

    public Competidor(String nombre, douuble peso, String estilo) {
        this.nombre = nombre;
        this.peso = peso;
        this.estilo = estilo;
        this.resistencia = RESISTENCIA_INICIAL;
        this.golpesEfectivos = 0;
        this.puntuacionJueces = 0;
    }

}
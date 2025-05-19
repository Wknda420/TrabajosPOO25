package Momentofinal;

import java.util.Random;
import java.util.Scanner;

/*La clase que va a representar un competidor amater*/

abstract class Competidor {
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

    //getters

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

/*Esta clase representa a un competidor de kickboxing*/

class Kickboxing extends Competidor {

    public Kickboxing(String nombre, double peso) {
        super (nombre, peso, "Kickboxing");
    }

    @Override
    public void atacar(Competidor oponente) {
        Random rand = new Random();
        double modificadorPeso= this.peso / 70.0;
        double modificadorResistencia = this.resistencia / 100.0;

        int dañoBase = rand.nextInt((MAX_GOLPE - MIN_GOLPE) + 1) + MIN_GOLPE;
        //Kickboxing tiene ataques balanceados

        if (rand.nextDouble()> 0.5) {
            dañoBase += 3; //ataque balanceado

            System.out.println(this.nombre + "Realizo una combinacion de patda y puño!");
        }

        int daño = (int)(dañoBase * modificadorPeso * modificadorResistencia);

        oponente.recibirGolpe(daño);
        this.golpesEfectivos++;

        this.resistencia -= rand.nextInt (10) + 5; //el desgaste medio

        if (this.resistencia < 0) this.resistencia = 0;

        System.out.println(this.nombre + "Ataca con tecnica de Kickboxing a " + oponente.getNombre() + "(" + daño + " Puntos de daño). Resistencia: " + this.resistencia);

    }

    @Override
    public int defender() {
        return new Random().nextInt(30); //defensa media
    }
}

}
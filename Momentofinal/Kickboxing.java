package Momentofinal;

import java.util.Random;

public class Kickboxing extends Competidor {
    public Kickboxing(String nombre, double peso) {
        super(nombre, peso, "Kickboxing");
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
            System.out.println(this.nombre + " Realizo una combinacion de patada y puño!");
        }

        int daño = (int)(dañoBase * modificadorPeso * modificadorResistencia);

        oponente.recibirGolpe(daño);
        this.golpesEfectivos++;

        this.resistencia -= rand.nextInt(10) + 5; //el desgaste medio
        if (this.resistencia < 0) this.resistencia = 0;

        System.out.println(this.nombre + " Ataca con tecnica de Kickboxing a " + oponente.getNombre() + " (" + daño + " Puntos de daño). Resistencia: " + this.resistencia);
    }

    @Override
    public int defender() {
        return new Random().nextInt(30); //defensa media(30%)
    }
}
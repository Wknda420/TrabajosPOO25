package Momentofinal;

import java.util.Random;

public class Boxeo extends Competidor {
    public Boxeo(String nombre, double peso) {
        super(nombre, peso, "Boxeo");
    }

    @Override
    public void atacar(Competidor oponente) {
        Random rand = new Random();
        double modificadorPeso = this.peso / 70.0;
        double modificadorResistencia = this.resistencia / 100.0;

        int dañoBase = rand.nextInt((MAX_GOLPE - MIN_GOLPE) + 1) + MIN_GOLPE;
        if(rand.nextDouble() > 0.6) {
            dañoBase += 5; //Combinacion
            System.out.println(this.nombre + " conecto una combinacion rapida de puños!");
        }

        int daño = (int)(dañoBase * modificadorPeso * modificadorResistencia);

        oponente.recibirGolpe(daño);
        this.golpesEfectivos++;

        this.resistencia -= rand.nextInt(10) + 4; //desgaste medio
        if (this.resistencia < 0) this.resistencia = 0;

        System.out.println(this.nombre + " golpea con tecnica de Boxeo a " + oponente.getNombre() + " (" + daño + " puntos de daño). Resistencia: " + this.resistencia);
    }

    @Override
    public int defender() { 
        return new Random().nextInt(35); //Buena defensa(35%)
    }
}
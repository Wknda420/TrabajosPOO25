package Momentofinal;

import java.util.Random;

public class MuayThai extends Competidor {
    public MuayThai(String nombre, double peso) {
        super(nombre, peso, "Muay Thai");
    }

    @Override
    public void atacar(Competidor oponente) { 
        Random rand = new Random();
        double modificadorPeso = this.peso / 70.0;
        double modificadorResistencia = this.resistencia / 100.0;

        int dañoBase = rand.nextInt((MAX_GOLPE - MIN_GOLPE) + 1) + MIN_GOLPE + 5; //+5 por estilo

        int daño = (int) (dañoBase * modificadorPeso * modificadorResistencia);

        oponente.recibirGolpe(daño);
        this.golpesEfectivos++;

        this.resistencia -= rand.nextInt(12) + 5; //Desgaste mayor
        if (this.resistencia < 0) this.resistencia = 0;

        System.out.println(this.nombre + " Lanza una patada con potencia de muay thai a " + oponente.getNombre() + " (" + daño + " puntos de daño). Resistencia: " + this.resistencia);
    }

    @Override
    public int defender() {
        return new Random().nextInt(20); //defensa menor (20%)
    }
}
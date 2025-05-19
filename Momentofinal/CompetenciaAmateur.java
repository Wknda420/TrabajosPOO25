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
        return new Random().nextInt(30); //defensa media(30%)
    }
}

/*esta clase representa un competidor de muaythai*/

class MuayThai extends Competidor {
    public MuayThai (String nombre, double peso) {
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

        System.out.println(this.nombre + "Lanza una patada con potencia de muay thai a " + oponente.getNombre() + "(" + daño + "puntos de daño). Resistencia: " + this.resistencia);
    }

    @Override
    public int defender() {
        return new Random().nextInt(20); //defensa menor (20%)
    }

}

/*la clase representa un competidor de boxeo*/

class Boxeo extends Competidor {
    public Boxeo(String nombre, double peso) {
        super(nombre, peso, "Boxeo");
    }

    @Override
    public void atacar (Competidor oponente) {
        Random rand = new Random();
        double modificadorPeso = this.peso / 70.0;
        double modificadorResistencia 0 this.resistencia / 100.0;

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

        System.out.println(this.nombre + "golpea con tecnica de Boxeo a " + oponente.getNombre() + "(" + daño + " puntos de daño). Resistencia: " + this.resistencia);
    }

    @Override
    public int defender() { 
        return new Random().nextInt(35); //Buena dfensa(35%)
    }
}

/*esta clase maneja la competencia*/

class CompetenciaAmater{
    private Competidor esquinaRoja;
    private Competidor esquinaAzul;
    private int asaltoActual;
    private static final int TOTAL_ASALTOS = 3; 

    public CompetenciaAmater(Competidor esquinaRoja, Competidor esquinaAzul) {
        this.esquinaRoja = esquinaRoja;
        this.esquinaAzul = esquinaAzul;
        this.asaltoActual = 1;
    }

    public void iniciarCombate(){
        System.out.println("Comienza el combate amateur");
        System.out.println(esquinaRoja.getNombre() + "(" + esquinaRoja.getEstilo() +  ", " + esquinaRoja.getPeso() + "kg)");
        System.out.println(" vs ");
        System.out.println(esquinaAzul.getNombre() + "(" + esquinaAzul.getEstilo() +  ", " + esquinaAzul.getPeso() + "kg)");
        System.out.println("-----------------------------------------------------------------------------------------------");

        /*esta parte controla el bucle del combate o se alos asalto y descansos entre rounds */
        while (asaltoActual <= TOTAL_ASALTOS && esquinaRoja.estaEnPie() && esquinaAzul.estaEnPie()) {
            ejecutarAsalto();
            asaltoActual++; //aumenta los asaltos ejecutados que son de 1 a 3


            /*descanso de los asaltos */
            if (asaltoActual <= TOTAL_ASALTOS && esquinaRoja.estaEnPie() && esquinaAzul.estaEnPie()) {

                System.out.println("----- DESCANSO ENTRE ASALTO -----");
                esquinaRoja.resistencia += 15;
                esquinaAzul.resistencia += 15;
                if (esquinaRoja.resistencia > 100) esquinaRoja.resistencia = 100;
                if (esquinaAzul.resistencia > 100) esquinaAzul.resistencia = 100; 
            }
        }

        mostrarResultado();
    }

    private void ejecutarAsalto() {

        System.out.println(" ASALTO " + asaltoActual + " - ¡GO!");

        int accionesPorAsalto = 5;
        for (int i = 1; i <= accionesPorAsalto && esquinaRoja.estaEnPie() && esquinaAzul.estaEnPie(); i++){
            System.out.println("Accion " + i + ":");

            if (i % 2 == 0) {
                esquinaAzul.atacar(esquinaRoja);
                if (esquinaRoja.estaEnPie()) { 
                    esquinaRoja.atacar(esquinaAzul);
                }
            } else {
                esquinaRoja.atacar(esquinaAzul);
                if (esquinaAzul.estaEnPie()) {
                    esquinaAzul.atacar(esquinaRoja);
                }
            }
        }

        puntuarAsalto() {
            Random rand = new Random();
            int puntos1 = esquinaRoja.getGolpesEfectivos() * 2 + esquinaRoja.getResistencia() / 10 + rand.nextInt(5);
            int puntos2 = esquinaAzul.getGolpesEfectivos() * 2 + esquinaAzul.getResistencia() / 10 + rand.nextInt(5);

            esquinaRoja.añadirPuntuacion(puntos1);
            esquinaAzul.añadirPuntuacion(puntos2);

            System.out.println(" Puntuacion del asalto " + asaltoActual + ":");
            System.out.println(esquinaRoja.getNombre() + ":" + puntos1 + " puntos");
            System.out.println(esquinaAzul.getNombre() + ": " + puntos2 + " puntos");
        }

        private void mostrarResultado() {
            System.out.println("---------RESULTADO FINAL---------");

            if (!esquinaRoja.estaEnPie() && !esquinaAzul.estaEnPie()) {
                System.out.println("¡Doble KO! El combate se empata.");
            }else if (!esquinaAzul.estaEnPie()) {
                System.out.println("¡KO! " + esquinaAzul.getNombre() + "gana el combate!");
            } else { 
                System.out.println("Desicion de los jueces: ");
                System.out.println(esquinaRoja.getNombre() + ": " + esquinaRoja.getPuntuacionJueces() + " puntos");
                System.out.println(esquinaAzul.getNombre() + ": " + esquinaAzul.getPuntuacionJueces() + " puntos");

                if(esquinaRoja.getPuntuacionJueces() > esquinaAzul.getPuntuacionJueces()) {
                    System.out.println("¡Ganador por decision unanime: " + esquinaRoja.getNombre() + "!");
                }else if (esquinaAzul.getPuntuacionJueces() > esquinaRoja.getPuntuacionJueces()) {
                    System.out.println("¡Ganador por desicion dividida: " + esquinaAzul.getNombre() + "!");
                }else {
                    System.out.println("¡El combate termina en EMPATE!");
                }
            }
    }

    /*ejecutar */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("BIENVENIDO AL SIMULADOR DE COMBATES AMATEUR");
        System.out.println("-------------------------------------------");

        System.out.println("Datos de la esquina roja: ");
        System.out.print("Nombre: ");
        String nombre1 = scanner.nextLine();
        System.out.println("Peso (kg): ");
        double peso1 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Estilo (1- Kickboxing, 2- MuayThai, 3- Boxeo): ");
        int estilo1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Datos de la esquina azul: ");
        System.out.print("Nombre: ");
        String nombre2 = scanner.nextLine();
        System.out.println("Peso (kg): ");
        double peso2 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Estilo (1- Kickboxing, 2- MuayThai, 3- Boxeo): ");
        int estilo2 = scanner.nextInt();
        scanner.nextLine();

        Competidor e1 = crearCompetidor(estilo1, nombre1, peso1);
        Competidor e2 = crearCompetidor(estilo2, nombre2, peso2),

        CompetenciaAmater competencia = new CompetenciaAmater(e1, e2);

        competencia.iniciarCombate();

        scanner.close();
    }

    private static Competidor crearCompetidor(int estilo, String nombre, double peso) {
        switch (estilo) {
            case 1: return new Kickboxing(nombre, peso);
            case 2: return new MuayThai(nombre, peso);
            case 3: return new Boxeo(nombre, peso);
            default: return new Kickboxing(nombre, peso);
        }
    }
 }
}
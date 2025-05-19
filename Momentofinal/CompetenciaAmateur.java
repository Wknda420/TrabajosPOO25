package Momentofinal;

import java.util.Scanner;
import java.util.Random;

public class CompetenciaAmateur {
    private Competidor esquinaRoja;
    private Competidor esquinaAzul;
    private int asaltoActual;
    private static final int TOTAL_ASALTOS = 3; 

    public CompetenciaAmateur(Competidor esquinaRoja, Competidor esquinaAzul) {
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

        while (asaltoActual <= TOTAL_ASALTOS && esquinaRoja.estaEnPie() && esquinaAzul.estaEnPie()) {
            ejecutarAsalto();
            puntuarAsalto();
            asaltoActual++;

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
            System.out.println("COMBINACION " + i + ": ");

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
    }

    private void puntuarAsalto() {
        Random rand = new Random();
        int puntos1 = esquinaRoja.getGolpesEfectivos() * 2 + esquinaRoja.getResistencia() / 10 + rand.nextInt(5);
        int puntos2 = esquinaAzul.getGolpesEfectivos() * 2 + esquinaAzul.getResistencia() / 10 + rand.nextInt(5);

        esquinaRoja.añadirPuntuacion(puntos1);
        esquinaAzul.añadirPuntuacion(puntos2);

        System.out.println(" Puntuacion del asalto " + asaltoActual + ": ");
        System.out.println(esquinaRoja.getNombre() + ": " + puntos1 + " puntos");
        System.out.println(esquinaAzul.getNombre() + ": " + puntos2 + " puntos");
    }

    private void mostrarResultado() {
        System.out.println("---------RESULTADO FINAL---------");

        if (!esquinaRoja.estaEnPie() && !esquinaAzul.estaEnPie()) {
            System.out.println("¡Doble KO! El combate se empata.");
        }else if (!esquinaAzul.estaEnPie()) {
            System.out.println("¡KO! " + esquinaAzul.getNombre() + " gana el combate!");
        } else { 
            System.out.println("Desicion de los jueces: ");
            System.out.println(esquinaRoja.getNombre() + ": " + esquinaRoja.getPuntuacionJueces() + " puntos");
            System.out.println(esquinaAzul.getNombre() + ": " + esquinaAzul.getPuntuacionJueces() + " puntos");

            if(esquinaRoja.getPuntuacionJueces() > esquinaAzul.getPuntuacionJueces()) {
                System.out.println("¡Ganador por decision unanime: " + esquinaRoja.getNombre() + " !");
            }else if (esquinaAzul.getPuntuacionJueces() > esquinaRoja.getPuntuacionJueces()) {
                System.out.println("¡Ganador por desicion dividida: " + esquinaAzul.getNombre() + "!");
            }else {
                System.out.println("¡El combate termina en EMPATE!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("BIENVENIDO AL SIMULADOR DE COMBATES AMATEUR");
        System.out.println("-------------------------------------------");

        System.out.println("Datos de la esquina roja| ");
        System.out.print("Nombre: ");
        String nombre1 = scanner.nextLine();
        System.out.println("Peso (kg): ");
        double peso1 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Estilo (1- Kickboxing, 2- MuayThai, 3- Boxeo): ");
        int estilo1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Datos de la esquina azul| ");
        System.out.print("Nombre: ");
        String nombre2 = scanner.nextLine();
        System.out.println("Peso (kg): ");
        double peso2 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Estilo (1- Kickboxing, 2- MuayThai, 3- Boxeo): ");
        int estilo2 = scanner.nextInt();
        scanner.nextLine();

        Competidor e1 = crearCompetidor(estilo1, nombre1, peso1);
        Competidor e2 = crearCompetidor(estilo2, nombre2, peso2);

        CompetenciaAmateur competencia = new CompetenciaAmateur(e1, e2);

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
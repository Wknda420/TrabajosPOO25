import java.util.Scanner;

public class TarifadorParqueaderos {
    private static boolean[] puestos = new boolean[20]; // 20 puestos, false=libre
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Registrar moto\n2. Cobrar\n3. Salir");
            int op = sc.nextInt();
            
            if (op == 1) registrarMoto();
            else if (op == 2) cobrar();
            else if (op == 3) break;
        }
    }

    public static void registrarMoto() {
        System.out.print("Puesto (1-20): ");
        int puesto = sc.nextInt() - 1;
        
        if (puesto < 0 || puesto >= 20) {
            System.out.println("Puesto inválido");
            return;
        }
        
        if (puestos[puesto]) System.out.println("Ocupado");
        else {
            puestos[puesto] = true;
            System.out.println("Registrado");
        }
    }

    public static void cobrar() {
        System.out.print("Puesto (1-20): ");
        int puesto = sc.nextInt() - 1;
        
        if (!puestos[puesto]) {
            System.out.println("Libre");
            return;
        }
        
        System.out.print("Minutos: ");
        int minutos = sc.nextInt();
        
        int tarifa = minutos <= 30 ? 0 : minutos <= 60 ? 800 : 2000;
        System.out.println("Total: $" + tarifa);
        
        puestos[puesto] = false;
    }
}
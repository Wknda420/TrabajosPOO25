import java.util.Scanner;
public class TarifadorParqueaderos {

    // Variables globales
    private static boolean[] puestosMotos = new boolean[20]; // false = disponible, true = ocupado
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    // Menú principal
    public static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar moto");
            System.out.println("2. Cobrar tarifa");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    registrarMoto();
                    break;
                case 2:
                    cobrarTarifa();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while(opcion != 3);
    }

    // Registrar una moto en el parqueadero
    public static void registrarMoto() {
        mostrarDisponibilidad();
        
        if(!hayPuestosDisponibles()) {
            System.out.println("No hay puestos disponibles para motos.");
            return;
        }
        
        System.out.print("Ingrese el número de puesto deseado (1-20): ");
        int puesto = scanner.nextInt() - 1;
        
        if(puesto < 0 || puesto >= 20) {
            System.out.println("Número de puesto no válido.");
            return;
        }
        
        if(puestosMotos[puesto]) {
            System.out.println("El puesto " + (puesto+1) + " ya está ocupado.");
        } else {
            puestosMotos[puesto] = true;
            System.out.println("Moto registrada en el puesto " + (puesto+1) + " exitosamente.");
        }
    }

    // Cobrar tarifa por el tiempo estacionado
    public static void cobrarTarifa() {
        mostrarDisponibilidad();
        
        System.out.print("Ingrese el número de puesto a cobrar (1-20): ");
        int puesto = scanner.nextInt() - 1;
        
        if(puesto < 0 || puesto >= 20) {
            System.out.println("Número de puesto no válido.");
            return;
        }
        
        if(!puestosMotos[puesto]) {
            System.out.println("El puesto " + (puesto+1) + " está vacío.");
            return;
        }
        
        System.out.print("Ingrese los minutos estacionados: ");
        int minutos = scanner.nextInt();
        
        int tarifa = calcularTarifa(minutos);
        System.out.println("Total a pagar: $" + tarifa);
        
        puestosMotos[puesto] = false;
        System.out.println("Puesto " + (puesto+1) + " liberado.");
    }

    // Calcular tarifa según el tiempo
    public static int calcularTarifa(int minutos) {
        if(minutos <= 30) {
            return 0;
        } else if(minutos <= 60) {
            return 800;
        } else {
            return 2000;
        }
    }

    // Mostrar disponibilidad de puestos
    public static void mostrarDisponibilidad() {
        System.out.println("\n=== DISPONIBILIDAD DE PUESTOS PARA MOTOS ===");
        for(int i = 0; i < puestosMotos.length; i++) {
            System.out.print("Puesto " + (i+1) + ": ");
            System.out.println(puestosMotos[i] ? "Ocupado" : "Disponible");
        }
    }

    // Verificar si hay puestos disponibles
    public static boolean hayPuestosDisponibles() {
        for(boolean puesto : puestosMotos) {
            if(!puesto) return true;
        }
        return false;
    }
}

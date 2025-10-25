import java.util.Scanner;

public class UtilidadConsola {
  public static String pedirString(Scanner scanner, String valor) {
    System.out.print(valor);
    String dato = scanner.nextLine().trim();
    return dato;
  }

  public static int pedirInt(Scanner scanner, String valor) {
    while (true) {
      System.out.print(valor);
      if (scanner.hasNextInt()) {
        int dato = scanner.nextInt();
        scanner.nextLine();
        return dato;
      } else {
        System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
        scanner.nextLine();
      }
    }
  }
    
  public static boolean pedirBoolean(Scanner scanner, String valor) {
    String dato;
    while (true) {
      System.out.print(valor);
      dato = scanner.nextLine().trim().toLowerCase();
      if (dato.equals("s")) {
        return true;
      } else if (dato.equals("n")) {
        return false;
      } else {
        System.out.println("Entrada inválida. Por favor, ingrese 'S' (Sí) o 'N' (No).");
      }
    }
  }  
}

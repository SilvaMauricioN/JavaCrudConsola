import java.util.Scanner;

public class App {
  private static final GenerarId generadorId = new GenerarId();
  private static Scanner scanner = new Scanner(System.in);

  private static AutorPrincipalServicio autorServicio = new AutorPrincipalServicio(generadorId);
  private static ObraArteServicio obraArteServicio = new ObraArteServicio(generadorId);
  public static void main(String[] args) {
    autorServicio.setObraArteServicio(obraArteServicio);
    obraArteServicio.setServicioAutor(autorServicio);
 

    int opcion;

    do {
      mostrarMenuPrincipal();
      opcion = UtilidadConsola.pedirInt(scanner, "Seleccione una opción: ");
      System.out.println();
      System.out.println();

      switch (opcion) {
        case 1:
          menuGestionarAutores();
          break;
        case 2:
          menuGestionarObraDeArte();
          break;
        case 0:
          break;
        default:
          System.out.println("Opción no válida. Inténtalo de nuevo.");
      }
    } while (opcion != 0);
    scanner.close();
  }

  private static void mostrarMenuPrincipal() {
    System.out.println("\n==================================");
    System.out.println("      APLICACION CRUD DE ARTE       ");
    System.out.println("====================================");
    System.out.println();
    System.out.println("1. Gestión de Autores Principales");
    System.out.println("2. Gestión de Obras de Arte");
    System.out.println("0. Salir");
  }
    
  // --- SUBMENÚ DE AUTORES ---
    
  private static void menuGestionarAutores() {
    int opcion;
    do {
      System.out.println("\n--- MENU AUTORES ---");
      System.out.println();
      System.out.println("1. Crear Autor");
      System.out.println("2. Listar Todos");
      System.out.println("3. Actualizar Autor");
      System.out.println("4. Eliminar Autor");
      System.out.println("0. Volver al Menú Principal");
      opcion = UtilidadConsola.pedirInt(scanner, "Seleccione una opción: ");
      System.out.println();
      System.out.println();
        
      switch (opcion) {
        case 1:
            autorServicio.crear(scanner);
            break;
        case 2:
            autorServicio.listarTodos();
            break;
        case 3:
            autorServicio.actualizar(scanner);
            break;
        case 4:
            autorServicio.eliminar(scanner);
            break;
        case 0:
            break;
        default:
            System.out.println("Opción no válida.");
      }
    } while (opcion != 0);
  }
    
    // --- SUBMENÚ DE OBJETOS DE ARTE ---

  private static void menuGestionarObraDeArte() {
    int opcion;
    do {
      System.out.println("\n--- MENU OBRA DE ARTE ---");
      System.out.println();
      System.out.println("1. Crear Obra de Arte");
      System.out.println("2. Listar Todos");
      System.out.println("3. Actualizar Obra de Arte");
      System.out.println("4. Eliminar Obra de Arte");
      System.out.println("0. Volver al Menú Principal");
      opcion = UtilidadConsola.pedirInt(scanner, "Seleccione una opción: ");
      System.out.println();
      System.out.println();
        
      switch (opcion) {
        case 1:
          obraArteServicio.crear(scanner);
          break;
        case 2:
          obraArteServicio.listarTodos();
          break;
        case 3:
          obraArteServicio.actualizar(scanner);
          break;
        case 4:
          obraArteServicio.eliminar(scanner);
          break;
        case 0:    
          break;
        default:
          System.out.println("Opción no válida.");
      }
    } while (opcion != 0);
  }
}
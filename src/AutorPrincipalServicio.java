import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Implementa la interfaz CRUDService para la entidad AutorPrincipal
public class AutorPrincipalServicio implements ServicioCrud<AutorPrincipal> {    
  private List<AutorPrincipal> listaAutores = new ArrayList<>();
  private ObraArteServicio obraArteServicio;
  private final GenerarId generadorId; 

  public AutorPrincipalServicio(GenerarId generarID) {
    this.generadorId = generarID;
    // Inicializar datos
    listaAutores.add(new AutorPrincipal(generadorId.getNextAutorId(), "Leonardo da Vinci", "Vinci, Italia", "15/04/1452", "Amboise, Francia", "02/05/1519", "Italiana"));
    listaAutores.add(new AutorPrincipal(generadorId.getNextAutorId(), "Vincent van Gogh", "Zundert, Países Bajos", "30/03/1853", "Auvers-sur-Oise, Francia", "29/07/1890", "Neerlandesa"));
    listaAutores.add(new AutorPrincipal(generarID.getNextAutorId(),"Frida Kahlo", "Coyoacán, México", "06/07/1907", "Coyoacán, México", "13/07/1954", "Mexicana"));
  }
    
  // Método para inicializar obraArteServicio
  public void setObraArteServicio(ObraArteServicio obraArteServicio) {
    this.obraArteServicio = obraArteServicio;
  }
       
  @Override
  public void crear(Scanner scanner) {
    System.out.println("\n--- CREAR AUTOR PRINCIPAL ---");
    String nombre = UtilidadConsola.pedirString(scanner, "Nombre: ");
    String lugarNac = UtilidadConsola.pedirString(scanner, "Lugar de Nacimiento: ");
    String fechaNac = UtilidadConsola.pedirString(scanner, "Fecha de Nacimiento (DD/MM/AAAA): ");    
    String lugarFallec = UtilidadConsola.pedirString(scanner, "Lugar de Muerte (dejar vacío si está vivo): ");
    String fechaFallec = UtilidadConsola.pedirString(scanner, "Fecha de Muerte (dejar vacío si está vivo): ");
    String nacionalidad = UtilidadConsola.pedirString(scanner, "Nacionalidad: ");

    AutorPrincipal nuevoAutor = new AutorPrincipal(
      generadorId.getNextAutorId(), nombre, lugarNac, fechaNac, lugarFallec, fechaFallec, nacionalidad
    );
    listaAutores.add(nuevoAutor);
    System.out.println("Autor creado con éxito: ID " + nuevoAutor.getIdAutorPrincipal());
    System.out.println(nuevoAutor.toString());
  }

  @Override
  public void listarTodos() {
    if (listaAutores.isEmpty()) {
      System.out.println("No hay autores registrados.");
      return;
    }
    System.out.println("\n--- LISTA DE AUTORES PRINCIPALES ---");
    System.out.println();
    System.out.printf("%-4s | %-19s | %-19s | %-19s | %-17s | %-18s| %-19s%n",
        "ID", "Nombre", "Lugar Nac.", "Fecha Nac.", "Lugar Fallec.", "Fecha Fallec.", "Nac.");
    System.out.println(" -".repeat(60));

    for(AutorPrincipal autor : listaAutores){
      System.out.println(autor.toString());
    }
  }
    
  @Override
  public AutorPrincipal obtenerPorId(int id) {
    for (AutorPrincipal autor : listaAutores) {
      if (autor.getIdAutorPrincipal() == id) {
        return autor;
      }
    }
    return null;
  }
    
  @Override
  public void actualizar(Scanner scanner) {
    int id = UtilidadConsola.pedirInt(scanner, "ID del Autor a actualizar: ");
    AutorPrincipal autor = obtenerPorId(id);

    if (autor == null) {
      System.out.println("Autor con ID " + id + " no encontrado.");
      return;
    }

    System.out.println("Actualizando Autor: " + autor.getNombre() + ". Deje vacío para mantener el valor actual.");
    
    String nombre = UtilidadConsola.pedirString(scanner, "Nuevo Nombre (" + autor.getNombre() + "): ");
    if (!nombre.isEmpty()) autor.setNombre(nombre);

    String lugarNac = UtilidadConsola.pedirString(scanner, "Nuevo Lugar de Nacimiento (" + autor.getLugarDeNacimiento() + "): ");
    if (!lugarNac.isEmpty()) autor.setLugarDeNacimiento(lugarNac);
    
    String fechaNac = UtilidadConsola.pedirString(scanner, "Nueva Fecha de Nacimiento (" + autor.getFechaDeNacimiento() + "): ");
    if (!fechaNac.isEmpty()) autor.setFechaDeNacimiento(fechaNac);
        
    String lugarfallec = UtilidadConsola.pedirString(scanner, "Nuevo Lugar de Fallecimiento  (" + autor.getLugarDeFallec() + "): ");
    if (!lugarfallec.isEmpty()) autor.setLugarDeFallec(lugarfallec);

    String fechafallec = UtilidadConsola.pedirString(scanner, "Nueva Fecha de Fallecimiento  (" + autor.getFechaDeFallec() + "): ");
    if (!fechafallec.isEmpty()) autor.setFechaDeFallec(fechafallec);
    
    String nacionalidad = UtilidadConsola.pedirString(scanner, "Nueva Nacionalidad (" + autor.getNacionalidad() + "): ");
    if (!nacionalidad.isEmpty()) autor.setNacionalidad(nacionalidad);
    
    System.out.println("Autor con ID " + id + " actualizado con éxito.");
    System.out.println(autor.toString());
  }

  @Override
  public void eliminar(Scanner scanner) {
    int id = UtilidadConsola.pedirInt(scanner, "ID del Autor a eliminar: ");
    AutorPrincipal autor = obtenerPorId(id);

    if (autor == null) {
      System.out.println("Autor con ID " + id + " no encontrado.");
      return;
    }

    // Validar si existen obras del autor antes de eliminar
    boolean obrasAsociadas = obraArteServicio.tieneObrasDeAutor(id);                            
    if (obrasAsociadas) {
      System.out.println("Error: No se puede eliminar al autor " + autor.getNombre() + " porque tiene " + obrasAsociadas + " objetos de arte asociados.");
      return;
    }
    
    if (listaAutores.remove(autor)) {
      System.out.println("Autor " + autor.getNombre() + " (ID " + id + ") eliminado con éxito.");
    }
  }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Implementa la interfaz CRUDService para la entidad ObjetoArte
public class ObraArteServicio implements ServicioCrud<ObraArte> {
    
  private List<ObraArte> listaObras = new ArrayList<>();
  private AutorPrincipalServicio autorServicio;
  private final GenerarId generadorId; 

  public ObraArteServicio(GenerarId generarID) {
    this.generadorId = generarID;
  }

  public void setServicioAutor(AutorPrincipalServicio autorServicio) {
    this.autorServicio = autorServicio;
    inicializarObras();
  }

  private void inicializarObras (){
    listaObras.add(new ObraArte(generadorId.getNextObraArteId(), "Mona Lisa", 1, "Oleo sobre tabla de álamo", "Sfumato", "Pintura"));
    listaObras.add(new ObraArte(generadorId.getNextObraArteId(),"La Ultima Cena", 1, "Tempera y oleo sobre yeso", "Fresco", "Pared del refectorio"));
    listaObras.add(new ObraArte(generadorId.getNextObraArteId(),"La Noche Estrellada", 2, "Oleo", "Pintura al óleo", "Lienzo"));
    listaObras.add(new ObraArte(generadorId.getNextObraArteId(),"Las Dos Fridas", 3, "Oleo", "Pintura al óleo", "Lienzo"));
  }
    
  public List<ObraArte> obtenerTodos() {
    return listaObras;
  }

  @Override
  public void crear(Scanner scanner) {
    System.out.println("\n--- CREAR OBRA DE ARTE ---");
    String titulo = UtilidadConsola.pedirString(scanner, "Título: ");
    int idAutor = UtilidadConsola.pedirInt(scanner, "ID del Autor Principal: ");
    
    AutorPrincipal autor = autorServicio.obtenerPorId(idAutor);
    if (autor == null) {
      System.out.println("Error: Autor con ID " + idAutor + " no encontrado. No se puede crear obra de arte.");
      return;
    }
    
    String materiales = UtilidadConsola.pedirString(scanner, "Materiales: ");
    String tecnicas = UtilidadConsola.pedirString(scanner, "Técnicas: ");
    String medioFisico = UtilidadConsola.pedirString(scanner, "Medio Físico: ");

    ObraArte nuevaObra = new ObraArte(
      generadorId.getNextAutorId(), titulo, idAutor, materiales, tecnicas, medioFisico
    );
    listaObras.add(nuevaObra);
    System.out.println("Obra de Arte creado con éxito: ID" + nuevaObra.getIdObraArte());
    System.out.println();
    System.out.println(nuevaObra.toString(autor.getNombre()));
  }

  @Override
  public void listarTodos() {
    if (listaObras.isEmpty()) {
      System.out.println("No hay obras de arte registradas.");
      return;
    }
    System.out.println("\n--- LISTA DE OBRAS DE ARTE ---");
    System.out.println();

    System.out.printf("%-4s | %-19s | %-19s | %-25s | %-19s | %-19s%n",
        "ID", "Título", "Autor", "Materiales", "Técnicas", "Medio Físico");
    System.out.println(" -".repeat(63));
    for(ObraArte obra : listaObras){
      String autorPrincipal = nombreArtista(obra.getAutorPrincipalId());

      System.out.println(obra.toString(autorPrincipal));
      System.out.println();
    }
  }

  private String nombreArtista (int idAutorPrincipal){
    AutorPrincipal autorPrincipal = autorServicio.obtenerPorId(idAutorPrincipal);
    if(autorPrincipal == null){
      return "N/A";
    }    
    String nombreAutor = autorPrincipal.getNombre();
    
    return nombreAutor;
  }
    
  @Override
  public ObraArte obtenerPorId(int id) {
    for (ObraArte obra : listaObras) {
      if (obra.getIdObraArte() == id) {
        return obra;
      }
    }
    return null;    
  }
    
  @Override
  public void actualizar(Scanner scanner) {
    int id = UtilidadConsola.pedirInt(scanner, "ID de Obra de Arte a actualizar: ");
    ObraArte obra = obtenerPorId(id);

    if (obra == null) {
      System.out.println("Obra de Arte con ID " + id + " no encontrado.");
      return;
    }

    System.out.println("Actualizando Obra: " + obra.getTitulo() + ". Deje vacío para mantener el valor actual.");
    
    String titulo = UtilidadConsola.pedirString(scanner, "Nuevo Título (" + obra.getTitulo() + "): ");
    if (!titulo.isEmpty()) obra.setTitulo(titulo);

    // Lógica de actualización del Autor Principal
    int idAutor = UtilidadConsola.pedirInt(scanner, "Nuevo ID de Autor (" + obra.getAutorPrincipalId()+ "): ");
   
    try {
      AutorPrincipal nuevoAutor = autorServicio.obtenerPorId(idAutor);
      if (nuevoAutor != null) {
        obra.setAutorPrincipal(idAutor);
      } else {
        System.out.println("Autor con ID " + idAutor + " no encontrado. Se mantiene el autor anterior.");
      }
    } catch (NumberFormatException e) {
        System.out.println("Entrada inválida para ID de Autor. Se mantiene el autor anterior.");
    }  
    
    String materiales = UtilidadConsola.pedirString(scanner, "Nuevos Materiales (" + obra.getMateriales() + "): ");
    if (!materiales.isEmpty()) obra.setMateriales(materiales);

    String tecnica = UtilidadConsola.pedirString(scanner, "Nueva Tecnica (" + obra.getTecnicas() + "): ");
    if (!tecnica.isEmpty()) obra.setTecnicas(tecnica);

    String medioFisico = UtilidadConsola.pedirString(scanner, "Nuevo Medio Físico (" + obra.getMedioFisico() + "): ");
    if (!medioFisico.isEmpty()) obra.setMedioFisico(medioFisico);

    AutorPrincipal nuevoAutor = autorServicio.obtenerPorId(idAutor);
    String nombreAutor = nuevoAutor.getNombre();
    System.out.println("Obra de Arte con ID " + id + " actualizado con éxito.");
    System.out.println();
    System.out.println(obra.toString(nombreAutor));
  }

  @Override
  public void eliminar(Scanner scanner) {
    int id = UtilidadConsola.pedirInt(scanner, "ID de Obra de Arte a eliminar: ");
    boolean removido = listaObras.removeIf(o -> o.getIdObraArte() == id);

    if (removido) {
        System.out.println("Obra de Arte (ID " + id + ") eliminado con éxito.");
    } else {
        System.out.println("Obra de Arte con ID " + id + " no encontrado.");
    }
  }

  public boolean tieneObrasDeAutor(int idAutor) {
    for (ObraArte obra : listaObras) {
      if (obra.getAutorPrincipalId() == idAutor) {
        return true; 
      }
    }
    return false;
  }
}
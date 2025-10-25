  import java.util.Scanner;

public interface ServicioCrud <T>{    
    
  void crear(Scanner scanner);   
  void listarTodos();    
  T obtenerPorId(int id);    
  void actualizar(Scanner scanner);    
  void eliminar(Scanner scanner);
}
  


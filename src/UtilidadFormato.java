public class UtilidadFormato {
  public static String truncar(String texto, int maximo) {
    if (texto == null) {
      return "";
    }
    
    if (maximo < 3) {
      maximo = 3; 
    }

    if (texto.length() > maximo) {
      return texto.substring(0, maximo - 3) + "...";
    }
    
    return texto;
  }
}
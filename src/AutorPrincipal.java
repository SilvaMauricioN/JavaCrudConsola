public class AutorPrincipal extends Persona {    
  private int idAutorPrincipal;
  private String lugarDeFallec;
  private String fechaDeFallec;
  private String nacionalidad;

  public AutorPrincipal(int idAutorPrincipal, String nombre, String lugarDeNacimiento, String fechaDeNacimiento, String lugarDeFallec,  String fechaDeFallec, String nacionalidad) {
    super(nombre,lugarDeNacimiento, fechaDeNacimiento); 
    
    this.idAutorPrincipal = idAutorPrincipal;
    this.lugarDeFallec = lugarDeFallec;
    this.fechaDeFallec = fechaDeFallec;
    this.nacionalidad = nacionalidad;
  }

  // Getters y Setters
  public int getIdAutorPrincipal() { return idAutorPrincipal; }
  public String getLugarDeFallec() { return lugarDeFallec; }
  public String getFechaDeFallec() { return fechaDeFallec; }
  public String getNacionalidad() { return nacionalidad; }

  public void setLugarDeFallec(String lugarDeFallec) { this.lugarDeFallec = lugarDeFallec; }
  public void setFechaDeFallec(String fechaDeFallec) { this.fechaDeFallec = fechaDeFallec; }
  public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

  @Override
  public String getDescripcionBreve() {
    return "Autor ID: " + idAutorPrincipal + ", Nombre: " + getNombre() + ", Nacionalidad: " + nacionalidad;
  }
  
  @Override
  public String toString() {
    String fechaFallec = String.format(fechaDeFallec.isEmpty() ? "No disponible": fechaDeFallec);
    return String.format(
      "%-4s | %-19s | %-19s | %-19s | %-18s| %-18s| %-19s",
      idAutorPrincipal,
      UtilidadFormato.truncar(getNombre(),19),
      UtilidadFormato.truncar(getLugarDeNacimiento(),19),
      UtilidadFormato.truncar(getFechaDeNacimiento(),19),
      UtilidadFormato.truncar(lugarDeFallec, 18),
      UtilidadFormato.truncar(fechaFallec,18 ),
      UtilidadFormato.truncar(nacionalidad,19)      
      );   
  }
}

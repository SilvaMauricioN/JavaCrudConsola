public abstract class Persona {

  private String nombre;
  private String fechaDeNacimiento;
  private String lugarDeNacimiento;

  public Persona(String nombre, String lugarDeNacimiento, String fechaDeNacimiento) {
    this.nombre = nombre;
    this.lugarDeNacimiento = lugarDeNacimiento;
    this.fechaDeNacimiento = fechaDeNacimiento;
  }

  // Getters
  public String getNombre() { return nombre; }
  public String getFechaDeNacimiento() { return fechaDeNacimiento; }
  public String getLugarDeNacimiento() { return lugarDeNacimiento; }

  //Setters
  public void setNombre(String nombre) { this.nombre = nombre; }
  public void setFechaDeNacimiento(String fechaDeNacimiento) { this.fechaDeNacimiento = fechaDeNacimiento; }
  public void setLugarDeNacimiento(String lugarDeNacimiento) { this.lugarDeNacimiento = lugarDeNacimiento; }
  
  public abstract String getDescripcionBreve(); 
}
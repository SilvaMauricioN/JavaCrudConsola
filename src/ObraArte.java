public class ObraArte {
  private int idObraArte;
  private String titulo;
  private int idAutorPrincipal;
  private String materiales;
  private String tecnicas;
  private String medioFisico;

  public ObraArte(int idObraArte, String titulo, int idAutorPrincipal, String materiales, String tecnicas, String medioFisico) {
    this.idObraArte = idObraArte;
    this.titulo = titulo;
    this.idAutorPrincipal = idAutorPrincipal;
    this.materiales = materiales;
    this.tecnicas = tecnicas;
    this.medioFisico = medioFisico;
  }

  // Getters
  public int getIdObraArte() { return idObraArte; }
  public String getTitulo() { return titulo; }
  public int getAutorPrincipalId() { return idAutorPrincipal; }
  public String getMateriales() { return materiales; }
  public String getTecnicas() { return tecnicas; }
  public String getMedioFisico() { return medioFisico; }

  //Setters 
  public void setIdObraArte(int idObraArte){ this.idObraArte = idObraArte;}
  public void setTitulo(String titulo) { this.titulo = titulo; }
  public void setAutorPrincipal(int idAutorPrincipal) { this.idAutorPrincipal = idAutorPrincipal; }
  public void setMateriales(String materiales) { this.materiales = materiales; }
  public void setTecnicas(String tecnicas) { this.tecnicas = tecnicas; }
  public void setMedioFisico(String medioFisico) { this.medioFisico = medioFisico; }


  public String toString(String autorPrincipal) {
    return String.format(
      "%-4s | %-19s | %-19s | %-25s | %-19s | %-19s",
      idObraArte,
      UtilidadFormato.truncar(titulo,19),
      UtilidadFormato.truncar(autorPrincipal,19),
      UtilidadFormato.truncar(materiales,25),
      UtilidadFormato.truncar(tecnicas, 19),
      UtilidadFormato.truncar(medioFisico, 19)
    );
  }
}
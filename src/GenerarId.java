public class GenerarId {
    
  private static int nextAutorId = 1;
  private static int nextObraArteId = 1;

  public int getNextAutorId() {
    return nextAutorId++;
  }

  public int getNextObraArteId() {
    return nextObraArteId++;
  }
}
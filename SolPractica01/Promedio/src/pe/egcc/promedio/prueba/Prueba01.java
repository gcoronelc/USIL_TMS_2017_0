package pe.egcc.promedio.prueba;

import pe.egcc.promedio.service.PromedioService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    
    // Datos
    double p1 = 15, p2 = 15, p3 = 8, p4 = 10;
    double ep = 16, ef = 13;
    
    // Proceso
    PromedioService service = new PromedioService();
    double pp = service.calPromPracticas(p1, p2, p3, p4);
    double pf = service.calPromFinal(pp, ep, ef);
    
    // Reporte
    System.out.println("PP: " + pp);
    System.out.println("PF: " + pf);
    
  }
}

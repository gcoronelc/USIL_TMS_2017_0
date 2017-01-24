package pe.egcc.promedio.service;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class PromedioService {
  
  public double calPromPracticas(double p1, double p2, double p3, double p4){
    double pp;
    pp = ( p1 + p2 + p3 + p4 ) / 4;
    pp = redondear(pp);
    return pp;
  }
  
  public double calPromFinal(double pp, double ep, double ef){
    double pf;
    pf = pp * 0.30 + ep * 0.30 + ef * 0.40; 
    pf = redondear(pf);
    return pf;
  }

  private double redondear(double nota) {
    nota = Math.round(nota * 100);
    nota = nota / 100.0;
    return nota;
  }
  
  
  
}

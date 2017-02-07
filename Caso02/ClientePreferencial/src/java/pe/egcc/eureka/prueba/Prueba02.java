package pe.egcc.eureka.prueba;

import pe.egcc.eureka.model.Empleado;
import pe.egcc.eureka.service.EurekaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    try {
      // Datos
      String usuario = "creyes";
      String clave = "linda";
      // Proceso
      EurekaService service = new EurekaService();
      Empleado bean = service.verificaUsuario(usuario, clave);
      // Reporte
      System.out.println("Hola: " + bean.getNombre());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

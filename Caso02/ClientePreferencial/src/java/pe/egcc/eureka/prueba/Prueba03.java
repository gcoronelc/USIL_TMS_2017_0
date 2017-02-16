package pe.egcc.eureka.prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import pe.egcc.eureka.db.AccesoDB;
import pe.egcc.eureka.model.Empleado;
import pe.egcc.eureka.service.EurekaService;
import pe.egcc.eureka.util.JdbcUtil;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba03 {
  
  public static void main(String[] args) {
    Connection cn = null;
    try {
      // Datos
      String sql = "select * from cliente where chr_cliecodigo='00001'";
      // Proceso
      cn = AccesoDB.getConnection();
      Statement stm = cn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      rs.next();
      Map<String,Object> rec = JdbcUtil.rowToMap(rs);
      rs.close();
      stm.close();
      // Reporte
      for(String key: rec.keySet()){
        System.out.println( key +  ": " + rec.get(key));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}

package pe.egcc.eureka.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import pe.egcc.eureka.db.AccesoDB;
import pe.egcc.eureka.model.Empleado;
import pe.egcc.eureka.util.JdbcUtil;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class EurekaService {

  public Empleado verificaUsuario(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_emplcodigo, vch_emplpaterno, "
              + "vch_emplmaterno, vch_emplnombre, "
              + "vch_emplciudad, vch_empldireccion, "
              + "vch_emplusuario from empleado "
              + "where vch_emplusuario = ?  and vch_emplclave = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        rs.close();
        pstm.close();
        throw new Exception("Datos incorrectos");
      }
      bean = new Empleado();
      bean.setCodigo(rs.getString("chr_emplcodigo"));
      bean.setPaterno(rs.getString("vch_emplpaterno"));
      bean.setMaterno(rs.getString("vch_emplmaterno"));
      bean.setNombre(rs.getString("vch_emplnombre"));
      bean.setCiudad(rs.getString("vch_emplciudad"));
      bean.setDireccion(rs.getString("vch_empldireccion"));
      bean.setUsuario(rs.getString("vch_emplusuario"));
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        if (cn != null) {
          cn.close();
        }
      } catch (Exception e) {
      }
    }
    return bean;
  }
  
  public Map<String,Object> consultaCuenta(String cuenta){
    Connection cn = null;
    Map<String,Object> rec = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select sucucodigo, sucunombre, cliecodigo,"
              + "cliepaterno, cliematerno, clienombre,"
              + "cuencodigo, cuensaldo, cuenestado,"
              + "monecodigo, monenombre "
              + "from v_cuenta "
              + "where cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        rec = JdbcUtil.rowToMap(rs);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return rec;
  }

  public List<Map<String,?>> consultaMovimientos(String cuenta){
    Connection cn = null;
    List<Map<String,?>> lista = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select sucucodigo, sucunombre, cliecodigo, "
              + "cliepaterno, cliematerno, clienombre, "
              + "cuencodigo, cuensaldo, cuenestado, "
              + "movinumero, movifecha, moviimporte, cuenreferencia, "
              + "tipocodigo, tiponombre, tipoaccion, "
              + "monecodigo, monenombre "
              + "from v_movimiento "
              + "where cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      lista = JdbcUtil.rsToList(rs);
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }
  
  
}

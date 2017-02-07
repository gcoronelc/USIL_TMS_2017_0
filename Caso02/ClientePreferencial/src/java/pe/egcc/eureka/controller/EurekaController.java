package pe.egcc.eureka.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.egcc.eureka.model.Empleado;
import pe.egcc.eureka.service.EurekaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "EurekaController", urlPatterns = {"/EurekaLogin"})
public class EurekaController extends HttpServlet {

  private EurekaService service;

  @Override
  public void init() throws ServletException {
    service = new EurekaService();
  }  
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    switch(path){
      case "/EurekaLogin":
        login(request,response);
        break;
      case "/EurekaConsulta":
        consulta(request,response);
        break;
      case "/EurekaExit":
        salir(request,response);
        break;
    }
  }

  private void salir(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void consulta(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String destino;
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      Empleado bean = service.verificaUsuario(usuario, clave);
      HttpSession session = request.getSession(true);
      session.setAttribute("usuario", bean);
      destino = "main.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

  
}

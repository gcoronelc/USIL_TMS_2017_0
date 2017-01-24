package pe.egcc.promedio.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.promedio.service.PromedioService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "PromedioController", urlPatterns = {"/PromedioController"})
public class PromedioController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Datos
    double p1 = Double.parseDouble(request.getParameter("p1"));
    double p2 = Double.parseDouble(request.getParameter("p2"));
    double p3 = Double.parseDouble(request.getParameter("p3"));
    double p4 = Double.parseDouble(request.getParameter("p4"));
    double ep = Double.parseDouble(request.getParameter("ep"));
    double ef = Double.parseDouble(request.getParameter("ef"));
    // Proceso
    PromedioService service = new PromedioService();
    double pp = service.calPromPracticas(p1, p2, p3, p4);
    double pf = service.calPromFinal(pp, ep, ef);
    // Reporte
    request.setAttribute("p1", p1);
    request.setAttribute("p2", p2);
    request.setAttribute("p3", p3);
    request.setAttribute("p4", p4);
    request.setAttribute("ep", ep);
    request.setAttribute("ef", ef);
    request.setAttribute("pp", pp);
    request.setAttribute("pf", pf);
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
  }

  
  
}

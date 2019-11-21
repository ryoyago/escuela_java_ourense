/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
@WebServlet(name = "ParamServlet", urlPatterns = {"/formulario"})
public class ParamServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest peticionHTTP, HttpServletResponse respuestaHTTP)
            throws ServletException, IOException {
       
        respuestaHTTP.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = respuestaHTTP.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet form y Param</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + peticionHTTP.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            //Campos a nviar: noombre e email obligatorios y  con su validacion html5
           out.println("<form name='formDatos' action='./formulario'  method='POST'>");
            out.println("<label> Nombre: </label>");
            out.println("<input id='nombre' name='nombre' required='required'/>");
            out.println("</br></br><label for='email'> Email: </label>");
            out.println("<input  name='email' type='email' id='email' required='required'/>");
             out.println("</br></br> <input type='submit' value='Enviar datos'/>");
             out.println("</form>");
            
            
            
//            out.println("<form name='formDatos' action='./formulario' >");
//            out.println("<label>Campo: </label>");
//            out.println("<input id='nombre_campo' name='nombre_campo'/>");
//            out.println("<input type='submit' value='Envia parametros '/>");
//            
//            out.println("</form>");
//            String valorCampo= peticionHTTP.getParameter("nombre_campo");
//            if ("".equals(valorCampo) || valorCampo== null) {
//                out.println("<p style='color:red' > No se ha recibido el parametro </p>");
//            }else{
//                out.println("<p style='color:green' > Nombre campo: "+ valorCampo+" </p>");
//            }
            out.println("</body>");
            out.println("</html>");
        }
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest peticionHTTP, HttpServletResponse respuestaHTTP)
            throws ServletException, IOException {
        
        respuestaHTTP.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = respuestaHTTP.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet form y Param</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParamServlet at " + peticionHTTP.getContextPath() + "</h1>");
            out.println("<h2>Formulario de registro</h2>");
            //Campos a recibir: noombre e email obligatorios y  con su validacion html5  
             String valorNombre= peticionHTTP.getParameter("nombre");
             String valorEmail= peticionHTTP.getParameter("email");
             if ("".equals(valorNombre) || valorNombre==null || "".equals(valorEmail) || valorEmail==null) {
                 out.println("<p  > No se aceptan <span style='color:red; font-weight:bold; font-size: 2em'>comunistas!!!</span> </p>");
            } else{
                  out.println("<p style='color:green' > Bienvenido a la hermandad: " + valorNombre+" </p>");
             }
            
             //Vamos a insertar los datos recibidos
             //jdbc:derby://localhost:1527/db_prueba
             
             try{
                 Class.forName("org.apache.derby.jdbc.ClientDriver");
                 DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
             } catch (Exception ex) {
                Logger.getLogger(ParamServlet.class.getName()).log(Level.SEVERE, null, ex);
                 out.println("<p  > No se aceptan <span style='color:red; font-weight:bold; font-size: 2em'>errores!!!</span> </p>");
            }
             try (Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/db_prueba","root","1234")){
                    String sqlQuery="INSERT INTO persona (nombre, email) VALUES ('" + valorNombre + "','" + valorEmail + "')";
                 Statement sentenciaSQL= con.createStatement();
                 sentenciaSQL.executeUpdate(sqlQuery);
             } catch (SQLException ex) {
                Logger.getLogger(ParamServlet.class.getName()).log(Level.SEVERE, null, ex);
                 out.println("<p  > No se aceptan <span style='color:red; font-weight:bold; font-size: 2em'>"+ ex.getMessage()+"</span> </p>");
                
              
            }    
             
            out.println("</body>");
            out.println("</html>");
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet que envia formulario y recibe los parametros";
    }// </editor-fold>

}

package com.vn.appusuarios.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vn.appusuarios.modelo.Usuario;
import com.vn.appusuarios.modelo.logica.ServiciosUsuarios;

/** Sólo hay una instancia por aplicación, que se ejecuta en su propio hilo
 * Todos los ususarios comparten el mismo servlet/JSP o derivados
 *
 * @author pc
 */
public class UsuariosServlet extends HttpServlet {
	
	private ServiciosUsuarios srvUsu;

    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.srvUsu = new ServiciosUsuarios();
	}

	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        
        // En el objeto petición le pasamos nuestro (este servlet) servicio de Usuarios.
        request.setAttribute("servicioUsu", this.srvUsu);

        srvUsu.setChivato((String mensaje) -> {
            request.getSession().setAttribute("mensajeError", "Error al crear: " + mensaje);
        });
        // Comprobamos que la peticion es POST.
        if (request.getMethod() == "POST") {
            // Creamos el usuario.
            Usuario usuario = srvUsu.crear(email, password, nombre, edad);
            // Si usuario tiene id y no es null.
            if (usuario != null && usuario.getId() >= 0) {
                // Redirigir a la vista que muestra el usuario registrado.
                request.getSession().setAttribute("usuario",usuario);
                request.getRequestDispatcher("registrado.jsp")
                        .forward(request, response);
            } else {
                // Redirigir la peticion a la propia vista.
               request.getRequestDispatcher("registrarse.jsp")
                        .forward(request, response); 
            }
        }else if(request.getMethod() == "GET") {
        	Usuario usuario = srvUsu.leerUno(email);
        	// Habría que comprobar la password.
        	request.getSession().setAttribute("usuario", usuario);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

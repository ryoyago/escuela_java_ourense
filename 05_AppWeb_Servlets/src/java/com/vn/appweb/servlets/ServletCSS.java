package com.vn.appweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
public class ServletCSS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest peticionHttp, HttpServletResponse respuestaHttp) throws IOException {

        //Definimos el tipo de contenido segun los tipos MIME
        //Formatos conocidos de ficheros para emails
        respuestaHttp.setContentType("text/css");

        try (PrintWriter salida = respuestaHttp.getWriter()) {

            salida.print(".color-rojo{color:red; }");
            for (int i = 0; i < 10; i++) {
                salida.print(".tam" + i +"{font-size:"+  i * 5+ " }");
            }
            
            //salida.close();
        }
    }
 
}

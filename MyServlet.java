import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String  accion = request.getParameter("cambiar");
        
        //localhost:8081/primerServlet/jsp/login.jsp?cambiar=home
        if(accion.equals("login")){
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
        else if(accion.equals("inicio")){ 
            getServletContext().getRequestDispatcher("/jsp/JSPhome.jsp").forward(request, response);
        }
        
        String ini = request.getParameter("ini");
        if(ini.equals("iniciarSesion")){
        getServletContext().getRequestDispatcher("/jsp/principal.jsp").forward(request, response);
        }
        
               
    }

 
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);String accion = request.getParameter("accion");
		 String ini = request.getParameter("ini");
		if (ini != null) {
			
			if (ini.equals("iniciarSesion")) {
				
				System.out.println( 
						"Usuario: " + request.getParameter("usuario") +
						", Contraseña: " + request.getParameter("contrasena")
						);
                                getServletContext().getRequestDispatcher("/jsp/principal.jsp").forward(request, response);
			}
			
			
		}
		else {
			getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		}
	
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

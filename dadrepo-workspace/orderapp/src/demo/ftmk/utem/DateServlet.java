package demo.ftmk.utem;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 * Servlet implementation class DateServlet
 */
public class DateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DateServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
    ServletException, IOException {
    	
    
    	//Get link parameter
    	int paramValue=Integer.parseInt(request.getParameter("param"));
    	
		//Get writer
		PrintWriter writer = response.getWriter();
		
		//Get current date
		LocalDate now = LocalDate.now();
		
		if(paramValue == 0) {
		//Display current date
		writer.println("Today date is "+now.toString());
		}
		
		else if(paramValue == 1) {
		//Display Tommorow date
		LocalDate tomorrow = now.plusDays(1);
		writer.println("Tomorrow date is "+tomorrow.toString());
		}
		
		else if(paramValue == -1) {
		//Display Yesterday date
		LocalDate yesterday = now.minusDays(1);
		writer.println("Yesterday date is "+yesterday.toString());
		}
		
	}
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		doGet(request, response);
    		
    	}
  }


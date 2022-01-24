package demo.ftmk.utem;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import demo.ftmk.order.Order;
import demo.ftmk.order.OrderDataManager;
import demo.ftmk.order.OrderedProduct;

/**
 * Servlet implementation class CheckOutRedirectServlet
 */
public class CheckOutRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CheckOutRedirectServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get orderedProducts from session
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<OrderedProduct> orderedProducts = (List<OrderedProduct>)
		session.getAttribute("orderedProducts");
		
		// Forward servlet to zeroOrder.html if orderedProducts does not exist
		RequestDispatcher dsp;
		if (orderedProducts == null) {
			System.out.println("No Order");
			dsp = request.getRequestDispatcher("zeroOrder.html");
			dsp.forward(request, response);
		}
		
		else {
			
		// Calculate total quantity and total order
		// Invoke the appropriate method from OrderDataManager
		OrderDataManager ordDataMngr = new OrderDataManager();
		Order ord = ordDataMngr.processOrder(orderedProducts);
		
		// Display details of order
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<strong>Order Number : </strong>" +
		ord.getOrderId() + "<br><br>");
		writer.println("<strong>List of Ordered Products</strong><br><br><br>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<th>Product</th>");
		writer.println("<th>Quantity</th>");
		writer.println("<th>Price per Unit (RM)</th>");
		writer.println("</tr>"); 
		
		List<OrderedProduct> items = ord.getOrderedProducts();
		
		for (OrderedProduct item: items) {
		writer.println("<tr>");
		writer.println("<td>" + item.getProduct().getName() +
		"</td>");
		writer.println("<td>" + item.getQuantity() + "</td>");
		writer.println("<td>" + item.getProduct().getPrice() +
		"</td>");
		writer.println("</tr>");
		
		}
		
		writer.println("</table>");
		writer.println("<br><br>Total Quantity : " +
		ord.getTotalQuantity());
		writer.println("<br>Service Tax : RM " + String.format("%.2f", ord.getServiceTax()));
		writer.println("<br>Total Amount : RM " + String.format("%.2f", ord.getTotalAmount()));
		writer.println("<br><br>This order is made on " + ord.getOrderDate());
		writer.println("<br><br><a href=\"..\\index.jsp\">Home</a>");
		writer.println("</html>");
		
		// Remove attribute from session
		session.removeAttribute("orderedProducts");

		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

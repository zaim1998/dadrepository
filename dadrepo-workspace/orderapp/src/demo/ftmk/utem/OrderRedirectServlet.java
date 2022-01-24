package demo.ftmk.utem;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import demo.ftmk.order.OrderedProduct;
import demo.ftmk.product.Product;

/**
 * Servlet implementation class OrderRedirectServlet
 */
public class OrderRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OrderRedirectServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
			// Get orderedProducts from session and cast to List of OrderedProduct
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<OrderedProduct> orderedProducts = (List<OrderedProduct>)
			session.getAttribute("orderedProducts");

			// Validate list - instantiate new list if list is null
			if (orderedProducts == null) {
				orderedProducts = new ArrayList<OrderedProduct>();
				
			}

			// Get data from web form
			String selectedProduct = request.getParameter("product");
			String specifiedQuantity = request.getParameter("quantity");
			
			int productId = Integer.parseInt(selectedProduct);
			int quantity = Integer.parseInt(specifiedQuantity);

			// Wrap data into object of OrderedProduct
			Product prod = new Product();
			prod.setProductId(productId);

			OrderedProduct orderedProd = new OrderedProduct();
			orderedProd.setOrderedProduct(prod);
			orderedProd.setQuantity(quantity);
			
			// Add object of OrderedProduct into list
			orderedProducts.add(orderedProd);

			// Add list to session
			session.setAttribute("orderedProducts", orderedProducts);
			
			// Redirect to the same page
			response.sendRedirect("orderRedirectForm.html");
	}

}

package transactional.context.ejb.sample.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import transactional.context.ejb.sample.persistence.ProductDao;

@WebServlet(name = "ListServlet", urlPatterns = { "/list" })
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = -819537778164030090L;
	
	public static final String LIST_PATH = "/sample/list";

	@EJB
	private ProductDao customerDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Display the list of guests:
		request.setAttribute("productList", customerDao.getAllProducts());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
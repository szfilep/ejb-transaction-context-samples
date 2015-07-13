package transactional.context.ejb.sample.servlet;

import static transactional.context.ejb.sample.servlet.ListServlet.LIST_PATH;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import transactional.context.ejb.sample.persistence.Product;
import transactional.context.ejb.sample.persistence.ProductDao;

@WebServlet(name = "Case08Servlet", urlPatterns = { "/case8" })
public class Case08Servlet extends HttpServlet {

	private static final long serialVersionUID = -819537778164030090L;

	@EJB
	private ProductDao customerDao;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String productName1 = request.getParameter("productName1");
		final String productName2 = request.getParameter("productName2");

		if (StringUtils.isNotBlank(productName1) && StringUtils.isNotBlank(productName2)) {
			final Product p1 = new Product(productName1);
			final Product p2 = new Product(productName2);
			try {
				customerDao.case8(p1, p2);
			} catch (Exception e) {
			}
		}

		response.sendRedirect(LIST_PATH);
	}
}
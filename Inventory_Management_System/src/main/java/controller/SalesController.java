package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Sales;
import java.io.IOException;
import java.io.PrintWriter;
import dao.SalesDao;

/**
 * Servlet implementation class Sales
 */
public class SalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalesDao salesdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesController() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		salesdao = new SalesDao();
		PrintWriter out = response.getWriter();
		String sl_ProductName = request.getParameter("sl_ProductName");
        int sl_ProductQTY = Integer.parseInt(request.getParameter("sl_ProductQTY"));
		float sl_Price = Float.parseFloat(request.getParameter("sl_Price"));
		String s_Date = request.getParameter("s_Date");
	
	Sales sales = new Sales(sl_ProductName,sl_ProductQTY,sl_Price,s_Date);
	try {
	int insert= salesdao.registerCustomerPreparedStatement(sales);
	if(insert==1) {
		RequestDispatcher rd=request.getRequestDispatcher("/view/Sales.jsp");
		rd.forward(request, response);
	}else {
		out.print("Error inserting");
	}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
}
	}



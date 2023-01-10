package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Supplier;

import java.io.IOException;
import java.io.PrintWriter;

import dao.Supplierdao;

/**
 * Servlet implementation class SupplierController
 */
public class SupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Supplierdao supplierdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierController() {
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
		supplierdao = new Supplierdao();
		PrintWriter out = response.getWriter();
		String s_Name = request.getParameter("supplierName");
		String s_Address = request.getParameter("supplierAddress");
		String s_Phone = request.getParameter("supplierPhone");
	
	
	Supplier supplier = new Supplier(s_Name,s_Phone, s_Address );
	try {
	int insert= supplierdao.registerCustomerPreparedStatement(supplier);
	if(insert==1) {
		RequestDispatcher rd=request.getRequestDispatcher("/view/Supplier.jsp");
		rd.forward(request, response);
	}else {
		out.print("Error inserting");
	}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
}
	}

package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Orders;
import java.io.IOException;
import dao.OrdersDao;
import database.DbConnection;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class OrdersController
 */
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection db;
    private OrdersDao ordersdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
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
		ordersdao = new OrdersDao();
		PrintWriter out = response.getWriter();
        int o_ProductQTY = Integer.parseInt(request.getParameter("o_ProductQTY"));
        int c_ID = Integer.parseInt(request.getParameter("c_ID"));
        String o_Date = request.getParameter("o_Date");
		String o_ProductName = request.getParameter("o_ProductName");
		
		boolean isOrders = orders(o_ProductName,c_ID);
		HttpSession session = request.getSession();
		
		if(isOrders) {		
			session.setAttribute("o_ProductName",o_ProductName);
			List<Orders> lstOrders = getAllOrders();
			
			if(lstOrders.size()>0) {
				request.setAttribute("lstOrders", lstOrders);
			}else {
				request.setAttribute("lstOrders", null);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/Orders.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("status", "failed");
			// Call the same page and display error message
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request, response);
		}
	}
	
	private List<Orders> getAllOrders(){
		OrdersDao ordersdao = new OrdersDao();
		List<Orders> lstOrders = ordersdao.getAllOrders();
		return lstOrders;
	}

	
	
	private boolean orders(String o_ProductName, int c_ID) {
		boolean flag = false;
		db= new DbConnection();
		String query = "select * from orders where o_ProductName=? and c_ID=?;";
		try {
			PreparedStatement st = db.con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			st.setString(1, o_ProductName);
			st.setInt(2, c_ID);
			
			ResultSet rows = db.retrieve(st);
			rows.last();
			int rs = rows.getRow();
			if(rs>0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
	

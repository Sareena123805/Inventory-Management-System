package controller;



import jakarta.servlet.RequestDispatcher;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Orders;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import dao.OrdersDao;
import database.DbConnection;;


public class ViewOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection db;
       
   
    public ViewOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		String username = request.getParameter("loginUser");
		String password = request.getParameter("loginPassword");
		
		boolean isLogin = login(username,password);
		HttpSession session = request.getSession();
		
		if(isLogin) {		
			session.setAttribute("username",username);
			List<Orders> lstOrders = getAllOrders();
			
			if(lstOrders.size()>0) {
				request.setAttribute("lstOrders", lstOrders);
			}else {
				request.setAttribute("lstOrders", null);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/ViewOrders.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("status", "failed");
			// Call the same page and display error message
			RequestDispatcher rd = request.getRequestDispatcher("/view/OrderLogin.jsp");
			rd.forward(request, response);
		}
	}
	
	private List<Orders> getAllOrders(){
		OrdersDao customerdao = new OrdersDao();
		List<Orders> lstOrders = customerdao.getAllOrders();
		return lstOrders;	
	}

	private boolean login(String username,String password)   {
		boolean flag = false;
		db= new DbConnection();
		String query = "select * from customer where c_UserName=? and c_Password=?;";
		try {
			PreparedStatement st = db.con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			st.setString(1, username);
			st.setString(2, password);
			
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


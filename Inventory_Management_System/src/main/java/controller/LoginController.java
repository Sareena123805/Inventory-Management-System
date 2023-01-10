package controller;



import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import dao.Customerdao;
import database.DbConnection;;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection db;
       
   
    public LoginController() {
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
			List<Customer> lstCustomer = getAllCustomer();
			
			if(lstCustomer.size()>0) {
				request.setAttribute("lstCustomer", lstCustomer);
			}else {
				request.setAttribute("lstCustomer", null);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/Dashboard.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("status", "failed");
			// Call the same page and display error message
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request, response);
		}
	}
	
	private List<Customer> getAllCustomer(){
		Customerdao customerdao = new Customerdao();
		List<Customer> lstCustomer = customerdao.getAllCustomers();
		return lstCustomer;	
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


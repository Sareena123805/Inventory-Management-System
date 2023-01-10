package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.OrdersDao;
import dao.SalesDao;
import database.DbConnection;
import model.Customer;
import model.Orders;
import model.Sales;

import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 * Servlet implementation class ViewSalesController
 */
public class ViewSalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection db;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSalesController() {
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
		String username = request.getParameter("loginUser");
		String password = request.getParameter("loginPassword");
		
		boolean isLogin = login(username,password);
		HttpSession session = request.getSession();
		
		if(isLogin) {		
			session.setAttribute("username",username);
			List<Sales> lstSales = getAllSales();
			
			if(lstSales.size()>0) {
				request.setAttribute("lstSales", lstSales);
			}else {
				request.setAttribute("lstSales", null);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/ViewSales.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("status", "failed");
			// Call the same page and display error message
			RequestDispatcher rd = request.getRequestDispatcher("/view/SalesLogin.jsp");
			rd.forward(request, response);
		}
	}
	
	private List<Sales> getAllSales(){
		SalesDao customerdao = new SalesDao();
		List<Sales> lstSales = customerdao.getAllSales();
		return lstSales;	
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


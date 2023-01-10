package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import model.Customer;
import model.Stock;
import java.sql.*;
import java.util.List;

import dao.Stockdao;
import database.DbConnection;
/**
 * Servlet implementation class ViewStockController
 */
public class ViewStockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DbConnection db;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStockController() {
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
			List<Stock> lstStock = getAllStock();
			
			if(lstStock.size()>0) {
				request.setAttribute("lstStock", lstStock);
			}else {
				request.setAttribute("lstStock", null);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/ViewStock.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("status", "failed");
			// Call the same page and display error message
			RequestDispatcher rd = request.getRequestDispatcher("/view/StockLogin.jsp");
			rd.forward(request, response);
		}
	}
	
	private List<Stock> getAllStock(){
		Stockdao customerdao = new Stockdao();
		List<Stock> lstStock = customerdao.getAllStock();
		return lstStock;	
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



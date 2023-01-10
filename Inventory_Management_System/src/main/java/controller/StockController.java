package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import dao.Stockdao;
import database.DbConnection;

/**
 * Servlet implementation class StockController
 */
public class StockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection db;
	private Stockdao stockdao;

    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockController() {
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
		stockdao = new Stockdao();
		PrintWriter out = response.getWriter();
        int s_ProductQTY = Integer.parseInt(request.getParameter("s_ProductQTY"));
		float s_Price = Float.parseFloat(request.getParameter("s_Price"));
	    int s_ID = Integer.parseInt(request.getParameter("s_ID"));
		String s_ProductName = request.getParameter("s_ProductName");
	
		boolean isStock = stock(s_ProductQTY,s_ID);
		HttpSession session = request.getSession();
		
		if(isStock) {
			session.setAttribute("s_ProductQTY", s_ProductQTY);
			List<Stock> lstStock = getAllStock();
			
			if(lstStock.size()>0) {
				request.setAttribute("lstStock", lstStock);
			}else {
				request.setAttribute("lstStock", null);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/Stock.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("status", "failed");
			// Call the same page and display error message
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request, response);
			
			
		}
	}
		

	private boolean stock(int s_ProductQTY, int s_ID) {
		boolean flag = false;
		db= new DbConnection();
		String query = "select * from stock where s_ProductQTY=? and s_ID=?;";
		try {
			PreparedStatement st = db.con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			st.setInt(1, s_ProductQTY);
			st.setFloat(2, s_ID);
			
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

	private List<Stock> getAllStock(){
		Stockdao stockdao = new Stockdao();
		List<Stock> lstStock = stockdao.getAllStock();
		return lstStock;
	}
	}



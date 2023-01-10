package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DbConnection;
import model.Customer;
import model.Orders;

public class OrdersDao {
DbConnection db = new DbConnection();

public int registerCustomerPreparedStatement(Orders orders) {
	try {
		String query = "insert into orders(o_ProductQTY,c_ID, o_Date, o_ProductName) values(?,?,?,?)";
					PreparedStatement st = db.con.prepareStatement(query);
					
					st.setInt(1, orders.getO_ProductQTY());
					st.setInt(2, orders.getC_ID());
					st.setString(3, orders.getO_Date());
					st.setString(4, orders.getO_ProductName());
		
		return db.manipulate(st);
		
		
	}catch(SQLException e) {
		e.printStackTrace();
		return 0;
	}
}

public Customer loginCustomer (String username, String password) {
	String query;
	query= "select * from customer where username=' "+username +"' and password='" +password +"';";
	ResultSet rs = db.retrieve(query);
	Customer customer= null;
	
	try {
		while(rs.next()) {
			customer = new Customer();
			customer.setC_ID(rs.getInt("c_ID"));
			customer.setC_Fname(rs.getString("c_Fname"));
			customer.setC_Lname(rs.getString("c_Lname"));
			customer.setC_Address(rs.getString("c_Address"));
			customer.setC_UserName(rs.getString("c_UserName"));
			}
	
	}catch(Exception ex) {
		System.out.println("Error"+ ex);
	}
	
	return customer;
	
}

public List<Orders> getAllOrders() {
	String query;
	query = "select * from orders";
	db = new DbConnection();
	ResultSet rs = db.retrieve(query);
	List<Orders>lstOrders = new ArrayList<Orders>();
	
	try {
		while(rs.next()) {
			Orders orders = new Orders();
			orders.setO_ID(rs.getInt("o_ID"));
			orders.setO_ProductQTY(rs.getInt("o_ProductQTY"));
			orders.setC_ID(rs.getInt("c_ID"));
			orders.setO_Date(rs.getString("o_Date"));;
			orders.setO_ProductName(rs.getString("o_ProductName"));
			
			
			lstOrders.add(orders);
		}
	}catch(Exception ex) {
		System.out.print("Error" + ex);
	}
	return lstOrders;
}
}

package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DbConnection;
import model.Customer;
import model.Sales;

public class SalesDao {
DbConnection db = new DbConnection();

public int registerCustomerPreparedStatement(Sales sales) {
	try {
		String query = "insert into sales(sl_ProductName,sl_ProductQTY,sl_Price, s_Date) values(?,?,?,?)";
					PreparedStatement st = db.con.prepareStatement(query);
					
					st.setString(1, sales.getSl_ProductName());
					st.setInt(2, sales.getSl_ProductQTY());
					st.setFloat(3, sales.getSl_Price());
					st.setString(4, sales.getS_Date());
		
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
public List<Sales> getAllSales() {
	String query;
	query = "select * from sales";
	db = new DbConnection();
	ResultSet rs = db.retrieve(query);
	List<Sales>lstSales = new ArrayList<Sales>();
	
	try {
		while(rs.next()) {
			Sales sales = new Sales();
			sales.setSl_ID(rs.getInt("sl_ID"));
			sales.setSl_ProductName(rs.getString("sl_ProductName"));
			sales.setSl_ProductQTY(rs.getInt("sl_ProductQTY"));
			sales.setSl_Price(rs.getFloat("sl_Price"));;
			sales.setS_Date(rs.getString("s_Date"));
			
			
			lstSales.add(sales);
		}
	}catch(Exception ex) {
		System.out.print("Error" + ex);
	}
	return lstSales;
}
}

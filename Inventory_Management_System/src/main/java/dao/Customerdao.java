package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DbConnection;
import model.Customer;

public class Customerdao {
DbConnection db = new DbConnection();

public int registerCustomerPreparedStatement(Customer customer) {
	try {
		String query = "insert into customer(c_Fname, c_Lname,c_Phone," + 
				"c_Address,c_UserName,c_Password) values(?,?,?,?,?,?)";
					PreparedStatement st = db.con.prepareStatement(query);
					
					st.setString(1, customer.getC_Fname());
					st.setString(2, customer.getC_Lname());
					st.setString(3, customer.getC_Phone());
					st.setString(4, customer.getC_Address());
					st.setString(5, customer.getC_UserName());
					st.setString(6, customer.getC_Password());
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

public List<Customer> getAllCustomers() {
	String query;
	query = "select * from customer";
	db = new DbConnection();
	ResultSet rs = db.retrieve(query);
	List<Customer>lstCustomer = new ArrayList<Customer>();
	
	try {
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setC_ID(rs.getInt("c_ID"));
			customer.setC_Fname(rs.getString("c_Fname"));
			customer.setC_Lname(rs.getString("c_Lname"));
			customer.setC_Address(rs.getString("c_Address"));
			customer.setC_UserName(rs.getString("c_UserName"));
			
			lstCustomer.add(customer);
		}
	}catch(Exception ex) {
		System.out.print("Error" + ex);
	}
	return lstCustomer;
}
}

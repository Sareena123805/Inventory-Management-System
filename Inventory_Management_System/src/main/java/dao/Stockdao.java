package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DbConnection;
import model.Customer;
import model.Stock;
public class Stockdao {
DbConnection db = new DbConnection();

public int registerCustomerPreparedStatement( Stock stock) {
	try {
		String query = "insert into stock(s_ProductQTY, s_Price, s_ID, s_ProductName) values(?,?,?,?)";
		
		PreparedStatement st = db.con.prepareStatement(query);
	
		st.setInt(1, stock.getS_ProductQTY());
		st.setFloat(2, stock.getS_Price());
		st.setInt(3, stock.getS_ID());
		st.setString(4, stock.getS_ProductName());
	

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

public List<Stock> getAllStock() {
	String query;
	query = "select * from stock";
	db = new DbConnection();
	ResultSet rs = db.retrieve(query);
	List<Stock>lstStock = new ArrayList<Stock>();
	
	try {
		while(rs.next()) {
			Stock stock = new Stock();
			stock.setS_ProductID(rs.getInt("s_ProductID"));
			stock.setS_ProductQTY(rs.getInt("s_ProductQTY"));
			stock.setS_Price(rs.getFloat("s_Price"));
			stock.setS_ID(rs.getInt("s_ID"));
			stock.setS_ProductName(rs.getString("s_ProductName"));
			
			
			
			lstStock.add(stock);
		}
	}catch(Exception ex) {
		System.out.print("Error" + ex);
	}
	return lstStock;
}
}

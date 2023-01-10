package database;

import java.sql.*;

public class DbConnection {

    public Connection con;
    Statement st;
    ResultSet rows;
    int val;

    public DbConnection() {
        //register the driver class
        try {
            String username= "root";
            String password = "12345";
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create the connection object
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dealership?characterEncoding=utf8&useSSL=false&autoReconnect=true", username,password);
            if (con != null) {
                System.out.println("Connected to Dealership Database");
            }else{
                System.out.println("Error connecting Database");
            }

            //creating statement object
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Prepared Statement
    public int manipulate(PreparedStatement ps) {
        try {
            val = ps.executeUpdate();
             // con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    // Simple query
    public int manipulate(String query) {
      
        try {
            val = st.executeUpdate(query);
             // con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return val;
    }

    // For select query
    public ResultSet retrieve(String query) {
        try {
            rows = st.executeQuery(query);
            // con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
    
    // Select query using prepared statement
    public ResultSet retrieve(PreparedStatement preparedStatement) {
        try {
            rows = preparedStatement.executeQuery();
            // con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    
    public static void main(String[] args) {
        new DbConnection();
    }
}

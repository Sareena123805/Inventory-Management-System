package model;

public class Customer {

	    private int c_ID;
	    private String c_Fname;
	    private String c_Lname;
	    private String c_Phone;
	    private String c_Address;
	    private String c_UserName;
	    private String c_Password;
	    
	    

	    public Customer(String c_Fname,String c_Lname ,String c_Phone,String c_Address,String c_UserName,String c_Password){
	        this.c_Fname = c_Fname;
	        this.c_Lname = c_Lname;
	        this.c_Phone = c_Phone;
	        this.c_Address = c_Address;
	        this.c_UserName = c_UserName;
	        this.c_Password = c_Password;
	    }

	    public Customer(int c_ID,String c_Fname,String c_Lname ,String c_Phone,String c_Address,String c_UserName,String c_Password){
	    	 this.c_Fname = c_Fname;
		        this.c_Lname = c_Lname;
		        this.c_Phone = c_Phone;
		        this.c_Address = c_Address;
		        this.c_UserName = c_UserName;
		        this.c_Password = c_Password;
	    }
	    public Customer(String username2, String password2) {
			// TODO Auto-generated constructor stub
		}
	    
	    public Customer() {
			// TODO Auto-generated constructor stub
		}

		public int getC_ID() {
	        return c_ID;
	    }

	   
	    public void setC_ID(int c_ID) {
	        this.c_ID = c_ID;
	    }

	   
	    public String getC_Fname() {
	        return c_Fname;
	    }

	   
	    public void setC_Fname(String c_Fname) {
	        this.c_Fname = c_Fname;
	    }

	   
	    public String getC_Lname() {
	        return c_Lname;
	    }

	    public void setC_Lname(String c_Lname) {
	        this.c_Lname = c_Lname;
	    }

	    public String getC_Phone() {
	        return c_Phone;
	    }

	    public void setC_Phone(String c_Phone) {
	        this.c_Phone = c_Phone;
	    }

	  
	    public String getC_Address() {
	        return c_Address;
	    }

	   
	    public void setC_Address(String c_Address) {
	        this.c_Address = c_Address;
	    }

	    
	        public String getC_UserName() {
	            return c_UserName;
	    }

	    
	    public void setC_UserName(String c_UserName) {
	            this.c_UserName = c_UserName;
	     }

	  
	    public String getC_Password() {
	        return c_Password;
	    }

	     public void setC_Password(String c_Password) {
	        this.c_Password = c_Password;
	    }
	    

	
}



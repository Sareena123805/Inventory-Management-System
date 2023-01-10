package model;

public class Supplier {
	
	 	private int s_Id;
	    private String s_Name;
	    private String s_Phone;
	    private String s_Address;
	    
	    
	    public Supplier() {
			// TODO Auto-generated constructor stub
		}
	    
	    public Supplier(String supplierName,String supplierPhone ,String supplierAddress){
	        this.s_Name = supplierName;
	        this.s_Phone = supplierPhone;
	        this.s_Address = supplierAddress;
	    }

	    public Supplier(int supplierID, String supplierName,String supplierPhone ,String supplierAddress){
	    	this.s_Id=supplierID;
	    	this.s_Name = supplierName;
	        this.s_Phone = supplierPhone;
	        this.s_Address = supplierAddress;
	    }

		public int getS_Id() {
	        return s_Id;
	    }

	   
	    public void setS_Id(int supplierID) {
	        this.s_Id = supplierID;
	    }

	   
	    public String getS_Name() {
	        return s_Name;
	    }

	   
	    public void setS_Name(String SupplierName) {
	        this.s_Name = SupplierName;
	    }

	    public String getS_Phone() {
	        return s_Phone;
	    }

	    public void setS_Phone(String supplierPhone) {
	        this.s_Phone = supplierPhone;
	    }

	  
	    public String getS_Address() {
	        return s_Address;
	    }

	   
	    public void setS_Address(String supplierAddress) {
	        this.s_Address = supplierAddress;
	    }

		public void setS_ID(int int1) {
			// TODO Auto-generated method stub
			
		}

	    

	  

		

}


package model;

public class Orders {
	
	 	private int o_ID;
	 	private int o_ProductQTY;
	    private int c_ID;
	    private String o_Date;
	    private String o_ProductName;
	    
	    
	    
	    public Orders() {
			// TODO Auto-generated constructor stub
		}
	    
	    public Orders(int o_ProductQTY, int c_ID, String o_Date, String o_ProductName){
	        this.o_ProductQTY=o_ProductQTY;
	        this.c_ID=c_ID;
	        this.o_Date=o_Date;
	        this.o_ProductName=o_ProductName;
	    }

	    public Orders(int o_ID, int o_ProductQTY, int c_ID, String o_Date, String o_ProductName){
	        this.o_ID=o_ID;
	    	this.o_ProductQTY=o_ProductQTY;
	        this.c_ID=c_ID;
	        this.o_Date=o_Date;
	        this.o_ProductName=o_ProductName;
	    }
	    
	   
	    public int getO_ID() {
	        return o_ID;
	    }

	   
	    public void setO_ID(int o_ID) {
	        this.o_ID = o_ID;
	    }
	    
	    public int getO_ProductQTY() {
	        return o_ProductQTY;
	    }

	   
	    public void setO_ProductQTY(int o_ProductQTY) {
	        this.o_ProductQTY= o_ProductQTY;
	    }

	    

		public int getC_ID() {
	        return c_ID;
	    }

	   
	    public void setC_ID(int c_ID) {
	        this.c_ID = c_ID;
	    }

	  
	    public String getO_Date() {
	        return o_Date;
	    }

	   
	    public void setO_Date(String o_Date) {
	        this.o_Date = o_Date;
	    }
	    
	    public String getO_ProductName() {
	        return o_ProductName;
	    }

	   
	    public void setO_ProductName(String o_ProductName) {
	        this.o_ProductName = o_ProductName;
	    }

	    

	  

		

}

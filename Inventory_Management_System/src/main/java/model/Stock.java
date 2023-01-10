package model;

public class Stock {
	
	 	private int s_ID;
	    private int s_ProductQTY;
	    private float s_Price;
	    private int s_ProductID;
	    private String s_ProductName;
	    
	    
	
	    
	    public Stock(int s_ProductQTY,float s_Price ,int s_ID, String s_ProductName){
	        this.s_ProductQTY = s_ProductQTY;
	        this.s_Price = s_Price;
	        this.s_ID=s_ID;
	        this.s_ProductName = s_ProductName;
	    }

	    public Stock(int s_ProductID,int s_ProductQTY,float s_Price ,int s_ID, String s_ProductName){
	        this.s_ProductID=s_ProductID;
	    	this.s_ProductQTY = s_ProductQTY;
	        this.s_Price = s_Price;
	        this.s_ID=s_ID;
	        this.s_ProductName = s_ProductName;
	    }

	

	

		public Stock() {
			// TODO Auto-generated constructor stub
		}

		public int getS_ID() {
	        return s_ID;
	    }

		 public void setS_ID(int s_ID) {
		        this.s_ID = s_ID;
		    }

	   
	    public void setS_ProductID(int stockProductID) {
	        this.s_ProductID = s_ProductID;
	    }
	    

		public int getS_ProductID() {
	        return s_ProductID;
	    }

	   
	   
	   
	    public int getS_ProductQTY() {
	        return s_ProductQTY;
	    }

	   
	    public void setS_ProductQTY(int s_ProductQTY) {
	        this.s_ProductQTY = s_ProductQTY;
	    }

	    public float getS_Price() {
	        return s_Price;
	    }

	    public void setS_Price(float s_Price) {
	        this.s_Price = s_Price;
	    }

	  
	    public String getS_ProductName() {
	        return s_ProductName;
	    }

	   
	    public void setS_ProductName(String s_ProductName) {
	        this.s_ProductName = s_ProductName;
	    }

		
	    

	  

		

}

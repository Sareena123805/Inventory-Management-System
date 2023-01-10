
package model;

public class Sales{
	
	 	private int sl_ID;
	    private String sl_ProductName;
	    private int sl_ProductQTY;
	    private float sl_Price;
	    private String s_Date;
	    
	    
	    public Sales() {
			// TODO Auto-generated constructor stub
		}
	    
	    public Sales(int salesID,String salesProductName ,int salesProductQTY, float salesPrice, String salesDate){
	        this.sl_ID = salesID;
	        this.sl_ProductName = salesProductName;
	        this.sl_ProductQTY=salesProductQTY;
	        this.sl_Price= salesPrice;
	        this.s_Date=salesDate;
	    }

	    public Sales(String salesProductName ,int salesProductQTY, float salesPrice, String salesDate){
	        this.sl_ProductName = salesProductName;
	        this.sl_ProductQTY=salesProductQTY;
	        this.sl_Price= salesPrice;
	        this.s_Date=salesDate;
	    }

	    
	   
	    public int getSl_ID() {
	        return sl_ID;
	    }

	   
	    public void setSl_ID(int salesID) {
	        this.sl_ID = salesID;
	    }
	    

		public String getSl_ProductName() {
	        return sl_ProductName;
	    }

	   
	    public void setSl_ProductName(String salesProductName) {
	        this.sl_ProductName = salesProductName;
	    }

	   
	    public int getSl_ProductQTY() {
	        return sl_ProductQTY;
	    }

	   
	    public void setSl_ProductQTY(int salesProductQTY) {
	        this.sl_ProductQTY = salesProductQTY;
	    }

	    public float getSl_Price() {
	        return sl_Price;
	    }

	    public void setSl_Price(float salesPrice) {
	        this.sl_Price = salesPrice;
	    }

	  
	    public String getS_Date() {
	        return s_Date;
	    }

	   
	    public void setS_Date(String salesDate) {
	        this.s_Date = salesDate;
	    }

	    

	  

		

}

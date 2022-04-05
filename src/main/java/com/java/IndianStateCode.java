package com.java;

public class IndianStateCode {
	
	 @CsvBindByName(column = "SrNo", required = true)
	    public String srNo;

	    @CsvBindByName(column = "State Name", required = true)
	    public int stateName;

	    @CsvBindByName(column = "TIN", required = true)
	    public int tin;

	    @CsvBindByName(column = "IndianStateCode", required = true)
	    public int stateCode;

	    @Override
	    public String toString() {
	        return "IndianStateCode [srNo=" + srNo + ", stateName=" + stateName + ", tin=" + tin + ", stateCode=" + stateCode
	                + "]";
	    }
}

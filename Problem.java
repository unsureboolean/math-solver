package unsureBoolean_Project3Package;
import java.util.*;
public class Problem {

	private int factor1;
	private int factor2;
	private int loRange;
	private int hiRange;
	private int sum;
	private int product;
	private int calc;
	private int response = -1;
	private String cI;
	private int probPts;
	private String probImage;
	
	
	
	Problem() {
	}
	
	Problem(int loRange, int hiRange) {
		this.loRange = loRange;
		this.hiRange = hiRange;
	}
	
	// Invoke Random constructor 
	Random rand = new Random();
	
	
	public void setLoRange(int loRange) {
		this.loRange = loRange;
	}
	public void setHiRange(int hiRange) {
		this.hiRange = hiRange;
	}
	public int getLoRange() {
		return loRange;
	}
	public int getHiRange() {
		return hiRange;
	}
	
	
	// Set and get factors for the problems
	public int getFactor(int loRange, int hiRange) {
		return (int)(rand.nextDouble() * (hiRange - loRange + 1) + loRange);
	}
	public void setFactor1() {
		this.factor1 = getFactor(loRange, hiRange);
	}
	public void setFactor2() {
		this.factor2 = getFactor(loRange, hiRange);
	}
	
	// This method is invoked when operation = division and factor2 = 0 value; 
	// resets factor2 to non-zero value by setting low range parameter to 1
	public void resetFactor2() {
		this.factor2 = getFactor(1, hiRange);
	}
	
	
	public int getFactor1() {
		return factor1;
	}
	public int getFactor2() {
		return factor2;
	}

	// Method for sum and product calcs
	public int getSum() {
		return factor1 + factor2;
	}
	public int getProduct() {
		return factor1 * factor2;
	}
	
	public void setCalc(int calc) {
		this.calc = calc;
	}
	public int getCalc() {
		return calc;
	}
	public void setResponse(int response) {
		this.response = response;
	}
	public int getResponse() {
		return response;
	}
	
	public void setProbPts(int response) {
		this.response = response;
		if (calc == response) {
			this.probPts = 1;
			this.cI = "Correct"; 
		}
		else {
			this.probPts = 0;
			this.cI = "Incorrect";
		}
	}
	
	public int getProbPts() {
		return probPts;
		
	}
	public String getCI() {
		return cI;
	}
	
}
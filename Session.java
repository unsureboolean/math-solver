package unsureBoolean_Project3Package;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Session {

	private String name;
	private char operation;
	private String operLong;
	private int numOfProb;
	private String dateTime;
	private String dateTimeFormat;
	private long startTime;
	private long endTime;
	private String[] probArray;
	private int runScore;
	private int pctScore;
	private int hiRange = 0;
	private int loRange = -1;
		
	Session() {
	}
	
	Session(String name, char operation, int numOfProb) {
		this.name = name;
		this.operation = operation;
		this.numOfProb = numOfProb;
		setOperation(operation);
		initProbArray();
		setDateTime();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	
	// Method sets the operation to upper case if not already that way, and updates full-word operLong
	public void setOperation(char operation) {
		this.operation = operation;
		switch(operation) {
			case 'A' : {this.operLong = "Addition"; break;}
			case 'a' : {this.operLong = "Addition"; break;}
			case 'S' : {this.operLong = "Subtraction"; break;}
			case 's' : {this.operLong = "Subtraction"; break;}
			case 'M' : {this.operLong = "Multiplication"; break;}
			case 'm' : {this.operLong = "Multiplication"; break;}
			case 'D' : {this.operLong = "Division"; break;}
			case 'd' : {this.operLong = "Division"; break;}
		}
	}
	public char getOperation() {
		return this.operation;
	}
	public String getOperLong() {
		return operLong;
	}
	public void setNumOfProb(int numOfProb) {
		this.numOfProb = numOfProb;
	}
	public int getNumOfProb() {
		return numOfProb;
	}
	
	// Methods for the session elapsed time and for the session record date and time
	public void setStartTime() {
		startTime = System.currentTimeMillis();
	}
	public long getStartTime() {
		return startTime;
	}
	public void setEndTime() {
		endTime = System.currentTimeMillis();
	}
	public long getEndTime() {
		return endTime;
	}
	public long getElapsedTime() {
		return (endTime - startTime) / 1000;
	}
	
	public void setDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter frmt = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS");
		this.dateTimeFormat = dateTime.format(frmt);
	}
	public String getDateTime() {
		return dateTimeFormat;
	}
	public String getDT() {
		return dateTime;
	}
	
	
	public void setRunScore(int probPts) {
		runScore = runScore + probPts;
	}
	public long getRunScore() {
		return runScore;
	}
	
	
	public void initProbArray() {
		this.probArray = new String[numOfProb];
	}
	
	public void setProbArray(int val1, String operation, int val2, String equals, 
			int response, int calc, String cI, int i ) {
		this.probArray[i] = val1 + operation + val2 + equals + response + " A: " + calc + " " + cI;
	}
	
	public String getProbArray(int i) {
		return probArray[i];
	}

	public void setHiRange(int hiRange) {
		this.hiRange = hiRange;
	}
	
	public int getHiRange() {
		return hiRange;
	}
	
	public void setLoRange(int loRange) {
		this.loRange = loRange;
	}
	
	public int getLoRange() {
		return loRange;
	}
	
	public int getPctScore() {
		double numOfProbD = numOfProb;
		double runScoreD = runScore;
		pctScore = (int)((runScoreD / numOfProbD) * 100);
		return pctScore;
	}
	
}
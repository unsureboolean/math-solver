package unsureBoolean_Project3Package;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionHandling {
	
	ExceptionHandling () {}
	
	public boolean validateName(String name) {
	
		Pattern p = Pattern.compile("[^a-z. ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(name);
		if(m.find()) {
			System.out.println("Name cannot contain numbers or special characters, please try again: ");
			System.out.println();
			return true;
		}
		else if (name.length() == 0) {
			System.out.println("Seriously, enter your name.");
			System.out.println();
			return true;
		}
		else return false;
	}	
		
	public boolean validateOpType (char type) {
		char[] answerChoices = {'A', 'a', 'S', 's', 'M', 'm', 'D', 'd'};
		for (int i = 0; i < answerChoices.length; i++) {
			if (type == answerChoices[i]) {
				return false;
			}
			
		}
		System.out.println("Answer choice did not match, please try again: ");
		System.out.println();
		return true;
	}
	
	public boolean validateInt(int intNum) {
		if (intNum >= 1) {
			return false;
		}
		else {
			System.out.println("Must use only positive numbers, try again: ");
			System.out.println();
			return true;
		}
	}
	
	public boolean validateIntOrZero(int intOrZero) {
		if (intOrZero >= 0) {
			return false;
		}
		else {
			return true;
		}
	}
}

package unsureBoolean_Project3Package;

import java.util.*;
import java.lang.*;

public class UnsureBoolean_Project3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name;
		char operation;
		int numOfProb = 0;
		int loRange;
		int hiRange;
		int response;
		
		Session session = new Session();
				
		ExceptionHandling exception = new ExceptionHandling();
		// Get inputs - Name, Operation, Number of Problems, Range Values
		Scanner input = new Scanner(System.in);
		
		// Numbers and special characters are the only things I thought Prof. Short would want excluded. 
		// I allowed periods for instances of Jeff Jr. or Mrs. Smith
		// 
		do {
			System.out.print("Please enter your name: ");
			name = input.nextLine();
			session.setName(name);
		} while (exception.validateName(name));
		
		System.out.println();
		
		do {
			try {
				System.out.print("What operation would you like to work -");
				System.out.print(" A, S, M, or D? ");
				String operationType = input.nextLine();
				if(operationType.length() == 0) {
					System.out.println("Try again: ");
					System.out.println();
					operationType = input.nextLine();
				}
				
				session.setOperation(operationType.charAt(0));
			} catch (Exception e) {
				System.out.println();
				System.out.println("Must be A, S, M, or D, try again:");
				input.next();			
			}
		} while (exception.validateOpType(session.getOperation()));
		
		System.out.println();
		
		do {
			try {
				System.out.print("Enter number of problems: ");
				numOfProb = input.nextInt();
				session.setNumOfProb(numOfProb);
			} catch (Exception e) {
				input.next();
			}
		} while (exception.validateInt(numOfProb));
		
		System.out.println();
		
		do {
			try {
				System.out.print("Enter the high number for your range of problems (must be greater than zero): ");
				hiRange = input.nextInt();				
				session.setHiRange(hiRange);			
			} catch (Exception e1) {
				input.next();
			}
		} while (exception.validateInt(session.getHiRange()));
		
		System.out.println();
		
		do {
			try {
				System.out.print("Enter the low number for your range of problems, (no negative numbers): ");
				loRange = input.nextInt();	
				session.setLoRange(loRange);
			} catch (Exception e2) {
				System.out.println("Must use only positive numbers or zero, try again: ");
				System.out.println();
				input.next();
			}
		} while (exception.validateIntOrZero(session.getLoRange()));

		// Invoke the constructors, which updates vars in Problem and Session, and run various methods, too
//		Session session2 = new Session(session.getName(), session.getOperation(), session.getNumOfProb());
		session.initProbArray();
		// Ensures that the loRange is less than the hiRange, if not swaps them
		int temp = session.getHiRange();

		if (session.getLoRange() > session.getHiRange()) {
			session.setHiRange(session.getLoRange());
			session.setLoRange(temp);
		}
		Problem problem = new Problem(session.getLoRange(), session.getHiRange());

		System.out.println();

		// Run the problem loop *************************************************
		
		
		session.setStartTime();
		session.setDateTime();
		for (int i = 0; i < session.getNumOfProb(); i++) {   
			System.out.println();

			// Get factors
			problem.setFactor1();
			problem.setFactor2();
			
			// Run cases � ASMD � using switch  ***************************************
		
			switch(session.getOperation()) {
				
			case('A') :
			case('a') :
				problem.setCalc(problem.getSum());	// This sets the calculated (calc) answer
			
				do {
					problem.setResponse(-1);
					try {
						System.out.print(problem.getFactor1() + " + " + problem.getFactor2() + " = ");
						problem.setResponse(input.nextInt());
					} catch (Exception e) {
						System.out.println("Invalid input, please try again");
						System.out.println();
						input.next();
					} // Get user response to compare to calc
				} while (exception.validateIntOrZero(problem.getResponse()));
				problem.setProbPts(problem.getResponse());		// Evaluating problem to assign pts / correct or not

				System.out.println(problem.getCI());	// Tells user if response was correct or not

				session.setRunScore(problem.getProbPts());	// Add 1 if correct, 0 if incorrect

				session.setProbArray(problem.getFactor1(), " + ", problem.getFactor2(), 
						" = ", problem.getResponse(), problem.getCalc(), problem.getCI(), i);
//				System.out.println(session.getProbArray(0));
			break;
			
			case('S') :
			case('s') :
				problem.setCalc(problem.getFactor1());	// This sets the calculated (calc) answer
			
				do {
					problem.setResponse(-1);
					try {
						System.out.print(problem.getSum() + " - " + problem.getFactor2() + " = ");
						problem.setResponse(input.nextInt());
					} catch (Exception e) {
						System.out.println("Invalid input, please try again");
						input.next();
					} // Get user response to compare to calc
				} while (exception.validateIntOrZero(problem.getResponse()));
				problem.setProbPts(problem.getResponse());		// Evaluating problem to assign pts / correct or not
		
				System.out.println(problem.getCI());	// Tells user if response was correct or not
				session.setRunScore(problem.getProbPts());	// Add 1 if correct, 0 if incorrect
				session.setProbArray(problem.getFactor1(), " - ", problem.getFactor2(), 
					" = ", problem.getResponse(), problem.getCalc(), problem.getCI(), i);
			break;
				
			case('M') :
			case('m') :
				problem.setCalc(problem.getProduct());	// This sets the calculated (calc) answer
			
				do {
					problem.setResponse(-1);
					try {
						System.out.print(problem.getFactor1() + " * " + problem.getFactor2() + " = ");
						problem.setResponse(input.nextInt());
					} catch (Exception e) {
						System.out.println("Invalid input, please try again");
						input.next();
					} // Get user response to compare to calc
				} while (exception.validateIntOrZero(problem.getResponse()));
				problem.setProbPts(problem.getResponse());		// Evaluating problem to assign pts / correct or not
		
				System.out.println(problem.getCI());	// Tells user if response was correct or not
				session.setRunScore(problem.getProbPts());	// Add 1 if correct, 0 if incorrect
				session.setProbArray(problem.getFactor1(), " * ", problem.getFactor2(), 
					" = ", problem.getResponse(), problem.getCalc(), problem.getCI(), i);
			break;
			
			case('D') :
			case('d') :	
				problem.setCalc(problem.getFactor1());	// This sets the calculated (calc) answer
			
				if (problem.getFactor2() == 0) 
					problem.resetFactor2();
			
				do {
					problem.setResponse(-1);
					try {
						System.out.print(problem.getProduct() + " / " + problem.getFactor2() + " = ");
						problem.setResponse(input.nextInt());
					} catch (Exception e) {
						System.out.println("Invalid input, please try again");
						input.next();
					} // Get user response to compare to calc
				} while (exception.validateIntOrZero(problem.getResponse()));
				problem.setProbPts(problem.getResponse());		// Evaluating problem to assign pts / correct or not
		
				System.out.println(problem.getCI());	// Tells user if response was correct or not
				session.setRunScore(problem.getProbPts());	// Add 1 if correct, 0 if incorrect
				session.setProbArray(problem.getFactor1(), " / ", problem.getFactor2(), 
					" = ", problem.getResponse(), problem.getCalc(), problem.getCI(), i);
			break;
				
			}
			
		}
		
		// Execute the finishing steps � printing out stats and problems  **********************
		
		session.setEndTime();
		
		System.out.println();
		System.out.println();
				
		System.out.println("Summary");
		System.out.printf("%s %s %s Range:%2d -%2d Number of Problems: %3d Number Correct: %3d Score: %3d Time: %4d seconds", 
				session.getName(),
				session.getDateTime(),
				session.getOperLong(),
				problem.getLoRange(),
				problem.getHiRange(),
				session.getNumOfProb(),
				session.getRunScore(),
				session.getPctScore(),
				session.getElapsedTime()
				);
		
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < session.getNumOfProb(); i++) {
			System.out.println(session.getProbArray(i));
		}
	}

}
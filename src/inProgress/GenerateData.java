package inProgress;

import java.util.Random;

public class GenerateData {
	
	public static String getSampleName() {
		 	String[] firstNames = {"John", "Sarah", "Michael", "Jessica", "David"};
	        String[] lastNames = {"Smith", "Johnson", "Brown", "Davis", "Garcia"};
	        Random random = new Random();
	        
	        int index1 = random.nextInt(firstNames.length);
	        int index2 = random.nextInt(lastNames.length);

	        String firstName = firstNames[index1];
	        String lastName = lastNames[index2];

	        return (firstName + " " + lastName);
	}
	public static void main(String[] args) {
		
		System.out.println(GenerateData.getSampleName());
		
		/*
		 * int numEntries = 10; String[] processNames = { "process1", "process2",
		 * "process3", "process4", "process5" }; Random random = new Random();
		 * 
		 * for (int i = 0; i < numEntries; i++) { int index =
		 * random.nextInt(processNames.length); String processName =
		 * processNames[index]; System.out.println(processName); }
		 */
	}
}

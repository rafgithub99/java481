package unit7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BubbleSortDataSet {

	public static void main(String[] args) {
		//import data set from file 'credit card' 7,974,596.00 total records
		String csvFile = "/Users/Admin/workspace/IT481-01/src/unit7/creditcard.csv";
		String line = "";
		String cvsSplitBy = ",";
		int count =0;
		int maxLines = 25000; //how many lines to read from file Max 284807
		        
		ArrayList<Double> numberList = new ArrayList<>();//create ArrayList to store

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		  

			while ((line = br.readLine()) != null && count < maxLines) {
				
				// use comma as separator
		        String[] stringArray = line.split(cvsSplitBy);
		                
		        //convert the strings of each line into double type and store in ArrayList
		        for(int i=0; i<stringArray.length; i++)
		        numberList.add(Double.parseDouble(stringArray[i]));
		        count ++;
		        }//end while loop
		 	} catch (IOException e) {
		 		e.printStackTrace();
		        }//end try/catch
		        
		    System.out.println("Sorting "+(count*28)+" records from the file 'credit card'");
		    long startTime = System.currentTimeMillis();//start timer
		        
		    Double[] numberArray = new Double[numberList.size()];
		    numberArray = numberList.toArray(numberArray);//convert ArrayList to array
		        
		    //pass the array and begin sorting        
		    bubbleSort(numberArray);
		        
		    long endTime = System.currentTimeMillis();//end sort time
			System.out.println("Sorting took "+(endTime - startTime) + " miliseconds");
			
			/*test code to check if sorting is correct - use only with 1 line
			for (double value:numberArray){
				System.out.println(value);
			}*/

	}//end main
	
	private static void bubbleSort(Double[] doubleArray) {

		double n = doubleArray.length;
		double temp = 0;

		for(int i=0; i < n; i++){
			for(int j=1; j < (n-i); j++){
				
				if(doubleArray[j-1] > doubleArray[j]){
					//swap the elements!
					temp = doubleArray[j-1];
					doubleArray[j-1] = doubleArray[j];
					doubleArray[j] = temp;
				}//end if block to swap
			
			}//end j for loop
		}//end i for loop
	}//end bubbleSort	
	
}//end class

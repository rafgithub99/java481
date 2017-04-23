package unit7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuickSortDataSet {
	
	public static void main(String[] args) {
		
		//import data set from file 'credit card' 7,974,596.00 total records
		String csvFile = "/Users/Admin/workspace/IT481-01/src/unit7/creditcard.csv";
        String line = "";
        String cvsSplitBy = ",";
        int count =0;
        int maxLines = 284807; //how many lines to read from file Max 284807
        
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
        sortArrayAsc(numberArray, 0, numberArray.length-1);
        
        long endTime = System.currentTimeMillis();//end sort time
		System.out.println("Sorting took "+(endTime - startTime) + " miliseconds");        

	}//end main
	
	//QuickSort - takes an array of doubles and sorts from low to high value
	private static void sortArrayAsc(Double[] doubleArray, int low, int high) {
		
		if (doubleArray == null || doubleArray.length == 0)
			return;
			
		if (low >= high)
			return;
			
		// pick the pivot
		int middle = low + (high - low) / 2;
		double pivot = doubleArray[middle];
			
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (doubleArray[i] < pivot) {//LESS THAN pivot value
				i++;
			}
			while (doubleArray[j] > pivot) {//GREATER THAN pivot value
				j--;
			}
			if (i <= j) {
				double temp = doubleArray[i];
				doubleArray[i] = doubleArray[j];
				doubleArray[j] = temp;
				i++;
				j--;
			}
		}//end while block
			
		// recursively sort two sub parts
		if (low < j)
			sortArrayAsc(doubleArray, low, j);
		if (high > i)
			sortArrayAsc(doubleArray, i, high);
	}//end sortArrayAsc

}//end class

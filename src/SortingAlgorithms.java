import java.io.*;		//Import input/output class
import java.util.Arrays;

import javax.swing.JOptionPane;		//Import Library for JOption Pane class


public class SortingAlgorithms {

	public static void main(String[] args) throws IOException{
		JOptionPane.showMessageDialog(null, "Welcome to the Number Sorting Application. " +
				"\n\nPlease click 'OK' to proceed to choose the " +
				"\nText file that you want to Open for sorting.");	//Show Message Dialog box with message
		int[] array=new int[1000];	//Create new array of size 1000
		int[] getArray=fileUpload.FileArrayProvider(array);	//pass this empty array to the FileArrayProvider method in the fileUpload Class
		
		System.out.println("Array before sorting: ");	//Print Statement
		for (int y = 0; y <array.length; y++) //Iterate through the array
			{		
			System.out.print(getArray[y] + " ");	//Print each element from the unsorted array
			}
		
		
		//Choose Sorting Method Required
		String strSelection=JOptionPane.showInputDialog("Please select Sorting Method required by selecting "
				+ "the number.\n1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort\n"
				+ "4. Merge Sort\n5. Quick Sort");	//Show Dialog Box, user must choose sorting method by number
		int selection=Integer.parseInt(strSelection);	//assign integer inputted by the user to the variable selection
	
		//Choose Bubble Sort
		if (selection==1){	//if user selects Option 1 do this
				int[] sortedArray=sortingMethods.bubbleSort(array);	//Passes the unsorted array to the BubbleSort method
				System.out.printf("\n\nSorted Array using Bubble Sort: \n");  //Prints statement
				SortingAlgorithms.printArray(sortedArray);	//Passes the sorted array to the printArray method
				SortingAlgorithms.tokenizeString(sortedArray);}	//Passes the sorted array to the tokenizeString method
    
		//Choose Selection Sort
		else if (selection==2){	//if user selects Option 2 do this
				int[] sortedArray=sortingMethods.selectionSort(array);	//Passes the unsorted array to the Selection Sort method
				System.out.printf("\n\nSorted Array using Selection Sort: \n");  //Prints statement
				SortingAlgorithms.printArray(sortedArray);	//Passes the sorted array to the printArray method
				SortingAlgorithms.tokenizeString(sortedArray);}	//Passes the sorted array to the tokenizeString method
		
		//Choose Insertion Sort
		else if (selection==3){	//if user selects Option 3 do this
				int[] sortedArray=sortingMethods.insertionSort(array);	//Passes the unsorted array to the Insertion Sort method
				System.out.printf("\n\nSorted Array using Insertion Sort: \n");  //Prints statement
				SortingAlgorithms.printArray(sortedArray);	//Passes the sorted array to the printArray method
				SortingAlgorithms.tokenizeString(sortedArray);}	//Passes the sorted array to the tokenizeString method
		
		//Choose Merge Sort
		else if (selection==4){	//if user selects Option 4 do this
				int[] sortedArray=sortingMethods.mergeSort(array);	//Passes the unsorted array to the Merge Sort method
				System.out.printf("\n\nSorted Array using Merge Sort: \n");  //Prints statement
				SortingAlgorithms.printArray(sortedArray);	//Passes the sorted array to the printArray method
				SortingAlgorithms.tokenizeString(sortedArray);}	//Passes the sorted array to the tokenizeString method
		
		//Choose Quick Sort
		else if (selection==5){	//if user selects Option 5 do this
				int[] sortedArray=sortingMethods.quickSort(array);	//Passes the unsorted array to the Quick Sort method
				System.out.printf("\n\nSorted Array using Quick Sort: \n");  	//Prints statement
				SortingAlgorithms.printArray(sortedArray);	//Passes the sorted array to the printArray method
				SortingAlgorithms.tokenizeString(sortedArray);}	//Passes the sorted array to the tokenizeString method
		
	}//end method



	//Print Array method
	public static void printArray(int[] array){
		for (int i=0;i<array.length;i++)	//iterate through the array
		{
		System.out.print(array[i]+" ");}	//Print each element in the array
	
	}//end method
	
	//Tokenize string method	
		public static void tokenizeString(int[] array) throws IOException{
			String temp = Arrays.toString(array).replace(", ", " ");	//Create a string from the sorted arrays
			String sortedData = temp.substring(1, temp.length()-1);	//Create a new string and remove the comma seperating each element of the array
			String[] tokens=sortedData.split(" ");	//Tokenize the string(with the commas removed) and create a string array of the tokens
			fileUpload.createTextFile(tokens);	//Pass the token elements to the createTextFile method in the fileUpload class
		}//end method

}//end class

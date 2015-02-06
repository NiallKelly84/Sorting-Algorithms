import java.util.Arrays;

public class sortingMethods {
			
	
			//Bubble Sort Method
			public static int[] bubbleSort(int[] array){
				 int outer, inner, temporary;	//declare integer variables
				 for (outer=array.length-1; outer>0;outer--){   //iterates through the array in reverse order
					 for(inner=0;inner<outer;inner++)	//iterates up through the inner array as far as outer, for each iteration of outer
					 {
				    	if (array[inner]>array[inner+1]) //If a number in an element of the array is greater than the next number in the array, then
				        {
				         temporary=array[inner];	//assign the first element (ie: the larger number) to a temporary integer called 'temp'
				         array[inner]=array[inner+1];	//assign the smaller number to the first array position
				         array[inner+1]=temporary;	//Assign the larger number to the second array position. This swaps the position of the two numbers
				        }	//end if
				      }		//end for
				    }	//end for
				 return array; 	//returns the array elements
	}//end method
			
			
			
			//Selection Sort Method
			public static int[] selectionSort(int[] array){
			int outer,inner,temporary,minimum;	//declares variables
			for (outer=0;outer<array.length-1;outer++)	//outer loop to iterate through the array
			{
				minimum=outer;	//minimum value starts at the iteration position in the outer array
				for (inner=outer+1;inner<array.length;inner++)	//iterates up through the inner array for each iteration of outer, with the inner count starting at outer+1
				{
					if(array[inner]<array[minimum])	//if the value of the array element in position inner is less than the array element in the minimum position
					{
						minimum=inner;	//assign the value of inner to the variable minimum (this finds the minimum value in the inner array)
					}
				}
					temporary=array[outer];	//assign the outer element in the array to a temporary integer called 'temp'
					array[outer]=array[minimum];	//assign the minimum value found within the inner loop to the outer position in the array
					array[minimum]=temporary;	//assign the value of temp to the element in array position minimum. This swaps the position of the two elements in the array
			}//end for
		    
		    return array;	//returns the array values
	}//end method
			
		    
			//Insertion Sort Method
			public static int[] insertionSort(int arr[]) {  
				int i,j, newValue;
				for (i= 1; i< arr.length; i++) {  //iterate through the outer loop
					newValue= arr[i];  	//create temporary variable to store the value of the outer element
					j=i;
					
					while (j > 0 && arr[j-1] > newValue) {  //while inner is greater than zero and the element in array inner position is greater than temp
						arr[j] = arr[j-1];  //swap inner and inner+1
			    	    j = j - 1;  //increment inner downwards by one
			    	    }  
					arr[j] = newValue;}	//array element at inner+1 gets assigned the temp value
				return arr;	//return the array elements
				}  //end method
			
			
			
			//Insertion Sort Method
			//public static int[] insertionSort(int array[]) {  
				//for (int outer = 0; outer < array.length; outer++) {  //iterate through the outer loop
					//int temp = array[outer];  	//create temporary variable to store the value of the outer element
					//int inner = outer - 1;  //value of inner element
					//while (inner >= 0 && array[inner] > temp) {  //while inner is greater than zero and the element in array inner position is greater than temp
						//array[inner + 1] = array[inner];  //swap inner and inner+1
			    	    //inner = inner - 1;  //increment inner downwards by one
			    	    //}  
					//array[inner + 1] = temp;}	//array element at inner+1 gets assigned the temp value
				//return array;	//return the array elements
				//}  //end method
			

			//Merge Sort Method
			public static int[] mergeSort(int[] array) {
				if (array.length > 1) {	//If the array has more than one element
					int midPoint = array.length/2;	//Then the middle element of the array is found by dividing the array length by two
				    int[] leftArray = Arrays.copyOfRange(array, 0, midPoint);	//creates a new array with all the elements from 0 to the midpoint in the main array
				    int[] rightArray = Arrays.copyOfRange(array,midPoint,array.length);	//creates a new array with all the elements from the middle to the end of the main array
				    mergeSort(leftArray);	//calls the mergeSort method for the leftArray. This results in the arrays eventually being broken down into a series of arrays of length 1
				    mergeSort(rightArray);	//calls the mergeSort method for the rightArray. This results in the arrays eventually being broken down into a series of arrays of length 1
				    merge(array,leftArray,rightArray);	//Passes array, leftArray and rightArray arguments to the merge method
				}//end if
				        
				return array;	//returns the array values
				    
			}//end method

				    
			public static void merge(int[]array,int[]l,int[]r) {        
				int totalLength=l.length+r.length;	//the totalLength is the sum of the lengths of the left and right sub arrays         
				int i,left,right;	//declares variables        
				i=left=right=0;	//assigns initial value of zero to the variables left and right        
				while (i<totalLength){	//while the value of i is less than the total length   	
					if ((l.length>left) && (r.length>right)) {	//if the length of the left sub-array is greater than the value of left and the length of the right sub-array is greater than right        
						if (l[left] < r[right]) {	//if the value of array element left in the array l is less than the value of the array element right in the array r        
							array[i] = l[left];	//assign the value of the element left in the array l to the main array in position i
							i++;	//increment i by 1
							left++;	//increment left by 1       
						}	//end if        
						else {	//otherwise      
							array[i] = r[right];	//assign the value of the element right in the array r to the main array in position i        
							i++;	//increment i by 1        
							right++;	//increment right by 1     
						}	//end else        
					}//end if        
					else {	//otherwise           	
						if (l.length<=left) {	//if the length of array l is less than or equal to the value of left        
							while (right < r.length) {	//while the value of right is less than the length of the sub-array length r        
								array[i] = r[right];	//assign the value of the element right in the array r to the main array in position i        
								i++;	//increment i by 1        
								right++;	//increment right by 1        
							}//end while        
						}	//end if   	
						if (r.length<=right)	//if the length of the sub-array r is less than or equal to the value of right        
							while (left < l.length) {	//while the value of left is less than the length of the sub-array l        
								array[i] = l[left];	//assign the value of the element left in the array l to the main array in position i        
								left++;	//increment left by 1        
								i++;	//increment i by 1        
							}	//end while        	
					}	//end if        
				}	//end while	    
			}//end method
				    
				
				    
			//Quick Sort Method
			public static int[] quickSort(int[] array){  
				int left=0;	//assign value to the variable left
				int right=array.length-1;	//assign value equal to the array length-1 to the variable right
				array = QS(array, left, right);	//pass the argument values for array, left and right to the QS method
				return array;	//returns the values of array
				} 

			private static int[] QS(int[] array, int left, int right){ 
				if (right > left){ //if the value of right is greater than the value of left
					int pivotLocation = left;	//assign the value of left to the variable pivotLocation
					int nextPivotLocation = partition(array, left, right, pivotLocation);	//find the nextPivotLocation by passing the arguments array, left, right and pivotLocation to the partition method
					QS(array, left, nextPivotLocation-1); //Pass the arguments array, left and nextPivotLocation-1, to the QS method
					QS(array, nextPivotLocation+1, right); 	//Pass the arguments array, nextPivotLocation+1, and right, to the QS method
					}	//end if
				return array;	//return the array values
				}	//end method

 
			private static int partition(int[] array, int left, int right, int pivotLocation){
				int valueOfPivot = array[ pivotLocation ];	//gives the value of the pivot from the array
				swap(array, pivotLocation, right); //swap the values of the elements at pivotLocation with right by calling the swap method
				int index = left;	//assigns initial value to the variable index
				for (int i = left; i < right; i++){	//iterate through the values from left to right
					if ( (array[i])<=(valueOfPivot)){	//if the value of element i is less than or equal to the value of the pivot
						swap(array, i, index);	//call the swap method to swap the values of array elements i and index
						index++;	//increment index by 1
					}//end if
				}	//end for
   
				swap(array, right, index);	//swap the values of the elements at right with index by calling the swap method
				return index;	//returns index
			}	//end method

										
			private static void swap(int[] array, int i, int j){
				int temp = array[i];	//temp is assigned the value in the argument i
				array[i] = array[j];  	//the array element i is assigned the value of the array element j
				array[j] = temp;  		//the array element j is assigned the value from temp. This completes the swap of the values of array elements i and j
			}	//end method
			

}//end class
			

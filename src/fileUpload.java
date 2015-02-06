import java.io.*;
import java.util.*;

import javax.swing.*;

public class fileUpload{
	private static final String EMPTY_STRING = null;	//Declares a constant as having a null value

	//Method to import data from text file	
	public static int[] FileArrayProvider(int[] array1) throws IOException{
		JFileChooser chooser=new JFileChooser();	//Create new JFileChooser Object
		chooser.showOpenDialog(null);	//Shows the File Chooser Dialog box
		File selectedFile=chooser.getSelectedFile();	//Creates a new File object and assigns the file choosen by the user to this object
		FileReader inputFile = new FileReader(selectedFile);	//Passes the selected file to the FileReader object
		BufferedReader input = new BufferedReader(inputFile);	//Passes the file from the FileReader to the BufferReader object
		
		{String nextStringValue =input.readLine();	//Creates a string that reads the first line in the file
	    while(nextStringValue!=null){	//while there is a string on the next line of the file
	    	
	    	for(int k = 0;k<array1.length;k++){	//iterate through the length of the array
	    		array1[k] = Integer.parseInt(nextStringValue); 	//assign the next string value from the file to the next position in the array as an integer 
	    		nextStringValue = input.readLine();	//Proceed to the next line in the file
	    		}	//end for statement
	    }//end while statement
	    
	    input.close();	//close the Bufferedreader when there is no further string values to read from the file
	    return array1;}	//return the values in the array
	        
	}//end method
	

//Create Text File Method
	public static void createTextFile(String[] string) throws IOException{
		 int selectedOption = JOptionPane.showConfirmDialog(null, 	//Show dialog box with message and YES/NO option
		            "Do you want to save the sorted Array to a text File?", 
		            "Choose", 
		            JOptionPane.YES_NO_OPTION); 
			if (selectedOption == JOptionPane.YES_OPTION) {	//If YES option is selected
				String[] data=string;	//create a string array called data
				String doc=EMPTY_STRING;	//create an empty string
				JFileChooser chooser=new JFileChooser(System.getProperty("user.dir"));	//create a JFileChooser object
				int reply=chooser.showSaveDialog(null);	//show the save dialog box
					if(reply==JFileChooser.APPROVE_OPTION){	//if user chooses to save the file, do this
						saveFile(chooser.getSelectedFile().getAbsolutePath(),data);	//saves file to the selected location
						JOptionPane.showMessageDialog(null, "File Saved! This program has now terminated!");}	//Show message in dialog box
					
					else if (reply==JFileChooser.CANCEL_OPTION){
					JOptionPane.showMessageDialog(null, "This program has now terminated!");}	//Show this message
			}
		
			else if (selectedOption == JOptionPane.NO_OPTION){ //If the user chooses not to save the file
				JOptionPane.showMessageDialog(null, //"You have choosen not to save this file. " +
						"This program has now terminated!");}	//Show this message

	}//end method
			
//Save File Method
	public static void saveFile(String filename, String[] data)throws IOException{
		File outFile=new File(filename);	//Create new object to output the file to
		FileOutputStream outFileStream=new FileOutputStream(outFile);	//Create new FileOutputStream object
		PrintWriter outStream=new PrintWriter(outFileStream);	//Create new Printwrite Object
		for(int i=0;i<data.length;i++){	//Iterate through the string array
		outStream.println(data[i]);	//print each element of the string array to a new line in the output file
		}
		outStream.close();	//close the Printwriter object
	}//end method
	
}//end class		
/*
* Class that is used to read files 
*/

import java.io.*;
import java.lang.*;
import java.util.*;

public class ReadFiles{
	// creates a file object
	// Will move to OOPJavaAnalyzer so that this class can be used to read any file
	File file = new File("ObjExample.java"); 

	/*
	* @return true if file is a file, false otherwise
	*/
	public boolean checkIsFile(){
		return file.isFile();
	}

	/*
	* @return number of lines in the file
	*/
	public int findLineNumber(){
		int lines = 0;
		if (checkIsFile()){
			try{
				BufferedReader reader = new BufferedReader(new FileReader(file));
				while ( (reader.readLine()) != null){
					lines++;
				} 
			}catch (Exception e){
				System.out.println(e);
			}

		}else{
			System.out.println("This is not a file");
		}
		return lines;
	}

}
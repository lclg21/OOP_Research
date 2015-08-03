import java.io.*;
import java.lang.*;
import java.util.*;

public class ReadFiles{
// creates a file object
	File file = new File("ObjExample.java");

	/*
	* @param file, file to be read
	* @return true if file is a file, false otherwise
	*/
	public boolean checkIsFile(){
		return file.isFile();
	}

	/*
	* @param file, file to be read
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
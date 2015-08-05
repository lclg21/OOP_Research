/*
* Class that is used to read files 
*/

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.regex.*;

public class ReadFiles{
    
    /*
     * @param file, file to be checked if exists
     * @return true if file exists, false otherwise
     */
    public boolean checkIsFile(File file){
	return file.isFile();
    }
    
    /*
     * @param file, file to be read
     * @return number of lines in the file
     */
    public int findLineNumber(File file){
	int lines = 0;
	if (checkIsFile(file)){
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
    
    /*
     * @param line, string passed to be checked if it starts with //, /*, * 
     * @return true if line is not a comment in java, false otherwise.
     */
    public boolean lineIsValid(String line){
	if ( (line.trim().startsWith("//")) || (line.trim().startsWith("/*")) || (line.trim().startsWith("*")) ) {
		return false;
	}else{
		return true;
	}
    }
    
    
    /*
     * @param file, file to be read
     * @return number of classes used as type
     */
    public int countClassType(File file){
	String line;
	String[] words;
	int count = 0;

	if (checkIsFile(file)){
	    try{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while ( (line = reader.readLine()) != null){
		    if (lineIsValid(line)){
			words = line.split(" ");
			Matcher m  = Pattern.compile("new | [(]new").matcher(line);
			while(m.find()){
			    count++;
			}		
		    }		    
		}
		
	    }catch (Exception e){
		System.out.println(e);
	    }
	    
	}else{
	    System.out.println("This is not a file");
	}
	return count;
    }


}
    





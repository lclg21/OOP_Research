/*
* Program that will analyze java code to see how pure 
* OOP of a language it is.
*/

import java.io.*;
import java.lang.*;
import java.util.*;

public class OOPJavaAnalyzer{
    public static void main(String[] args){
	    
	// checks to see if there is exactly one argument passed
	if (args.length != 1){
	    System.err.println("No file detected. Exactly one file required");
	    System.exit(1);
	}
	
	File inputFile  = new File(args[0]);

	ReadFiles file = new ReadFiles();
	System.out.println(file.checkIsFile(inputFile));	
	System.out.println(file.countNewConstructorType(inputFile));
	System.out.println(file.countInstanceOfClassType(inputFile));
	
	int typeclass = file.countNewConstructorType(inputFile);
	int instanceOfType = file.countInstanceOfClassType(inputFile);

	int totalNumOfTypes = instanceOfType;

	float percent = typeclass * 100f / totalNumOfTypes;

	System.out.println(args[0] + " is " + percent + "% pure OOP Language");
    }

}



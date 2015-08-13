/*
* Program that will analyze java code to see how pure 
* OOP of a language it is.
*/

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.regex.*;

public class OOPJavaAnalyzer{

	//global array with class type names as elements.
    public static ArrayList<String> myClassArray = new ArrayList<String>();
    
    /*
     * @param file, file to be checked if exists
     * @return true if file exists, false otherwise
     */
    public boolean checkIsFile(File file){
		return file.isFile();
    }

    /*
     * @param string, adds the class used as type to the array
     */
    public void addToClassArray(String classType){
		if (!myClassArray.contains(classType)){
	    	myClassArray.add(classType);
		}
     
		System.out.println(myClassArray);
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
     * @param line, string to be checked if its the beginning of method. 
     * @return true if line is the beginning of a method, false otherwise.
     */
    public boolean isMethod(String line){
		if ( (line.trim().startsWith("public")) || (line.trim().startsWith("private")) || (line.trim().startsWith("protected")) ){
			Pattern p = Pattern.compile("\\(([^)]+)\\)");
			Matcher m = p.matcher(line);

			if (m.find()){
				return true;
			}else{
				return false;
			}

		}
		return false;
    }

    
    /*
     * @param file, file to be read
     * @return number of class types that are created by the'new' constructor. 
     */
    public int countNewConstructorType(File file){
		String line;
		String[] words;
		int count = 0;
		int index = 0;

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

    /*
     * @param file, file to be read to check if there is any casting as a class
     * @return number of times there is a casting to a class
     */
    public int countInstanceOfClassType(File file){
	int count = 0;
	String line;
	String words[];

	if (checkIsFile(file)){
	    try{
		BufferedReader reader = new BufferedReader(new FileReader(file));
                while ( (line = reader.readLine()) != null){
                    if (lineIsValid(line)){
			words = line.split(" ");
			Matcher m  = Pattern.compile("instanceof").matcher(line);
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

    public int countClassTypesAsParameters(File file){
		int count = 0;	
        String line;
        String params[];
	
        if (checkIsFile(file)){
            try{
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while ( (line = reader.readLine()) != null){
                    if (lineIsValid(line)){
						if (isMethod(line)){
							Pattern p = Pattern.compile("\\(([^)]+)\\)");
							Matcher m = p.matcher(line);

							if (m.find()){
								params = m.group(1).split(",");

								for (int i = 0; i < params.length; i++){
									if (Character.isUpperCase(params[i].charAt(0))){
										count++;
									}else{
										if (Character.isUpperCase(params[i].charAt(1))){
											count++;
										}
									}								
								}	    
							}
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


    public static void main(String[] args){
	    
		// checks to see if there is exactly one argument passed
		if (args.length != 1){
	    	System.err.println("No file detected. Exactly one file required");
	    	System.exit(1);
		}
	
		File inputFile  = new File(args[0]);

		OOPJavaAnalyzer analyzer = new OOPJavaAnalyzer();
  
		System.out.println("\nnew constructor class types: " + analyzer.countNewConstructorType(inputFile));
		System.out.println("instanceof class types:      " + analyzer.countInstanceOfClassType(inputFile));
		System.out.println("class types as parameters:   " + analyzer.countClassTypesAsParameters(inputFile) + "\n");
	
		int typeclass = analyzer.countNewConstructorType(inputFile);
		int instanceOfType = analyzer.countInstanceOfClassType(inputFile);
		int classTypesAsParam = analyzer.countClassTypesAsParameters(inputFile);
	
		int totalNumOfTypes = instanceOfType + classTypesAsParam + typeclass;

		float percent = typeclass * 100f / totalNumOfTypes;

		System.out.println(args[0] + " is " + percent + "% pure OOP Language\n" );
    }

}



import java.io.*;
import java.lang.*;
import java.util.*;

public class OOPJavaAnalyzer{
	public static void main(String[] args){
		ReadFiles file = new ReadFiles();
		System.out.println(file.checkIsFile());
		System.out.println(file.findLineNumber());
	}

}



/*
* Simple java program used for testing how pure OOP 
* of a language is by the program OOPJavaAnalyzer 
*/

// ObjExample.java
class ObjExample
{
   //field named i of type integer (primitive data type)
   int i = 1;
   public static void main (String [] args)
   {
      // creates first object from the ObjExample class
      // obj1 is an instance of the class ObjExample
      ObjExample obj1 = new ObjExample ();
      System.out.println ("obj1.i = " + obj1.i);
      obj1.printStmnt ();
      
      // creates second object from the ObjExample class
      // obj2 is an instance of the class ObjExample
      ObjExample obj2 = new ObjExample ();
      obj1.i = 2;
      System.out.println ("obj1.i = " + obj1.i);
      obj1.printStmnt ();
      System.out.println ("obj2.i = " + obj2.i);
      obj2.printStmnt ();
   }
   void printStmnt ()
   {
      System.out.println ("i = " + i + "\n");
   }
}
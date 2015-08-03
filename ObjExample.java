// ObjExample.java
class ObjExample
{
   int i = 1;
   public static void main (String [] args)
   {
      // creates first object of type ObjExample
      ObjExample obj1 = new ObjExample ();
      System.out.println ("obj1.i = " + obj1.i);
      obj1.printStmnt ();
      
      // creates second object of type ObjExample
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
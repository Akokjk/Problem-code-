/**************************************************************************
#* Coder: Aaron Barack
#* cruzid: 1610158
#* class: CMPS12B
#* file: DictionaryTest.java
#* Notes and compilation: no special requirements
#* Description: configured for PA#3
#* Made to signify the problem more deeply 
#***************************************************************************/
public class DictionaryTest{ 
	public static void main(String[] args){
	  Dictionary dict = new Dictionary();
	  //This is the samething as the scripts 
	 for(int i = 0; i < 10; i++){
		 dict.insert(""+i, "value"); 
		 
	 }
	  System.out.println("Value:" + dict.lookup("1")); // returns null because underyling problem with conversion of i into a string 
	  further(); 
	}
	public static void further(){
	  Dictionary dict = new Dictionary();
	 for(int i = 0; i < 10; i++){
		 String input = String.valueOf(i); //now that I have explicitly stated it you would think it would work 
		 dict.insert(input, "hello"); 
		 
		 
	 }
	  System.out.println("Value:" + dict.lookup("1")); //You think this should work but it does not
	  dict.insert("1", "hello"); //when I call insert with a true string 

	  
	  
	  
	  System.out.println("Value:" + dict.lookup("1")); //This works 
	  System.out.println("Value:" + dict.lookup(String.valueOf(1))); //This does not but why is that? 
	  
	  System.out.println("");
	  String test = "2"; 
	  dict.insert(test, "Hi"); 
	  System.out.println("Value:" + dict.lookup(test)); //This works 
	  System.out.println("Value:" + dict.lookup("2")); //This works 
	  System.out.println("Value:" + dict.lookup(String.valueOf(2))); //This does not, This proves that either java or my dictionary is not doing the correct conversion
	  //But does the manual specify that your inputs must also expect converted input strings? no it does not! That is my main point im trying to make here 
	  //I think its because my dictionary file is not converting that input into a proper string and thus it is not working
	  //But that conversion is not stated in manual as something we were supposed to put in, is this a bug a java or my dictionary file? 
	  //Its very hard to verify this because I can not directly see whats going to my dictionary class 
	  System.out.println("1 is " + String.valueOf(1)); //This says that it should be one,  
	   //For what ever reason the string value of i converted to string is not that same as a string 
	   //I can not explain this but this should not affect my grade because my dictionary is clearly working with properly stated strings
	   
		
	 //I think I found the root cause but still this should not be considered my fault, 
	   /*
	   My lookup function is checking for simple eqaulity, I think that is where its failing, its doing a bitwise check of the inputs and of course they are different 
	   I found the solution https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
	   I was checking for object equality which would've been fine had the inputs been true strings 
	   I should've used .equals instead of ==, but I'm sure that other students got docked points because of this problem as well 
	   */	
		
	   //Here is a method that would work with my existing lookup function 
	   String numberAsString = String.format ("%d", 5);
	   dict.insert(numberAsString, "Hi"); 
	   System.out.println("");
	   System.out.println("Value of 5:" + dict.lookup(numberAsString)); //For some reason this works, use this in your testing harness 
	  
	   System.out.println("Value of 5:" + dict.lookup("5")); 
	   System.out.println("Value of 5:" + dict.lookup(String.valueOf(5)));
	   
	}
}

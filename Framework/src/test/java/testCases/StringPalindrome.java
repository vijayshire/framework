package testCases;

import java.util.Scanner;

import org.testng.annotations.Test;

public class StringPalindrome {
  @Test
  public void f() {
	  
	  String str, original,rev="";
	  int i;
	  
	  System.out.println("Please enter a string");
	  
	  Scanner input = new Scanner(System.in);
	  str = input.nextLine();
	  
	  original=str;
	  
	  
	  
	  for(i=str.length()-1;i>=0;i--) {
		  
		  rev = rev+str.charAt(i);
		  
	  }
	  
	  if(rev.equals(original)) {
		  
		  System.out.println("String is Palindrome");
	  }
	  
	  else {
		  
		  System.out.println("String is not palindrome");
	  }
	  
	  
  }
}

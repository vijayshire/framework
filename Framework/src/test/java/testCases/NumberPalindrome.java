package testCases;

import java.util.Scanner;

import org.testng.annotations.Test;

public class NumberPalindrome {
  @Test
  public void f() {
	  
	  int num,i,sum =0,original,rev,r;
	  
	  System.out.println("Enter a number");
	  
	  Scanner input = new Scanner(System.in);
	  
	  num = input.nextInt();
	  
	  original = num;
	  
	  System.out.println(num);
	  
	  for(;num!=0;num/=10) {
		  
		  r=num%10;
		  sum=sum*10+r;
	  }
	  
	    if(original==sum) {
	    	
	    	System.out.println("Number is palindrome");
	    }
	    
	    else {
	    	
	    	System.out.println("Number is not Palindrome");
	    }
  }
}

package testCases;

import java.util.Scanner;

import org.testng.annotations.Test;

public class SumOfDigit {
  @Test
  public void f() {
	  
	  
	  int sum=0,num,i,r;
	  
	  System.out.println("Enter a Digit...");
	  Scanner input = new Scanner(System.in);
	  
	  num= Integer.valueOf(input.nextLine());
	  
	  for(;num!=0;num/=10) {
		  
		  r=num%10;
		  sum=sum+r;
	  }
	  
	  System.out.println("Sum of Digit is"+sum);
  }
}

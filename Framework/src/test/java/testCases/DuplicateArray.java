package testCases;

import org.testng.annotations.Test;

public class DuplicateArray {
  @Test
  public void f() {
	  
	  
	  String[] test = {"vijay","vijay","ajay","raj","rahul","ajay","raj","123","123"};
	  
	  int len = test.length,i,j;
	  
	  for(i=0;i<len;i++) {
	  for(j=i+1;j<len;j++) {
		  
	  if(test[i].equals(test[j])) {
		  
		System.out.println("Duplicate Strig is"+test[j]);
	  }
	  }
	  }
	  
  }
}

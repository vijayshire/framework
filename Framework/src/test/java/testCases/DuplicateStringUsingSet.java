package testCases;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

public class DuplicateStringUsingSet {
  @Test
  public void f() {
	  
	  String[] test = {"vijay","vijay","ajay","raj","rahul","ajay","raj","123","123"};
	  
	  ArrayList<String> al = new ArrayList<String>();
	  
	  
	  
	  for(String str:test) {
		  
		  if(al.contains(str)) {
			  
			  System.out.println("Duplicate String: "+str);
		  }
		  
		  else {
			  
			  al.add(str);
		  }
	  }
	  
	 
	  
	 
	  
  }
}

package com.test.methods.TestProjectSelenium;

public class Rhombus {
	

	public static void main(String[] args) {
	
		int i=0,j=0;
		
		for(i=1;i<=5;i++){
			
			for(j=0;j<i;j++){
						
				System.out.print("* ");
			
			}
			System.out.println(" ");
		}
		
     for(int k=1;k<=5;k++){
			
			for(int l=5;l>k;l--){
						
				System.out.print("*");
			
			}
			System.out.println(" ");
		}
	
     
     
//program to print a triangle
   int n=5;
     for(i=0;i<5;i++){
    	 
    	 for(j=n-i;j>1;j--){
    		 System.out.print(" ");
    	 }
    	 
    	 for(j=0;j<=i;j++){
    		 System.out.print("* ");
    	 }
    	 
    	 System.out.println(" ");
    	 
     }
     
for(i=3;i>=0;i--){
    	 
    	 for(j=n-i;j>1;j--){
    		 System.out.print(" ");
    	 }
    	 
    	 for(j=0;j<=i;j++){
    		 System.out.print("* ");
    	 }
    	 
    	 System.out.println(" ");
    	 
     }
     
	}

}

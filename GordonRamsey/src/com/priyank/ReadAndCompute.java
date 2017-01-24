package com.priyank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadAndCompute {

	
	//Utility function that returns maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }
      
   // Returns the maximum value of satisfaction that can be achieved in the Maximum Time i.e 10000 [Specified here]
    static int maxSatisfaction(int W, int wt[], int val[], int n)
    {
         int i, w;
         int K[][] = new int[n+1][W+1];
      
     //Build table K[][] in bottom up manner
     for (i = 0; i <= n; i++)
     {
         for (w = 0; w <= W; w++)
         {
             if (i==0 || w==0)
                  K[i][w] = 0;
             else if (wt[i-1] <= w)
                   K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
             else
                   K[i][w] = K[i-1][w];
         }
      }
      
      return K[n][W];
    }
  

	public static void main(String[] args) {
		 try{
			 	//File is kept at the working directory i.e Home Location
			 	BufferedReader buf = new BufferedReader(new FileReader("data.txt")); 
			 	ArrayList<String> words = new ArrayList<>();
	            ArrayList<String> words1 = new ArrayList<>();
	            
	            ArrayList<String> satisfaction = new ArrayList<>();
	            ArrayList<String> time = new ArrayList<>();
	            String lineJustFetched = null;
	            String[] wordsArray;
	            String[] wordsArray1;
	            ArrayList<Integer> listSatisfaction = new ArrayList<>();
	            ArrayList<Integer> listTime = new ArrayList<>();
	           	          	            	        
	            while(true){
	                lineJustFetched = buf.readLine();
	                if(lineJustFetched == null){  
	                    break; 
	                }else{
	                    wordsArray = lineJustFetched.split("\t");	                    
	                    	                		                    
	                    for(String each : wordsArray){	                    		                    		                   
	                        if(!"".equals(each)){	                        	
	                            words.add(each);	                       
	                        }
	                        
	                    }
	                }
	            }
	            	            	        
	            for(String each : words){	
	            	
	            	wordsArray1 = each.split(" ");	                    
                    
                    for(String each1 : wordsArray1){	                    		                    		                   
                        if(!"".equals(each1)){
                            words1.add(each1);
                       
                        }
	            }
	            }
	            
	            for(int j=0;j<words1.size();j++){
	            	if(j%2==0)
	            		satisfaction.add(words1.get(j));
	            	else
	            		time.add(words1.get(j));
	            }
	            
	            
	            
	            //Adding the values to the Integer List 
	            for(String ss : satisfaction){
	            	listSatisfaction.add(Integer.parseInt(ss));
	            }
	            
	            for(String ss1 : time){
	            	listTime.add(Integer.parseInt(ss1));
	            }
	            
	            
	            
	            Integer[] wrapperSatArray = listSatisfaction.toArray(new Integer[listSatisfaction.size()]);//satisfaction
	            Integer[] wrapperTimeArray = listTime.toArray(new Integer[listTime.size()]);//time
	            
	            //Converting from Wrapper type to Primitive type
	            int[] satisfactionArray = Arrays.stream(wrapperSatArray).mapToInt(Integer::intValue).toArray();
	            int[] timeArray = Arrays.stream(wrapperTimeArray).mapToInt(Integer::intValue).toArray();
	            
	            
	            int  MaxTime = 10000;              	//Maximum time
	            int n1 = satisfactionArray.length;  //Maximum no. of dishes
	            
	            System.out.println(maxSatisfaction(MaxTime,timeArray,satisfactionArray, n1));
	            
	            buf.close();
	            
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }

	}

}

class Practical9{

  public static void main(String[] args){
    long[] array = new long[10];
    long[] array2 = new long[10]; 
    long start =0;
    long end = 0;
    long factorial1time = 0;
    long factorial2time = 0;
    long value = 0;
    long stringBuilderTime = 0;
    long stringBufferTime = 0;
    long stringTime = 0; 
    
    for(int i=0; i<array.length; i++){
      array[i] = System.nanoTime()%20+1;
      array2[i] = array[i];
    }
    
    for(int i=0; i<array2.length; i++) {
      System.out.println(array2[i]);
    }
    
    for(int i=0; i<array.length; i++){
      start = System.nanoTime();
      value = factorial1(array2[i]); //function call for factorial for
      end = System.nanoTime();
      factorial1time = factorial1time + end - start;
      
      start = System.nanoTime();
      value = factorial2(array2[i]); //function call for factorial recursive
      end = System.nanoTime();
      factorial2time =factorial2time + end - start;
   }
   
   //here we compare both factorial (for and recursion)
   System.out.println("Timing for factorial (iteration) : " + factorial1time/array2.length);
   System.out.println("Timing for factorial (recursion) : " + factorial2time/array2.length);
   
//-----------------------------------------------------------------------------------------------
   for(int i=0; i<array.length; i++){
    // Function call for StringBuilder
      start = System.nanoTime();    
      stringBuilderTime = stringBuilder(array2);
      end = System.nanoTime();
      stringBuilderTime = stringBuilderTime + end - start;

    // Function call for StringBuffer
     start = System.nanoTime();
     stringBufferTime = stringBuffer(array2);
     end = System.nanoTime();
     stringBufferTime = stringBufferTime + end - start;
  }
  
    // Function call for String 
    start = System.nanoTime();
    stringAppend(array2);
    end = System.nanoTime();
    stringTime += end - start;
      
     //here we compare both StringBuilder and StringBuffer and stringTime 
    System.out.println("Timing for StringBuilder : " + stringBuilderTime/array2.length);
    System.out.println("Timing for StringBuffer : " + stringBufferTime/array2.length);  
    System.out.println("Timing for StringAppend : " + stringTime / array2.length);
}
  
//--------------------------------------------------------------------
  //function for factorial iteration
  public static long factorial1(long n){
        if(n<2){
            return 1;
        }
        long fact=n;
        for(;2<n;){
            //n--;
            fact*=--n;
        }
        return fact;
    }

//-------------------------------------------------------------------- 
  //function for factorial recursive
  public static long factorial2(long n){
        if(n<2){
            return 1;
        }
         long fact=factorial2(n-1);
         long fact_n=n*fact;
        return n*factorial2(n-1);
    }

//--------------------------------------------------------------------  
  //function for StringBuilder
  public static long stringBuilder(long[] array) {
    long start = System.nanoTime();
    StringBuilder sb = new StringBuilder();
    for (long num : array) {
      sb.append(num).append(" ");
    }
    long end = System.nanoTime();
    return end - start;
  }
  
//---------------------------------------------------------------------
  //function call for StringBuffer
  public static long stringBuffer(long[] array) {
    long start = System.nanoTime();
    StringBuffer sb = new StringBuffer();
    for (long num : array) {
      sb.append(num).append(" ");
    }
    long end = System.nanoTime();
    return end - start;
  }
  
// function call for StringAppend 
  public static void stringAppend(long[] array) {
    String str = "";
    for (long num : array) {
      str += num + " ";
    }
  
}
}

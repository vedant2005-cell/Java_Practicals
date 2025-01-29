class Pattern{

public static void main(String[] args){

int size = 3;
  displayPattern1(size);
   displayPattern2(size);
   displayPattern3(size);
}


public static void displayPattern1(int size){
  int space;
  for(int line = 1; line <= size ; line++ ){
    for( space = size-line; space>0; space--){
      System.out.print(" ");
    }
    for(int symbol = 2*line-1; symbol>0; symbol--){
      System.out.print("+");
    }
  System.out.println();
  }

  for(int line = size - 1; line > 0 ; line-- ){
    for( space = size - line; space > 0; space--){
      System.out.print(" ");
    }
    for(int symbol = 2*line-1; symbol>0; symbol--){
      System.out.print("+");
    }
  System.out.println();
  }
  System.out.println();
}

public static void displayPattern2(int size){
  int space;
  System.out.println();
for(int line = 1; line <= size ; line++ ){
      for( space = size-line; space>0; space--){
        System.out.print(" ");
      }
      for(int symbol = 2*line-1; symbol>0; symbol--){
        if(symbol % 2 == 0){
          System.out.print(" ");
        }
        else{
          System.out.print("+");
        }
      }
    System.out.println();
    }

for(int line = size - 1; line > 0 ; line-- ){
    for( space = size - line; space > 0; space--){
      System.out.print(" ");
    }
    for(int symbol = 2*line-1; symbol>0; symbol--){
        if(symbol % 2 == 0){
          System.out.print(" ");
        }
        else{
          System.out.print("*");
        }
    }
  System.out.println();
  }
  System.out.println();
}

public static void displayPattern3(int size){
int space;
  for(int line = 1; line <= size ; line++ ){
    for( space = size-line; space>0; space--){
      System.out.print(" ");
    }
    for(int symbol = 2*line-1; symbol>0; symbol--){
      if((symbol - line)%2 == 0){
      System.out.print("*");      
       }  
      else{     
      System.out.print("+");
      }
    }
  System.out.println();
  }
  
  for(int line = size ; line > 0 ; line-- ){
    for( space = size - line; space > 0; space--){
      System.out.print(" ");
    }
    for(int symbol = 2*line-1; symbol>0; symbol--){
      if((symbol - line)%2 == 0){
      System.out.print("+");      
       }  
      else{     
      System.out.print("*");
      }
    }
  System.out.println();
  }
  
  System.out.println();
  }
  
}



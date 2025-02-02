public class Name{

    public static void main(String[] args){
    Name obj = new Name();
    int  size =Integer.parseInt(args[0]);
    if(size<4) size=4;
    else if(size>24) size=24;
    //patterns to display
    for(int line=1;line<=size;line++){
      System.out.print(obj.printV(size,line));
      System.out.print("  ");
      System.out.print(obj.printE(size,line));
      System.out.print("  ");
      System.out.print(obj.printD(size, line));
      System.out.print("  ");
      System.out.print(obj.printA(size, line));
      System.out.print("  ");
      System.out.print(obj.printN(size, line));
      System.out.print("  ");
      System.out.print(obj.printT(size, line));
      System.out.println("  ");
      }
    }
     
    //Printing V
    String printV(int size, int line) {
      String pattern="";
        for (int column = 1; column <= size*2-1; column++) {
            if (column == line || column == (size * 2 - 1) - line+1) {
                //System.out.print("*");
                pattern+="*";
            } else {
                //System.out.print(" ");
                pattern+=" ";
            }
        }
        return pattern;
    }

    //Printing E
    String printE(int size,int line){
	    String pattern="";
		  for(int column=1;column<=size;column++)
		  {
			  if(column==1||line==1||line==size || line==size/2+1)		
			  
			  //System.out.print("*");
			  pattern+="*";
			  else
			  //System.out.print(" ");	
			  pattern+=" ";
		  }
		  return pattern;
    }

    //Printing D
    String printD(int size,int line) {
      String pattern="";
        for(int column=1;column<=size;column++){
            if(((line==1||line==size) & column!=size)||(column==1) || ((column==size)&((line!=1)&(line!=size)))) {
                //System.out.print("*");
                pattern+="*";
            }
            else{
                //System.out.print(" ");
                pattern+=" ";
            }
        }
        return pattern;
    }

    //printing A
    String printA(int size,int line){
      String pattern="";
      for(int column=1;column<=size;column++){
          if(((column==1||column==size) & line!=1)||(line==size/2+1)||(((line==1) & column!=size)&((line==1) & column!=1))){
              //System.out.print("*");
              pattern+="*";
          }	
          else{
              //System.out.print(" ");
              pattern+=" ";
          }
      }
      return pattern;
    }

    //printing N
    String printN(int size,int line){
      String pattern="";
        for(int column=1;column<=size;column++){
            if (column==1 || column==size || line==column ) {
                //System.out.print("*");
                pattern+="*";
            }
            else{
                //System.out.print(" ");
                pattern+=" ";
            }
        }
        return pattern;
    }
    
    //printing T
    String printT(int size,int line){
      String pattern="";
        for (int column = 0; column <=size; column++) {
            if (line==1 || column==size/2 ) {
                //System.out.print("*");
                pattern+="*";
            }
            else{
                //System.out.print(" ");
                pattern+=" ";
            }
        }
        return pattern;
    }
}

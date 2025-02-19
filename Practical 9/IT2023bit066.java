public class IT2023bit066 {
    //Implement the solution for Task 1
    public static String reverse(String inpuString){
        if (inpuString.isEmpty()) {
            return inpuString;
        }
        else{
        return reverse(inpuString.substring(1)) + inpuString.charAt(0);
        }
    }

    //Implement the solution for Task 2
    public static int sumofDigit(int number){
        if (number==0) {
            return 0;
        }

        return(number%10) + sumofDigit(number/10);
    }

    //Implement the solution for Task 3;
    public static boolean isPalindrome(String inputString1) {
        if (inputString1 == null || inputString1.length() <= 1) {
            return true; 
        }
    

        if (inputString1.charAt(0) != inputString1.charAt(inputString1.length() - 1)) {
            return false; 
        }

        return isPalindrome(inputString1.substring(1, inputString1.length() - 1));
    }
    
    public static void main(String[] args){
        String inpuString="Utsav 2025";
        System.out.println(reverse(inpuString));

        int number=170225;
        System.out.println(sumofDigit(number));

        String inpuString1 = "171";
        System.out.println(isPalindrome(inpuString1));

    }
}

class Practical4
{
// GETBYTE
public static byte getByte(int num) 
{
       byte result;
        int temp = num / 128;
    
       if (temp % 2 == 0) 
        {
            result = (byte) (num % 128); 
        } 
        else 
        {
            result = (byte) (num % 128 - 128);
        }
        
        return result;
    }
    
    
// GETSHORT
public static short getShort(int num) 
{
     short result;
      int temp = num / 32768;
     if (temp % 2 == 0) 
      {
          result = (short) (num % 32768);
      } 
      else  
      {
          result = (short) (num % 32768 - 32768);
      }
     return result;
     }
 
 
 
//GETVALUE BOTH GETBYTE AND GETSHORT
public static Number getValue(int num, String type) 
{
    if (type.charAt(0) == 's' || type.charAt(0) == 'S') 
    {
        if (type.charAt(1) == 'h' || type.charAt(1) == 'H') 
        {
            if (type.charAt(2) == 'o' || type.charAt(2) == 'O') 
            {
                if (type.charAt(3) == 'r' || type.charAt(3) == 'R') 
                {
                    if (type.charAt(4) == 't' || type.charAt(4) == 'T') 
                    {
                        return getShort(num); /
                    }
                }
            }
        }
    }
    else if (type.charAt(0) == 'b' || type.charAt(0) == 'B') 
    {
        if (type.charAt(1) == 'y' || type.charAt(1) == 'Y') 
        {
            if (type.charAt(2) == 't' || type.charAt(2) == 'T')
            {
                if (type.charAt(3) == 'e' || type.charAt(3) == 'E') 
                {
                    return getByte(num); 
                }
            }
        }
    }
    
    // EXCEPTION
    throw new IllegalArgumentException("Invalid type. Use 'short' or 'byte'.");
}




//BASE CONVERSION
public static String toXXSystem(String num, int targetSystem) 
{
    int decimal = 0;

    if (num.length() > 2 && num.charAt(0) == '0') 
    {
    //then it will check for char at index 1 of num
        char secondChar = num.charAt(1);
        
        if (secondChar == 'b') 
        { // num is Binary (0b)
            decimal = binaryToDecimal(num.substring(2));
        } 
        else if (secondChar == 'o') 
        { // num is Octal (0o)
            decimal = octalToDecimal(num.substring(2));
        } 
        else if (secondChar == 'x') 
        { //num is  Hexadecimal (0x)
            decimal = hexadecimalToDecimal(num.substring(2));
        } 
        else 
        { // num is Decimal, no prefix 
            decimal = Integer.parseInt(num);
        }
    } 
    else 
    { // Decimal (no prefix)
        decimal = Integer.parseInt(num);
    }

    // Convert the decimal to the target 
    switch (targetSystem) 
    {
        case 2: // target is Binary
            return decimalToBinary(decimal);
        case 8: // target  is Octal
            return decimalToOctal(decimal);
        case 10: //target is Decimal
            return Integer.toString(decimal);
        case 16: // target is Hexadecimal
            return decimalToHexadecimal(decimal);
        default:
            throw new IllegalArgumentException("Invalid target number system.");
    }

}
// method to convert decimal to binary
private static String decimalToBinary(int decimal) 
{
    String binary = "";
    while (decimal > 0) 
    {
        int remainder = decimal % 2;
        binary = remainder + binary;
        decimal = decimal / 2;
    }
    return binary.isEmpty() ? "0" : binary;
}

// method to convert decimal to octal
private static String decimalToOctal(int decimal) 
{
    // Check if the input is 0 ,if yes then return 0
    if (decimal == 0) 
    {
        return "0";
    }
    
    String octal = "";

    while (decimal > 0) 
    {
        octal = (decimal % 8) + octal;
        decimal /= 8;
    }
    return octal;
}

//method to convert decimal to hexadecimal
private static String decimalToHexadecimal(int decimal) 
{
    // checks if the input num is 0 ,if yes then return 0
    if (decimal == 0) 
    {
        return "0";
    }
    
    String hex = "";
    while (decimal > 0) 
    {
        int remainder = decimal % 16;
        String hexDigit = (remainder < 10) 
                          ? String.valueOf(remainder) 
                          : String.valueOf((char) ('A' + (remainder - 10)));
        hex = hexDigit + hex;
        decimal /= 16;
    }
    return hex;
}

//convert octal to decimal
private static int octalToDecimal(String octal) 
{

    int decimal = 0;
    int base = 1;
    while (octal.length() > 0) 
    {
        int lastDigit = octal.charAt(octal.length() - 1) - '0';
        decimal += lastDigit * base;
        base *= 8;
        octal = octal.substring(0, octal.length() - 1);
    }
    return decimal;
}

// conversion of octal to binary
private static String octalToBinary(String octal) 
{
    // Convert the octal number to its decimal form
    int decimal = octalToDecimal(octal);
    
    // Convert the decimal number to its binary form
    return decimalToBinary(decimal);
}

//convert octal to hexadecimal
private static String octalToHexadecimal(String octal) 
{
    int decimal = octalToDecimal(octal);
    return decimalToHexadecimal(decimal);
}


// conversion from binary to decimal
private static int binaryToDecimal(String binary) 
{
    int decimal = 0; 
    int base = 1;

    for (int i = binary.length() - 1; i >= 0; i--) 
    {
        int bit = binary.charAt(i) - '0';
        decimal += bit * base;
        base *= 2;
    }

    return decimal;
}

//conversion of binary to octal
private static String binaryToOctal(String binary) 
{
    //convert binary to decimal form
    int decimal = binaryToDecimal(binary);
    //convert decimal to octal form
    return decimalToOctal(decimal);
}

//conversion of binary to hexadecimal
private static String binaryToHexadecimal(String binary) 
{
   //convert binary to decimal form
   int decimal = binaryToDecimal(binary);
   //convert decimal num to hexadecimal form
   return decimalToHexadecimal(decimal);
}

//convertion of hexadecimal to decimal
private static int hexadecimalToDecimal(String hex) 
{
    int decimal = 0;
    int base = 1;
    for (int i = hex.length() - 1; i >= 0; i--) 
    {
        // Extract the current hexadecimal digit
        char digit = hex.charAt(i);
        
        int value = (digit >= '0' && digit <= '9') ? digit - '0' : digit - 'A' + 10;
        
        decimal += value * base;
    
        base *= 16;
    }
    
    // Return the calculated decimal value
    return decimal;
}

//conversion of hexadecimal to binary
private static String hexadecimalToBinary(String hex) 
{
    //convert hexadecimal number to decimal form
    int decimal = hexadecimalToDecimal(hex);
    //convert decimal number to binary form
    return decimalToBinary(decimal);
}

//conversion of hexadecimal to octal
private static String hexadecimalToOctal(String hex) 
{
   //convert hexadecimal number to decimal form
   int decimal = hexadecimalToDecimal(hex);
   //convert decimal to octal form
   return decimalToOctal(decimal);
}



}

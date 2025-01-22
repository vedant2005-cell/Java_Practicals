class Practical5 {
    public static void main(String[] args) {
        int n=7;
        Practical5 obj=new Practical5();
        int fact=obj.factorial1(n);
        int facts=obj.factorial2(n-1);
        int fact_n=obj.factorial3(n-2);
        System.out.println(fact);
        System.out.println(facts);
        System.out.println(fact_n);
    }
    
    int factorial1(int n){
        if(n<2){
            return 1;
        }
        int fact=n;
        for(;2<n;){
            //n--;
            fact*=--n;
        }
        return fact;
    }
    
    int factorial2(int n){
        if(n<2){
            return 1;
        }
        int fact=n;
        while(2<n){
            //n--;
            fact*=--n;
        }
        return fact;
    }
    
    int factorial3(int n){
        if(n<2){
            return 1;
        }
         int fact=factorial3(n-1);
         int fact_n=n*fact;
        return n*factorial3(n-1);
    }
        
    
    
}

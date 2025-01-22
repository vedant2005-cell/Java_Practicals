class ArraySum {
    public static void main(String[] args) {
        int[] array = {1,2};
        ArraySum obj=new ArraySum();
        int Sum = obj.getSum(array);
        System.out.println(Sum);
    }

    int getSum(int[] num) {
        return calculateSum(num, 0);
    }

   int calculateSum(int[] num, int index) {
        if (index == num.length) {
            return 0;
        }
        return num[index] + calculateSum(num, index + 1);
    }
}

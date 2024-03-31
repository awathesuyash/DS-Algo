



class HarshadNum
{
    public int sumOfTheDigitsOfHarshadNumber(int x) {

        int initNum=x;
        int sum=0;
        // 18
        while(x !=0)
        {
            int digit=x%10; // 8
            sum+=digit;  // 8
            x=x/10;  //1
        }

        //sum=9
        if(initNum % sum==0)
            return sum;
        return -1;
    }
    public static void main(String[] args) {
        int n=23;
        sumOfTheDigitsOfHarshadNumber(n);
    }
}
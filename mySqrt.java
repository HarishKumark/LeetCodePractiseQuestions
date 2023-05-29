class Solution {
    public int mySqrt(int number) {

        if(number<=1)
            return number;

        double temp;
        double sr = number / 2;
        do {
            temp = sr;
            sr = (temp + (number / temp)) / 2;
        } while ((temp - sr) != 0);

        return (int)sr;

    }
}

class Solution {
    public double myPow(double x, long n) {
        // Handle negative power
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        // Base cases
        if (n == 0) return 1;
        if (n == 1) return x;
        // Divide problem into half
        double halfPower = myPow(x, n / 2);
        // If n is even
        if (n % 2 == 0)
            return halfPower * halfPower;
        // If n is odd
        else
            return x * halfPower * halfPower;
    }
}
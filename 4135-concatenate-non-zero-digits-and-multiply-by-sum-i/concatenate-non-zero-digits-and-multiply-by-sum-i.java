class Solution {
    public long sumAndMultiply(int n) {
        long sumOfDigits = 0;
        long filteredNumber = 0;
        long placeValue = 1;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            if (digit != 0) {
                sumOfDigits += digit;
                filteredNumber = digit * placeValue + filteredNumber;
                placeValue *= 10;
            }
        }

        return filteredNumber * sumOfDigits;
    }
}
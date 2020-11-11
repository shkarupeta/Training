import java.math.BigInteger;

public class SumDigitsFromFactorial {

    public static void main(String[] args) {
        int countFactorial = 1000;
        System.out.println(sumDigits(calculateFactorial(countFactorial)));
    }

    /**
     * @param count factorial
     * @return result factorial, using BigInteger
     */
    private static BigInteger calculateFactorial(int count) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= count; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * @param inputNumber any number
     * @return sum digits from input number
     */
    private static int sumDigits(BigInteger inputNumber) {
        int sum = 0;

        while (BigInteger.valueOf(0).compareTo(inputNumber) < 0) {
            sum = sum + Integer.parseInt(String.valueOf(inputNumber.mod(BigInteger.valueOf(10))));
            inputNumber = inputNumber.divide(BigInteger.valueOf(10));
        }
        return sum;
    }
}

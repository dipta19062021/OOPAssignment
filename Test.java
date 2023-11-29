import java.util.Scanner;

// InvalidInputException.java
 class InvalidInputException extends Exception {
    private int inputValue;

    public InvalidInputException(int inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    public String toString() {
        return "InvalidInputException [" + inputValue + "]";
    }
}
class TestPrime {
    public static boolean isPrime(int number) throws InvalidInputException {
        if (number <= 1) {
            throw new InvalidInputException(number);
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// Test.java

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check if it's prime: ");
        int inputNumber = scanner.nextInt();

        try {
            boolean isPrime = TestPrime.isPrime(inputNumber);
            System.out.println(inputNumber + " is " + (isPrime ? "prime." : "not prime."));
        } catch (InvalidInputException e) {
            System.out.println("Exception caught: " + e);
        }
    }
}


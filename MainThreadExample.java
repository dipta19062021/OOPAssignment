
import java.util.Scanner;
class FactorialThread extends Thread {
    private int number;
    private long factorial;

    public FactorialThread(int number) {
        this.number = number;
        this.factorial = 1;
    }

    public long getFactorial() {
        return factorial;
    }

    @Override
    public void run() {
        factorial = calculateFactorial(number);
    }

    private long calculateFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

class FactorsThread extends Thread {
    private int number;

    public FactorsThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        calculateFactors(number);
    }

    private void calculateFactors(int n) {
        System.out.print("Factors of " + n + ": ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class MainThreadExample {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("The number is : " );
        int number=sc.nextInt() ;


        // Create threads
        FactorialThread factorialThread = new FactorialThread(number);
        FactorsThread factorsThread = new FactorsThread(number);

        // Start threads
        factorialThread.start();
        factorsThread.start();

        try {
            // Wait for threads to finish
            factorialThread.join();
            factorsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread prints results
        System.out.println("Factorial of " + number + ": " + factorialThread.getFactorial());

        // Main thread finishes last
        System.out.println("Main thread finished.");
    }
}

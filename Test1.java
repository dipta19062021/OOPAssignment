package myPackage;
import service.OperatorService;

public class Test1 {
    public static void main(String[] args) {
        OperatorService<String> operatorService = new OperatorService<>();

        // Enqueue customers
        operatorService.enqueue("Customer1");
        operatorService.enqueue("Customer2");
        operatorService.enqueue("Customer3");

        // Dequeue customers (simulate servicing)
        operatorService.dequeue(); // Customer1
        operatorService.dequeue(); // Customer2

        // Enqueue more customers
        operatorService.enqueue("Customer4");
        operatorService.enqueue("Customer5");

        // Dequeue remaining customers
        operatorService.dequeue(); // Customer3
        operatorService.dequeue(); // Customer4
        operatorService.dequeue(); // Customer5
        operatorService.dequeue(); // No customers in the queue
    }
}
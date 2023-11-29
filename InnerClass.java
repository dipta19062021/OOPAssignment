class DataStructure {
    private int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    void display() {
        System.out.print("\nThe array is : ");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        EvenIterator inner = new EvenIterator();
        inner.display();
    }

    private class EvenIterator {
        void display() {
            System.out.print("\nEvenIterator iterate through : ");
            for (int i = 0; i < 10; i++) {
                if (arr[i] % 2 == 0)
                    System.out.print(arr[i] + " ");
            }
        }
    }
}
public class InnerClass
{
    public static void main(String args[])
    {
        DataStructure outer = new DataStructure();
        //DataStructure.EvenIterator inner = outer.new EvenIterator(); //if inner class is not private
        outer.display();
        //inner.display();
    }
}
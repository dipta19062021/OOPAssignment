class Box{
    // Attributes
    private double length;
    private double width;
    private double height;

    // Default constructor
    public Box() {
        this.length = 1.0;
        this.width = 1.0;
        this.height = 1.0;
    }

    // Parameterized constructor with all dimensions
    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Parameterized constructor with a common dimension
    public Box(double side) {
        this.length = side;
        this.width = side;
        this.height = side;
    }

    // Method to display the volume of the box
    public void displayVolume() {
        double volume = length * width * height;
        System.out.println("Volume of the box: " + volume);
    }
}
public class Demo {
        public static void main(String[] args) {
            // Creating objects of the Box class using different constructors
            Box box1 = new Box(); // Default constructor
            Box box2 = new Box(2.0, 3.0, 4.0); // Parameterized constructor with all dimensions
            Box box3 = new Box(5.0); // Parameterized constructor with a
                                         // common dimension

            // Displaying volumes
            System.out.println("Volume of Box 1:");
            box1.displayVolume();
            System.out.println();

            System.out.println("Volume of Box 2:");
            box2.displayVolume();
            System.out.println();

            System.out.println("Volume of Box 3:");
            box3.displayVolume();
        }
}

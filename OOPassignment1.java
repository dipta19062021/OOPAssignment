class Person{
    // Attributes
    private String name;
    private int age;
    private String address;

    // Constructor
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Method to show biodata
    public void showBiodata() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

    // Main method to demonstrate the class
    public class OOPassignment1 {

        public static void main(String[] args) {
            // Creating objects of the Person class
            Person person1 = new Person("John Doe", 25, "123 Main St, Cityville");
            Person person2 = new Person("Lucy Han", 32, "321 Oak St, Townsville");

            // Displaying biodata
            System.out.println("Biodata for Person 1:");
            person1.showBiodata();
            System.out.println();

            System.out.println("Biodata for Person 2:");
            person2.showBiodata();
        }
    }











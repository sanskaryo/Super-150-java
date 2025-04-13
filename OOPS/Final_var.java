public class Final_var {


    final int age = 20;
    final String name = "Ravi";

    // public Final_var() {
    //     // Constructor
    //     this.age = 30; // Error: Cannot assign a value to final variable age
    // }

    // public static void main(String[] args) {
    //     Final_var obj = new Final_var();
    //     System.out.println(obj.age);
    //     System.out.println(obj.name);
    // }

    public final void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }  // final class cannot be inherited
    // public void display() { // Error: Cannot override the final method from Final_var


}
public class Interface_class implements Interface1 {
    // Implementing the abstract method from the interface
    @Override
    public void push() {
        System.out.println("Push method implemented in Interface_class.");
    }
    
    // Implementing the abstract method from the second interface
    @Override
    public void pull() {
        System.out.println("Pull method implemented in Interface_class.");
    }
    
    public static void main(String[] args) {
        Interface_class obj = new Interface_class();
        obj.push(); // Calls the push method
        obj.pull(); // Calls the pull method
    
}

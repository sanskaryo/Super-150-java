public class Person_client {

    public static void main(String[] args) {
        System.out.println("Hey");
        person p = new person("ravi", 20);
        person p1 = new person("raj", 19);

        p1.setAge(-18);
        System.out.println(p1.getAge());

    // person p = new person();
    // System.out.println(p.age);
    // System.out.println(p.name);
    
}
}
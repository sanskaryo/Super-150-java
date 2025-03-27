public class Styudent_client {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "kaju";
        s.age = 17;
        s.Intro_yourself();


        Student s1 = new Student();
        s1.name = "raj";
        s1.age = 19;
        s1.Intro_yourself();
        s1.SayHey(s.name);
        
    }

    static {
        System.out.println("I am a Student");
    }
}

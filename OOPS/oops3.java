public class oops3 {

    private String name = "kaju";
    private int age = 17;

    public oops3(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public static void main(String[] args) {
        try {
            oops3 student = new oops3("raj", 19);
            System.out.println(student.getAge());
            student.setAge(-9);
            System.out.println(student.getAge());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
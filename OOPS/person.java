public class person {

    private String name = "ravi";
    private int age = 20;

    public person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age<0){
            throw new Exception("Age cannot be negative");
        }
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    
}

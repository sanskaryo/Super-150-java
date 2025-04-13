public  Interface Interface1 {
    // Interface cannot have constructor
    // public Interface1(){
    //     System.out.println("Hello from interface constructor");
    // }
    

    public void push(int item);

    public int peek();

    // java 8 
    public default void fun(){
        System.out.println("Hello from interface class");
    }

    //java 9

    private static void fun1(){
        System.out.println("Hello from interface class fun1 method");
    }
    // int d = 1;
    // int d1 = 10;
    
    // public void fun(){
    //     System.out.println("Hello from interface class");
    // }
    
    // public void fun1(){
    //     System.out.println("Hello from interface class fun1 method");
    // }
    
}

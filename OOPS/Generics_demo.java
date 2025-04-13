public class Generics_demo {
    

    public static void main(String[] args) {
        
Integer arr[] = {1, 2, 3, 4, 5};
        String str[] = {"Hello", "World", "Generics"};
        
        // Calling the generic method with Integer array
        printArray(arr);
        
        // Calling the generic method with String array
        printArray(str);
        
    }

    public static <T> void printArray(T[] arr) {  // <> k andar kuch bhi likho
        for (T element : arr) {
            System.out.println(element);
        }
        System.out.println();

    }
}

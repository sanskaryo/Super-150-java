public class func5 {

    public static void main(String[] args) {
        int [] arr = {2,4,6,7,32,6};
        int item = 4;
        System.err.println("Index of the item is: "+Search(arr,item));
    }

    public static int Search(int[] arr, int item) {
        for(int i=0;i<arr.length;i++){
            if(arr[i] == item){
                return i;
            }
        }
        return -1;
    }
    
}

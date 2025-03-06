
public class queue1 {

    private int[] arr;
    private int front=0;
    private int size =0;

    public queue1(){
        arr = new int[5];

    }

    public queue1(int n ){
        arr = new int[n];
    }
    public boolean Isempty() {
        return size ==0;

    }

    public void Equeue(int item){
        int idx = front + size;
        arr[idx] = item ;
        size++;
    }
    public int dequeue(){
        int rv = arr[front];
        front=(front+1)%arr.length;
        size--;
        return rv;

    }
    public int size(){
        return size;
    }
    public int getfront(){
        int rv = arr[front];
        return rv;

    }
    public boolean isfull(){
        return size == arr.length;
    }
    public void Display() {
        for(int i=0;i<size;i++){
            int idx = (front+i)% arr.length;
            System.out.print(arr[idx]+ " ");
        }
        System.out.println();
    }
}

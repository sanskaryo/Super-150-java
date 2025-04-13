package OOPS;

public class Linked_List<T> {

        class Node{
            T val;
            Node next;
        }
        private Node head;
        private Node tail;
        private int size;
    
        public void AddFirst(T item){
            Node nn =  new Node();
            nn.val=item;
            if(size==0){
                head=nn;
                tail=nn;
                size++;
            }else{
                nn.next=head;
                head=nn;
                size++;
            }
        }
    
        public void AddLast(T item){
            if(size==0){
                AddFirst(item);
            }else{
                Node nn =  new Node();
                nn.val=item;
                tail.next=nn;
                tail=nn;
                size++;
            }
        }
        public void Display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.val + "--->");
                temp=temp.next;
            }
            System.out.println(".");
        }
        public void Addat_index(T item,int k) throws Exception{
            if(k==0){
                AddFirst(item);
            }else if(k==size){
                AddLast(item);
            }else{
                Node nn = new Node();
                nn.val=item;
                Node prev = getNode(k-1);
                nn.next=prev.next;
                prev.next=nn;
                size++;
            }
        }
        private Node getNode(int k) throws Exception{
            if(k<0 || k>=size){
                throw new Exception("Baklol k range mein nahi hai");
            }
            Node temp=head;
            for(int i=0;i<k;i++){
                temp=temp.next;
            }
            return temp;
        }
    
        public T getFirst(){
            return head.val;
    
        }
        public T getLast(){
            return tail.val;
            
        }
        public T get_at_index(int k)throws Exception{
            return getNode(k).val;
        }
        public T removeFirst(){
            T val=head.val;
            if(size==1){
                head=null;
                tail=null;
                size=0;
            }else{
                Node temp=head;
                head=head.next;
                temp.next=null;
                size--;
            }
            return val;
        }
        public T removeLast()throws Exception{
            if(size==1){
                return removeFirst();
            }else{
                T val=tail.val;
                Node sl=getNode(size-2);
                tail=sl;
                tail.next=null;
                size--;
                return val;
            }
        }
        public T remove_at_index(int k) throws Exception{
            if(k==0){
                return removeFirst();
            }else if(k==size-1){
                return removeLast();
            }else{
               Node prev = getNode(k-1);
               Node curr = getNode(k);
               prev.next=curr.next;
               curr.next=null;
               size--;
               return curr.val;
            }
        }
    }
package Hashmap_ques;

public class ques1 {

    static class MyhashMap<K, V> {
        public static final int DEFAULT_CAPACITY =4;
        public static final float DEAFULT_LOAD_FACTOR =4;

        private  class Node {


        }

       private int n; 

       private LinkedList<Node> [] buckets;

       private void initBuckets(int N){
        buckets = new LinkedList[N];
        for(int i=0;i<buckets.length;i++){
            buckets[i] = new LinkedinList<>();

        }
        private int Hashfunc(K key){
            int hc = key.hashcode();
            return (Math.abs(hc)) % buckets.length;
        }
       }

       private int searhInBuckets(LinkedList<Node> ll, K key){
            for(int i=0; i<ll.size() ;i++){
                if(ll.get())
            }
       }

       public MyHashMap (){

        initBuckets(DEFAULT_CAPACITY);
       }
        public void put(K key , V Value){
             int bi = Hash

        }

        public int size(){
            return n;
        }

        public void put(k key, V value){
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei != -1){
                Node node= new Node(key,value);
                currBucket.add(node);
                n++;
            }else{
                Node currNode = currBucket.get(ei);
                currNode.value = value;
            }
        }
        public V get(K key){
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchBucket (currBucket,key);
            if(ei!= -1){
                Node currNode = currBucket.get(ei);
                return currnode.value;
            } else {
                return null;
            }
        }

    }
    public static void main(String[] args) {


    }
}

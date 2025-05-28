public class Cycle_removal {
    private class Node {
        int val;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;


    public void addLast(int item) {
        Node nn = new Node();
        nn.val = item;
        if (size == 0) {
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
        size++;
    }

    private Node getNode(int k) {
        Node temp = head;
        for (int i = 0; i < k && temp != null; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void CreateCycle() {
        if (tail != null) {
            tail.next = getNode(2); // Create a cycle by linking tail to the 3rd node (index 2)
        }
    }

    public void Display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next; // Advance to next node
        }
        System.out.println(".");
    }

    // Detects a cycle and returns the starting node of the cycle if present, or null otherwise.
    public Node hasCycle() {
        Node fast = head;
        Node slow = head;

        // Step 1: Detect cycle using Floyd's Cycle Finding algorithm.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // Cycle detected
                break;
            }
        }

        // No cycle detected if fast reached the end.
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the starting node of the cycle.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // Both pointers now point to the starting node of the cycle.
        return slow;
    }

    public void CycleRemove2 (){

        Node meet = hasCycle();
        if(meet == null){
            return;
        }
        int c = 1;
        Node temp = meet;
        while (temp.next != meet) {
            c++;
            temp = temp.next;
        }
    }
    public static void main(String[] args) throws Exception {
        Cycle_removal cl = new Cycle_removal();
        cl.addLast(1);
        cl.addLast(2);
        cl.addLast(3);
        cl.addLast(4);
        cl.addLast(5);
        cl.addLast(6);
        cl.addLast(7);
        cl.addLast(8);

        // Uncomment the line below to create a cycle for testing.
        // cl.CreateCycle();

        cl.Display();

        Node cycleStart = cl.hasCycle();
        if (cycleStart != null) {
            System.out.println("Cycle detected at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
class Node {
    int val;
    Node next;

    public Node(int val) {
        this(val, null);
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MyHashSet {

    Node head;
    Node tail;

    public MyHashSet() {
        this.head = new Node(-1);
        this.tail = this.head;
    }
    
    public void add(int key) {
        if(contains(key)) {
            return;
        }

        Node newNode = new Node(key);
        this.tail.next = newNode;
        this.tail = newNode;
    }
    
    public void remove(int key) {
        Node curr = this.head.next;
        Node prev = this.head;
        Node next = null;

        while(curr!=null) {
            next = curr.next;

            if(curr.val == key) {
                if(curr.next == null) {
                    this.tail = prev;
                }
                prev.next = curr.next;
                curr.next = null;
                curr = null;
                continue;
            }

            prev = curr;
            curr = next;
        }
    }
    
    public boolean contains(int key) {
        Node curr = this.head.next;

        if(curr == null) {
            return false;
        }

        while(curr != null) {
            if(curr.val == key) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
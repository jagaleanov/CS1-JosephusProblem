package josefus;

public class Node {
    private String data;
    private Node next;
    
    public Node(String info) {
        this.data = info;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


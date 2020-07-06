package josephus;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ListOperations {

    JTextArea areaOut;

    public ListOperations(JTextArea area) {
        this.areaOut = area;
    }

    public Node findTail(Node head) {
        Node tail = head;

        if (head != null) {
            while (tail.getNext() != head) {
                tail = tail.getNext();
            }
        }

        return tail;
    }

    public Node enQueue(Node head, String data) {

        if (head != null) {
            Node tail = findTail(head);

            Node newNode = new Node(data);
            newNode.setNext(head);

            tail.setNext(newNode);
        } else {
            Node newNode = new Node(data);
            newNode.setNext(newNode);
            head = newNode;
        }

        return head;
    }

    public Node deQueue(Node head) {
        if (head.getNext() != head) {

            Node dequeued = head;
            Node next = head.getNext();
            Node tail = findTail(head);

            head = next;
            tail.setNext(head);

            areaOut.append("Sacando de la cola a " + dequeued.getData() + "\n");
            System.out.println("Sacando de la cola a " + dequeued.getData());

            return head;
        } else {
            return null;
        }
    }

    public void josephus(Node head, int steps) {
        areaOut.append("Iniciando Josephus con ciclo de " + steps + " pasos\n");
        //System.out.println("Iniciando Josephus con ciclo de " + size);
        while (!head.getNext().equals(head)) {
            Node selected = head;

            for (int i = 0; i < steps - 1; i++) {
                selected = selected.getNext();
            }

            head = deQueue(selected);
            print(head);
        }

        JOptionPane.showMessageDialog(null, "El ganador es: " + head.getData());
        areaOut.append("PROCESO FINALIZADO\n");
        areaOut.append("El ganador es: " + head.getData());
        //System.out.println("finalizado " + head.getData());
    }

    public void print(Node head) {
        Node q = head;

        if (q != null) {
            do {
                areaOut.append(q.getData() + " ");
                System.out.print(q.getData() + " ");
                q = q.getNext();
            } while (q != head);
        }

        areaOut.append("\n");
        System.out.println();
    }

    public String listToString(Node head) {
        String string = "";
        Node q = head;

        if (q != null) {
            string += q.getData();
            q = q.getNext();

            while (q.getData() != head.getData()) {
                string += q.getData();

                q = q.getNext();
            }
        }

        return string;
    }
}

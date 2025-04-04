import interfaces.ILinkedList;

public class ExampleLinkedList implements ILinkedList {
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head = null;

    public ExampleLinkedList() {
        this.head = null;
    }

    public void addLast(int value) {
        if (this.head == null) {
            this.head = new Node(value);
            return;
        }

        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(value);
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void insert(int value, int index) {
        if (this.head == null) {
            return;
        }
        if (index < 0) {
            return;
        }
        if (index >= length()) {
            return;
        }

        Node parent = null;
        Node current = this.head;
        for (; index != 0; index -= 1) {
            parent = current;
            current = current.next;
        }

        Node newNode = new Node(value);

        if (parent == null) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            newNode.next = current;
            parent.next = newNode;
        }
    }

    public Integer get(int index) {
        if (index < 0) {
            return null;
        }
        if (index >= length()) {
            return null;
        }

        Node current = this.head;
        for (; index != 0; index -= 1) {
            current = current.next;
        }
        return current.value;
    }

    public Integer removeLast() {
        if (this.head == null) {
            return null;
        }

        Node parent = null;
        Node current = this.head;

        while (current.next != null) {
            parent = current;
            current = current.next;
        }

        if (parent == null) {
            this.head = null;
        } else {
            parent.next = null;
        }
        return current.value;
    }

    public Integer removeFirst() {
        if (this.head == null) {
            return null;
        }
        Node node = this.head;
        this.head = node.next;
        return node.value;
    }

    public Integer remove(int index) {
        if (index < 0) {
            return null;
        }
        if (index >= this.length()) {
            return null;
        }

        Node parent = null;
        Node current = this.head;

        for (; index != 0; index -= 1) {
            parent = current;
            current = current.next;
        }

        if (parent == null) {
            this.head = current.next;
        } else {
            parent.next = current.next;
        }

        return current.value;
    }

    public int length() {
        int length = 0;
        Node current = this.head;
        while (current != null) {
            length += 1;
            current = current.next;
        }
        return length;
    }

}

public class task1 {
    private Node head;
    private Node tail;


    private class Node {
        private Node next;
        private int value;
        private Node prev;
    }

//    public void addFirst(int value) {
//        Node node = new Node();
//        node.value = value;
//        node.next = head;
//        head = node;
//    }
//
//    public void removeFirst() {
//        if (head != null) {
//            head = head.next;
//        }
//    }
//
//    public Node findNode(int value) {
//        Node node = head;
//        while (node != null) {
//            if (node.value == value) {
//                return node;
//            }
//            node = node.next;
//        }
//        return null;
//    }
//
//    public void addLast(int value) {
//        Node node = new Node();
//        node.value = value;
//        if (head == null) {
//            head = node;
//        } else {
//            Node last = head;
//            while (last.next != null) {
//              last = last.next;
//            }
//            last.next = node;
//        }
//    }
//
//    public void removeLast() {
//        if (head != null) {
//            Node node = head;
//            while (node.next != null) {
//                if (node.next.next == null) {
//                    node.next = null;
//                    return;
//                }
//                node = node.next;
//            }
//            head = null;
//        }
//    }
//
//    public void Add(int value) {
//        Node node = new Node();
//        node.value = value;
//        if (head != null) {
//            node.next = head;
//            head.prev = node;
//        } else {
//            tail = node;
//        }
//        head = node;
//
//    }
//
//    public void Remove() {
//        if (head != null && head.next != null) {
//            head = head.next;
//            head.prev = null;
//        }
//        head = null;
//        tail = null;
//    }
//
//    public void AddAny(int value, Node node) {
//        Node next = node.next;
//
//        Node newNode = new Node();
//        newNode.value = value;
//
//        node.next = newNode;
//        newNode.prev = node;
//        if (next == null) {
//            tail = newNode;
//        } else {
//            next.prev = newNode;
//            newNode.next = next;
//        }
//
//    }

    public void reverse() {
        Node node = head;
        while (node != null) {
            Node next = node.next;
            Node prev = node.prev;
            node.next = prev;
            node.prev = next;
            if (prev == null) {
                tail = node;
            }
            if (next == null) {
                head = node;
            }
            node = node.next;
        }
    }
}

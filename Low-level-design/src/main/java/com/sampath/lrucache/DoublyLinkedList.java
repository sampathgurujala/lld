package com.sampath.lrucache;

public class DoublyLinkedList<K,V>{
    private final Node head= new Node(null,null);
    private final Node tail=new Node(null,null);
    public DoublyLinkedList()
    {
        head.next = tail;
        tail.prev= head;
    }

    public void remove(Node<K,V> node)
    {
            node.prev.next = node.next;
            node.next.prev=node.prev;
    }
    public void insertAtEnd(Node node)
    {
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev= node;
        node.next = tail;

    }
    public Node<K,V> getLRUNode() {

        if (head.next != tail)
            return head.next;
        return null;
    }
}

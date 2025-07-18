package com.sampath.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache <K,V>{
    private final int capacity;
    private final Map<K,Node<K,V>> map;
    private final DoublyLinkedList<K,V> dll;
     public LRUCache(int capacity)
     {
         this.capacity = capacity;
         map = new HashMap<>();
         dll = new DoublyLinkedList<>();
     }

     public synchronized V get(K k)
     {
         if(map.containsKey(k))
         {
             Node<K,V> node = map.get(k);
             dll.remove(node);
             dll.insertAtEnd(node);
             return map.get(k).val;
         }
         return null;
     }
     public synchronized void put(K k,V v)
     {
        if(map.containsKey(k))
        {
            Node<K,V>  node = map.get(k);
            node.val = v;
            dll.remove(node);
            dll.insertAtEnd(node);
            return;
        }
        Node<K,V> newNode =new Node<>(k,v);
        if(map.size()==capacity)
        {
            Node<K,V> toRemove = dll.getLRUNode();
            map.remove(toRemove.key);
            dll.remove(toRemove);
        }
         dll.insertAtEnd(newNode);
         map.put(k,newNode);
         return;
     }
}

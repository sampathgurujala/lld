package com.sampath.lrucache;

public class LRUCacheDemo {
   public static void main(String[] args)
   {
       LRUCache<Integer,Integer> lruCache = new LRUCache<>(3);
       lruCache.put(1,1);
       lruCache.put(2,2);
       lruCache.put(3,3);
       Integer val = lruCache.get(1);
       System.out.println("Key =: 1 |"+" Value : "+val);
       lruCache.put(4,4);
         val = (lruCache.get(2));
       System.out.println("Key =: 1 |"+" Value(if key doesn't exists prints -1) : "+((val==null)?-1:val));

   }
}

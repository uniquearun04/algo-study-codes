package com.study.coursera.algo.assignments.ass2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

 // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item>{
        
        private Node<Item> current = head;
        
        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Item next() {
            if(size == 0){
                throw new NoSuchElementException();
            }
            //TODO check if something goes wrong here and if yes use this tmp variable to do intermediate assignments.
//            Node<Item> tmp = current.next;
            
            Item item = current.data;
            current = current.next;
            
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
    }
    
    private int size = 0;
    private Node<Item> head;
    private Node<Item> tail;
    // construct an empty deque
    public Deque(){
        this.head = new Node<Item>();
        this.tail = head;
        size = 0;
    }
    
    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }
    // return the number of items on the deque
    public int size(){
        return size;
    }
    // insert the item at the front
    public void addFirst(Item item){
        if(item == null){
            throw new NullPointerException();
        }
        Node<Item> first = new Node<Item>(item);
        if(this.size <= 0){
            this.head = first;
            this.tail = first;
        } else {
            first.next = this.head;
            this.head = first;
        }
        
        this.size++;
    }
    // insert the item at the end
    public void addLast(Item item){
        Node<Item> last = new Node<Item>(item);
        if(this.size <= 0){
            this.head = last;
            this.tail = last;
        } else {
            this.tail.next = last;
            this.tail = last;
        }
        
        this.size++;
    }
    // delete and return the item at the front
    public Item removeFirst(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        Node<Item> removed = this.head;
        removed.next = null;
        removed.prev = null;
        this.head = this.head.next;
        size--;
        return removed.data;
    }
    // delete and return the item at the end
    public Item removeLast(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        Node<Item> removed = this.tail;
        Node<Item> prev = this.tail.prev;
        
        removed.next = null;
        removed.prev = null;
        
        this.tail = prev;
        
        return removed.data;
    }
    // unit testing
    public static void main(String[] args){
        
    }
    
/*    class Node<Item>{
        Node<Item> next;
        Node<Item> prev;
        Item data;
        
       public Node(){
            this.next = null;
            this.prev = null;
            this.data = null;
        }
        
       public Node(Item data){
           this.next = null;
           this.prev = null;
           this.data = data;
       }
//       public String toString(){
//            
//        }
    }*/

}

class Node<Item>{
    Node<Item> next;
    Node<Item> prev;
    Item data;
    
   public Node(){
        this.next = null;
        this.prev = null;
        this.data = null;
    }
    
   public Node(Item data){
       this.next = null;
       this.prev = null;
       this.data = data;
   }
//   public String toString(){
//        
//    }
}


import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
    
    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
    
    private Node<Item> head;
    private Node<Item> tail;
    
    private int size = 0;
    
//    private Item[] queueData = null;
    
    // construct an empty randomized queue
    public RandomizedQueue(){
//        this.head = new Node<Item>();
//        this.tail = head;
//        queueData = (Item[])new Object[0];
    }
    // is the queue empty?
    public boolean isEmpty(){
        return size == 0;
    }
    // return the number of items on the queue
    public int size(){
        return size;
    }
    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        Node<Item> last = new Node<Item>(item);

        last.next = null;
        last.prev = this.tail;
        if (isEmpty()) {
            this.head = last;
        } else if (this.tail != null) {
            this.tail.next = last;
        }
        this.tail = last;

        this.size++;

    }
    
    
    // delete and return a random item
    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int ri = StdRandom.uniform(size);
        
        Node<Item> current = this.head;
        
        for(int i = 0; i < ri; i++){
            current = current.next;
        }
        
        Node<Item> removed = current;
        
        if(current.next != null){
            current.next.prev = current.prev;
        } else {
            this.tail = current.prev;
        }
        if(current.prev != null){
            current.prev.next = current.next;
        } else {
            this.head = current.next;
        }
        if(current.next == null && current.prev == null){
            this.head = null;
            this.tail = null;
        }
        size--;
        return removed.data;
    }
    // return (but do not delete) a random item
    public Item sample(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        int ri = StdRandom.uniform(size);
        
        Iterator<Item> it = this.iterator();
        
        for(int i = 0; i < ri; i++){
            it.next();
        }
        
        return it.next();
    }
    // unit testing
    public static void main(String[] args){

    }
    
    
    private class RandomizedQueueIterator implements Iterator<Item>{

        private Node<Item> current = head;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(current == null){
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

}

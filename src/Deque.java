

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
    
    private int size = 0;
    private Node<Item> head;
    private Node<Item> tail;
    // construct an empty deque
    public Deque(){
//        this.head = new Node<Item>();
//        this.tail = head;
//        size = 0;
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

        first.next = this.head;
        first.prev = null;
        
        if(this.head != null){
            this.head.prev = first;
        } else {
            this.tail = first;
        }
        
        this.head = first;
        
        this.size++;
    }
    // insert the item at the end
    public void addLast(Item item){
        if(item == null){
            throw new NullPointerException();
        }
        Node<Item> last = new Node<Item>(item);
        
        last.next = null;
        last.prev = this.tail;
        if(isEmpty()){
            this.head = last;
        } else if(this.tail != null){
            this.tail.next = last;
        }
        this.tail = last;
        
        this.size++;
    }
    // delete and return the item at the front
    public Item removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<Item> removed = this.head;

        this.head = this.head.next;
        if(this.head != null){
            head.prev = null;
        }
/*        if(size == 1){
            this.head = null;
            this.tail = null;
        } else{
            this.head = this.head.next;
            this.head.prev = null;
        }*/
        size--;
        if(isEmpty()){
            this.tail = null;
        }
//        removed.next = null;
//        removed.prev = null;
        
        return removed.data;
    }
    // delete and return the item at the end
    public Item removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<Item> removed = this.tail;

/*        if(size == 1){
            this.tail = null;
            this.head = null;
        } else {
            Node<Item> prev = this.tail.prev;
            this.tail = prev;
            this.tail.next = null;
        }*/
        this.tail = this.tail.prev;
        if(this.tail != null){
            this.tail.next = null;
        }
        size--;
        
        if(isEmpty()){
            this.head = null;
        }
        return removed.data;
    }
    // unit testing
    public static void main(String[] args){
        
        Deque<String> dq = new Deque<String>();
        dq.addFirst("AA");
//        Iterator<String> iterator = dq.iterator();
//        String string1 = iterator.next();
        
//        dq.addFirst("BB");
//        Iterator<String> iterator2 = dq.iterator();
//        String string2 = iterator2.next();
        
//        dq.addFirst("CC");
//        Iterator<String> iterator3 = dq.iterator();
//        String string3 = iterator3.next();
        
//        dq.addFirst("DD");
//        Iterator<String> iterator4 = dq.iterator();
//        String string4 = iterator4.next();
        
//        dq.addFirst("EE");
        
        Iterator<String> iterator5 = dq.iterator();
        String string5 = iterator5.next();
        String string = iterator5.next();
        String string6 = iterator5.next();
        String string7 = iterator5.next();
        String string8 = iterator5.next();
        String next = iterator5.next();
        
        
        
        
        String removeFirst = dq.removeFirst();
        String removeFirst2 = dq.removeFirst();
        String removeFirst3 = dq.removeFirst();
        String removeFirst4 = dq.removeFirst();
        String removeFirst5 = dq.removeFirst();
        dq.addFirst("EER");
        String removeLast = dq.removeLast();
        String removeLast2 = dq.removeLast();

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
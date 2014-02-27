package com.study.coursera.algo.assignments.ass2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.study.coursera.algo.lib.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
    
    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
    
    private Node<Item> head;
    private Node<Item> tail;
    
    private int size = 0;
    
    private Item[] queueData = null;
    
    // construct an empty randomized queue
    public RandomizedQueue(){
        this.head = new Node<Item>();
        this.tail = head;
        queueData = (Item[])new Object[0];
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
    public void enqueue(Item item){
        if(item == null){
            throw new NullPointerException();
        }
        
        Node<Item> tmp = new Node<Item>(item);
        if(size == 0){
            this.head = tmp;
            this.tail = head;
        } else {
            this.tail.next = tmp;
            tmp.prev = this.tail;
            this.tail = this.tail.next;
        }
        
        size++;
        
/*        if(size == queueData.length){
            Item[] queueDataTmp = (Item[])new Object[2 * size];
            for(int i = 0; i < size; i ++){
                queueDataTmp[i] = queueData[i];
            }
            queueData = queueDataTmp;
        }*/
        
        
    }
    // delete and return a random item
    public Item dequeue(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        int ri = StdRandom.uniform(size);
        
        Node<Item> current = this.head;
        
        for(int i = 0; i < ri; i++){
            current = current.next;
        }
        
        Node<Item> removed = current;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        removed.next = null;
        removed.prev = null;
        
        
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
            // TODO Auto-generated method stub
            return size > 0;
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
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
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException();
        }
        
    }

}

package com.study.coursera.algo.assignments.ass2;

import com.study.coursera.algo.lib.StdIn;
import com.study.coursera.algo.lib.StdOut;

public class Subset {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int k = Integer.parseInt(args[0]);
        
        String line = StdIn.readLine();
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        
        String[] strings = line.split(" ");
        for(int i = 0; i < strings.length; i++){
            rq.enqueue(strings[i]);   
        }
        
        for(int i = 0; i < k; i++){
            String randomSample = rq.sample();
            StdOut.println(randomSample);
        }
    }

}

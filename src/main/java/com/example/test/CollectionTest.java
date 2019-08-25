package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionTest {
	
	
	public static void testArrayList(){
		List<Integer> arrayList = new ArrayList<>(); 
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3); 
		arrayList.add(4); 
		arrayList.add(5);
		arrayList.remove(2);//根据下标移除数据
		arrayList.add(2, 123123); 
		for (Integer i:arrayList) {
			System.out.print(i+" "); 
		}
	}
	
	public static void testVectorList(){
		Vector<Integer> vectorList = new Vector<>(); 
		vectorList.add(1);
		vectorList.add(2);
		vectorList.add(3); 
		vectorList.add(4); 
		vectorList.add(5);
		vectorList.remove(2);//根据下标移除数据
		vectorList.add(2, 123123); 
		for (Integer i:vectorList) {
			System.out.print(i+" "); 
		}
		
		
	}
	
	
	public static void testLinkArrayList(){
		List<Integer> linkedList = new LinkedList<>();
		linkedList.add(1); 
		linkedList.add(2); 
		linkedList.add(3); 
		linkedList.add(4); 
		linkedList.add(5); 
		linkedList.remove(2); 
		linkedList.add(2, 123123); 
		for (Integer i:linkedList) { 
			System.out.print(i+" ");
		}
	}
	
	
	public static void testFastList(){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        // ArrayList add
        long startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ArrayList add:  " + duration);

        // LinkedList add
        startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList add: " + duration);

        // ArrayList get
        startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList get:  " + duration);

        // LinkedList get
        startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList get: " + duration);

        // ArrayList remove
        startTime = System.nanoTime();

        for (int i = 9999; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList remove:  " + duration);

        // LinkedList remove
        startTime = System.nanoTime();

        for (int i = 9999; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList remove: " + duration);
		
	}
	
	
	public static void testMap(){
		Map<String, String> map = new HashMap<String, String>();
	       map.put("1", "Level 1");
	       map.put("2", "Level 2");
	       map.put("3", "Level 3");
	       map.put("a", "Level a");
	       map.put("b", "Level b");
	       map.put("c", "Level c");
	       Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
	       while (it.hasNext()) {
	           Map.Entry<String, String> e = it.next();
	           System.out.println("Key: " + e.getKey() + ";   Value: " + e.getValue());
	       }
	       System.out.println("======================================");
	       
	       Map<String, String> map1 = new TreeMap<String, String>();
	       map1.put("3", "Level 1");
	       map1.put("2", "Level 2");
	       map1.put("1", "Level 3");
	       map1.put("a", "Level a");
	       map1.put("b", "Level b");
	       map1.put("c", "Level c");
	       Iterator<Map.Entry<String, String>> it1 = map1.entrySet().iterator();
	       while (it1.hasNext()) {
	           Map.Entry<String, String> e1 = it1.next();
	           System.out.println("Key: " + e1.getKey() + ";   Value: " + e1.getValue());
	       }
	       System.out.println("======================================");
	       
	       Map<String, String> map2 = new LinkedHashMap<>();
	       map2.put("a", "Level a");
	       map2.put("b", "Level b");
	       map2.put("c", "Level c");
	       map2.put("1", "Level 1");
	       map2.put("2", "Level 2");
	       map2.put("3", "Level 3");
	       Iterator<Map.Entry<String, String>> it2 = map2.entrySet().iterator();
	       while (it2.hasNext()) {
	           Map.Entry<String, String> e2 = it2.next();
	           System.out.println("Key: " + e2.getKey() + ";   Value: " + e2.getValue());
	       }
	}
	
	public static void testSet(){
	    Random r = new Random();
	    
	    HashSet<String> hashSet = new HashSet<String>();
	    TreeSet<String> treeSet = new TreeSet<String>();
	    LinkedHashSet<String> linkedSet = new LinkedHashSet<String>();
	 
	    // start time
	    long startTime = System.nanoTime();
	 
	    for (int i = 0; i < 1000; i++) {
	        int x = r.nextInt(1000 - 10) + 10;
	        hashSet.add(String.valueOf(x));
	    }
	    // end time
	    long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println("HashSet: " + duration);
	 
	    // start time
	    startTime = System.nanoTime();
	    for (int i = 0; i < 1000; i++) {
	        int x = r.nextInt(1000 - 10) + 10;
	        treeSet.add(String.valueOf(x));
	    }
	    // end time
	    endTime = System.nanoTime();
	    duration = endTime - startTime;
	    System.out.println("TreeSet: " + duration);
	 
	    // start time
	    startTime = System.nanoTime();
	    for (int i = 0; i < 1000; i++) {
	        int x = r.nextInt(1000 - 10) + 10;
	        linkedSet.add(String.valueOf(x));
	    }
	    // end time
	    endTime = System.nanoTime();
	    duration = endTime - startTime;
	    System.out.println("LinkedHashSet: " + duration);
		
	}
	
	
	public static void main(String[] args) {
		//testArrayList();
		//testLinkArrayList();
		//testVectorList();
		//testFastList();
		
		//testMap();
		
		testSet();
		
	}
	

}

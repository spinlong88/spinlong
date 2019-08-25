package com.example.test;

public class ThreadTest {
	public static void main(String[] args) {
		MyThreadTest mt1 = new MyThreadTest("窗口1");
		MyThreadTest mt2 = new MyThreadTest("窗口2");
		MyThreadTest mt3 = new MyThreadTest("窗口3");
		mt1.start();
		mt2.start();
		mt3.start();
	}
}
class MyThreadTest extends Thread{
	private int ticket = 5;    
	private String name;
	public MyThreadTest(String name){
		this.name = name;
	}
    public void run(){    
         while(true){  
        	 synchronized (this) {
	             if(ticket < 1){    
	                break;  
	             }   
	             System.out.println(name + " = " + ticket--);
        	 }   
        	 
        	 try {
    			 Thread.sleep(1000);
    		} catch (Exception e) {
    		}
         }    
    } 
}

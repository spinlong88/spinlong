package com.example.test;

public class RunnableTest {
	public static void main(String[] args) {
		MyRunnableTest mt = new MyRunnableTest();
		Thread mt1 = new Thread(mt,"窗口1");
		Thread mt2 = new Thread(mt,"窗口2");
		Thread mt3 = new Thread(mt,"窗口3");
		Thread mt4 = new Thread(mt,"窗口4");
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
	}
}
class MyRunnableTest implements Runnable{
	private int ticket = 10;    
	public void run(){    
         while(true){  
        	 synchronized (this) {
    		 if(ticket < 1){    
    			 break;  
    		 }   
    		 System.out.println(Thread.currentThread().getName() + " = " + ticket--);  
        	}
        	 
        	 try {
    			 Thread.sleep(1000);
    		} catch (Exception e) {
    		}
        	 
         }    
        
    } 
}

package com.example.test;

import java.util.Arrays;
import java.util.Scanner;

public class testStringSort {

	
	public static void main(String[] args){
		
		String str00 = "Hello";
		String str01 = "Hello";
		String str02 = new String("Hello");
		String str03 = str02; // 引用传递
		System.out.println(str01 == str00); // true
		System.out.println(str01 == str02); // false
		System.out.println(str01 == str03); // false
		System.out.println(str02 == str03); // true
		System.out.println(str01.equals(str02)); // true
		System.out.println(str01.equals(str03)); // true
		System.out.println(str02.equals(str03)); // true
		
		
			//将字符串和数字进行排序。
		   String str0 = "z2x5cvbace321";  
		   char[] chs = str0.toCharArray();  
		   Arrays.sort(chs);  
		   String s1 = new String(chs);  
		   System.out.println(s1);  
		   
		   //判断某个字符有几个
		   String str = "abcbdfsadcsabc2222abc";
		   String str1 = "abc";
		   // 含有str1的个数
		   int num1 = (str.length() - str.replace(str1, "").length()) / str1.length();
		   System.out.println("字符串中字符a有"+num1+"个");
		   
		   //让一个字符串首字母大写其他字母小写
		   Scanner scanner = new Scanner(System.in);
	        System.out.println("请输入一行字符串....");
	        String strX = scanner.nextLine();
	        String string = strX.substring(0,1).toUpperCase().concat(strX.substring(1).toLowerCase());
	        System.out.println(string);
	        
	        
	        Scanner sc = new Scanner(System.in);
	        String str2 = sc.nextLine();//输入
	        int b = 0,s = 0,count= 0;//计数器
	        for(int i =0;i<str2.length();i++) {
	            char ch = str2.charAt(i);
	            if(ch >= 'A' && ch <= 'Z')
	                b++;
	            else if(ch >= 'a' && ch <= 'z')
	                s++;
	            else if(ch >= '0' && ch <= '9')
	                count++;
	        }
	        System.out.println("大写字母的个数是" + b);
	        System.out.println("小写字母的个数是" + s);
	        System.out.println("数字字符的个数是" + count);
	

		
	}
	
}

package cn.test_01;

public class StringDemo {
	 public static void main(String[] args) {
		 String s1 = new String();
		 System.out.println("S1:" + s1);
		 
		 System.out.println("s1.length():"+s1.length());
		 
		 byte[] bys = {97, 98, 99, 100};  // 字节转为字符串
		 String s2 = new String(bys);
		 System.out.println(s2);
		 
	 }

}

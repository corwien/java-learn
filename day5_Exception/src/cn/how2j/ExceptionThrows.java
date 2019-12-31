package cn.how2j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionThrows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();

	}
	
	public static void method1() {
		try {
			method2();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void method2() throws FileNotFoundException {
		
		File f = new File("text.txt");
		
		System.out.println("打开文件");
		new FileInputStream(f);
		System.out.println("Open Success");
	}

}

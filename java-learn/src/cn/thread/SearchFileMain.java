package cn.thread;

import java.io.File;

import cn.thread.SearchFileThread;
public class SearchFileMain {
	public static void search(File file, String search) {
		if(file.isFile()) {
			if(file.getName().toLowerCase().endsWith(".java")) {
				
				System.out.println(file.getName());
				  //当找到.java文件的时候，就启动一个线程，进行专门的查找
				new SearchFileThread(file,search).start();
			}
		}
			
			if(file.isDirectory()) {
				File[] fs = file.listFiles();  // 遍历文件
			    for(File f : fs) {
			    	// 递归
			    	search(f, search);
			    }
			}
			
	}
	
	
	public static void main(String[] args) {
		
		// 创建文件实例
        File folder =new File("/Users/kaiyiwang/eclipse-workspace/java-learn/src/lambda");   // 打开文件流
        // System.out.println(folder);
        // System.out.println(folder.getParent());
        search(folder,"damage");
 
    }
	

}

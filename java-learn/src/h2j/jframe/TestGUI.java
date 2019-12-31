package h2j.jframe;
import javax.swing.JButton;
import javax.swing.JFrame;
import h2j.jframe.SavingPositionThread;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestGUI {
	
	public static void main(String[] args) {
		
		// 主窗体
		JFrame f = new JFrame("LoL");
		
		// 主窗体设置大小
		f.setSize(400, 300);
		
		// 主窗体设置位置
        Point p =getPointFromLocationFile();
        if(p!=null)
            f.setLocation(p.x,p.y);
        else
            f.setLocation(200, 200);
		
		// 主窗体中的组件设置为绝对定位
		f.setLayout(null);
		
		 // 按钮组件
        JButton b = new JButton("一键秒对方基地挂");
 
        // 同时设置组件的大小和位置
        b.setBounds(50, 50, 280, 30);
 
        // 把按钮加入到主窗体中
        f.add(b);
 
        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);
        
        new SavingPositionThread(f).start();
	}
	
	 static class Point {
	        int x;
	        int y;
	    }
	 
	 
	 public static Point getPointFromLocationFile() {
	        File file = new File("/Users/kaiyiwang/eclipse-workspace/java-learn/src/h2j/jframe/location.txt");
	        Point p = null;
	        try (FileInputStream fis = new FileInputStream(file); DataInputStream dis = new DataInputStream(fis);) {
	            int x = dis.readInt();
	            int y = dis.readInt();
	            p = new Point();
	            p.x = x;
	            p.y = y;
	 
	        } catch (FileNotFoundException e) {
	            //第一次运行，并没有生成位置文件，所以会出现FileNotFoundException
	             
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	        return p;  
	 
	    }
	 
	
	
	

}

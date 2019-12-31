package cn.thread;
import java.util.ArrayList;
import java.util.List;
import cn.thread.PasswordThread;
import cn.thread.LogThread;

public class TestPWDThread {
	public static boolean found = false;
    
    public static void main(String[] args) {
        String password = randomString(3);
        System.out.println("密码是:" + password);
        List<String> passwords = new ArrayList<>();
         
        new PasswordThread(password,passwords).start();
        new LogThread(passwords).start();
         
    }
    
    private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
        	// System.out.println( i);
            pool += (char) i;   // i=65, (char)i=A
        }
        
        // System.out.println( pool);
        
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        // System.out.println( cs);
        
        String result = new String(cs);
        return result;
    }
    
    
	

}

package cn.how2j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



/**
 * 其他常见异常：
ParseException 解析异常，日期字符串转换为日期对象的时候，有可能抛出的异常
OutOfIndexException 数组下标越界异常
OutOfMemoryError 内存不足
ClassCastException 类型转换异常
ArithmeticException 除数为零
NullPointerException 空指针异常
 */

/**
 * 异常处理
 * @author kaiyiwang
 *
 */
public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		File f = new File("test.txt");
		
		// 试图打开文件，如果不处理，编译时会报错
		new FileInputStream(f);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("文件不存在");
			e.printStackTrace();
			
		}
		
	}

}

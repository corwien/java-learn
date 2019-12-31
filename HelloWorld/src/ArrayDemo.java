
/**
 * 数组
 * @author kaiyiwang
 * 
 * 两种创建形式：
 * A：数据类型[] 数组名;
 * B: 数据类型 数组名[];
 * 
 * 举例：
 * A:int[] a; 定义一个int类型的数组a变量
 * B：int a[]；定义一个int类型的数组变量
 * 
 * 注意：上边两个方法都是定义一个int数组，但是念法上有些小区别，推荐使用第一种。
 * 
 * 如何对数组进行初始化呢？
 * A：何为初始化？就是为数组开辟内存空间，并为每个数组元素赋予值
 * B：有几种方式？
 *   a:动态初始化，只指定长度，由系统给出初始化值
 *   b:静态初始化，给出初始化值，由系统决定长度
 *   
 * 动态初始化的格式：
 *   数据类型[] 数组名 = new 数据类型[数组长度];
 *   
 *   举例：
 *   int[] arr = new int[3];
 *  
 *
 */
public class ArrayDemo {
	public static void main(String[] args) {
		int[] arr = new int[3];
		
		 arr[0] = 1;
		 System.out.println(arr);
		 System.out.println(arr[0]);
	}

}

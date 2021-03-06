package how2j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;

import how2j.collection.Hero;

public class TestCollection2 {
	public static void main(String[] args) {
		
		HashMap<String,Hero> heroMap = new HashMap<String,Hero>();
		
		for (int j = 0; j < 2000000; j++) {
            Hero h = new Hero("Hero " + j);
            heroMap.put(h.name, h);
        }
		
		// 进行查找，观察平均值
		for(int i=0; i<10; i++) {
			
			long start = System.currentTimeMillis();
			  //查找名字是Hero 1000000的对象
            Hero target = heroMap.get("Hero 1000000");
            System.out.println("找到了 hero!" + target.name);
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("一共花了：" + elapsed + " 毫秒");
			
		}
		
	}
	

}

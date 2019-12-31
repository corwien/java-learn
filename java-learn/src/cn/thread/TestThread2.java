package cn.thread;
import cn.thread.Hero;
import cn.thread.KillThread;

public class TestThread2 {
	
	public static void main(String[] args) {
        
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;
 
        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;
         
        //盖伦攻击提莫
       KillThread killThread1 = new KillThread(gareen, teemo);
       killThread1.start();
 
        //赏金猎人攻击盲僧
       KillThread killThread2 = new KillThread(bh,leesin);
       killThread2.start();
    }

}

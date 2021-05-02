package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author: liguangwei
 * @create: 2021-02-02 15:07
 **/
public class Test {
    public static void main(String[] args) {

        Test test = new Test();
        Inc in = test.new Inc();
        Dec de = test.new Dec();
        thre s = test.new thre();
        new Thread(in).start();
        new Thread(de).start();
        new Thread(de).start();
        s.start();

        Map<String, Integer> map = new HashMap<>();
        for(String ss : map.keySet()){
            System.out.println(ma);
        }

    }
    public int j;
    public synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName()+"=inc=="+j);
    }

    public synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "=dec==" + j);

    }


    class Inc implements Runnable{

        @Override
        public void run() {
            for (int i = 0 ; i < 100; i ++){
                inc();
            }
        }
    }

    class Dec implements Runnable{

        @Override
        public void run() {
            for (int i = 0 ; i < 100; i ++){
                dec();
            }

        }
    }

    class thre extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}

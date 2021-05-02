package test;

/**
 * @description
 * @author: liguangwei
 * @create: 2021-04-10 08:02
 **/
public class Binary {
    public static void main(String[] args) {
        Binary binary = new Binary();
        System.out.println(binary.NumberOf1(-2147483648));
    }


//输入一个整数，输出该数32位二进制
    public String NumberOf1(int n) {
            int aa = n;
           String str = "";
           while ( n != 0){
               str = n % 2 + str;
               n = n / 2;
           }
           return str;
    }

    //输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
    public int NumberOf2(int n) {
        int count = 0;
        int flag = 1;
        while (flag !=  0) {
            if((flag & n) != 0) count ++;
            flag = flag << 1;
        }
        return count;
    }











}

package niuke;

//给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description
 * @author: liguangwei
 * @create: 2020-08-02 15:09
 **/
public class CutRope {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        System.out.println(rope(n));
    }
    private static int rope(int target){
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int a = target % 3;
        int b = target / 3;
        if(a == 0){
            return (int)Math.pow(3,b);
        }else {
            if(a == 1)
                return 2*2*(int)Math.pow(3,b-1);
            else
                return 2*(int)Math.pow(3,b);

        }

    }
}

/*
总结： 1.数学知识 2. 考虑 极端值
 */


package likou;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Author: Li Guangwei
 * @Descriptions: TODO
 * @Date: 2021/4/28 8:42
 * @Version: 1.0
 */
public class Common {


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

     示例 1:

     输入: s = "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int maxLength(String s){
        //滑动窗口思想
        int n = s.length();
        int j = 0, i =0;
        int ans = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else {
                set.remove(s.charAt(i ++));
            }
        }
        return ans;
    }

    /**
     * 两个非常长的数字字符串相乘
     */

    public void chengfa(String str1, String str2){
        int[] result = new int[str1.length() + str2.length()];
        for(int i = 0 ; i < str1.length(); i ++){
            for (int j = 0; i < str2.length(); j++){
                result[i+j] = Integer.parseInt(str1.substring(i,i+1))*Integer.parseInt(str2.substring(j,j+1));
            }
        }

        for(int i = 0; i < result.length; i++){
            result[i+1] = result[i] / 10;
            result[i] = result[i] % 10;
        }

        for (int i = result.length - 1; i >= 0; i --){
            System.out.println(result[i]);
        }

    }

    /**
     * 给定一个无序数组，找出组合三角形的周长最大的
     * 思路：先排序，a> b> c; 只要能证明 b+c>a 就行了，因为 a+c肯定大于b；a+b肯定大于c
     */
    public void findMax(int[] num){
        //1 排序
        for(int i = 0 ; i < num.length; i ++){
            for(int j = 0; j < num.length - i - 1; j ++){
                if(num[j] > num[j+1]) {
                    int tmp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = tmp;
                }
            }
        }
        //
        for(int j = num.length - 1; j > 1; j --){
            if(num[j-1] + num[j - 2] > num[j]){
                System.out.println(num[j]+" "+ num[j-1]+" " + num[j-2]);
                break;
            }
        }
    }
}

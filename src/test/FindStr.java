package test;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * @description 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 * @author: liguangwei
 * @create: 2021-02-02 14:54
 **/
public class FindStr {
    public static void main(String[] args) {
        System.out.println(LCS("www","12345EF"));
    }
        public static String LCS (String str1, String str2) {
            // write code here
            StringBuilder sb = new StringBuilder();
            int start = 0, end = 1;
            while (end < str1.length() + 1){
                if (str2.contains(str1.substring(start, end))){
                    if (sb.length() < end - start){
                        sb.delete(0, sb.length());
                        sb.append(str1, start, end);
                    }
                    end++;
                    System.out.println(str2.contains(str1.substring(start, end))+"end"+end);
                } else{
                    start++;
                    System.out.println("start"+start+";end"+end);
                }
                System.out.println("------");
            }
            if (sb.length() == 0)
                return "-1";
            return sb.toString();
        }




    public static String LCS2(String str1, String str2){
        StringBuilder sb = new StringBuilder();
        int start=0,end = 1;
        while (end < str1.length() +1){
            if(str2.contains(str1.substring(start,end))){
                if(sb.length() < end - start){
                    sb.delete(0,sb.length());
                    sb.append(str1,start,end);
                }
                end ++;
            }else {
                start ++;
            }
        }
        if(sb.length() < 1)
            return "-1";
        return sb.toString();
    }
}

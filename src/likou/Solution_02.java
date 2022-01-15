package likou;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。

import java.util.*;

public class Solution_02 {
    //思路 利用栈来处理
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap(){
            {
                put(')','(');
                put('}','{');
                put(']','[');
            }
        };
        List<Character> list = new ArrayList(){
            {
                add('(');
                add('{');
                add('[');
            }
        };
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length(); i ++){
            char a = s.charAt(i);


            if(list.contains(a)){
                stack.push(a);
            }else{
                Character o = map.get(a);
                if(stack.empty()){
                    return false;
                }
                Character pop = stack.pop();
                System.out.println(o +" "+pop);
                if(o != pop){
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Solution_02 solution_02 = new Solution_02();
        System.out.println(solution_02.isValid("]"));
    }
}

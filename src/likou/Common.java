package likou;

import java.util.*;

/**
 * @Author: Li Guangwei
 * @Descriptions: TODO
 * @Date: 2021/4/28 8:42
 * @Version: 1.0
 */
public class Common {
    public static void main(String[] args) {
        Common common = new Common();
        int[] a= new int[]{0,1,1,0,-2,2};

    }

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



    /*
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i ++){
            for(int j = i+1; j < nums.length - 1; j++){
                for(int k = j+1; k <nums.length; k ++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        boolean flag = false;
                        for(List<Integer> a : result){
                            if(list.get(0) == a.get(0) && list.get(1) == a.get(1) &&list.get(2) == a.get(2)){
                                flag = true;
                                break;
                            }
                        }
                        if(!flag) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }


    /**
     *示例 1:

     输入: candidates = [2,3,6,7], target = 7,
     所求解集为:
     [
     [7],
     [2,2,3]
     ]
     示例 2:

     输入: candidates = [2,3,5], target = 8,
     所求解集为:
     [
     [2,2,2,2],
     [2,3,3],
     [3,5]
     ]
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        findOne(candidates,target,0,list,arr);
        return list;
    }
    public void findOne(int[] nums, int target, int start, List<List<Integer>> list, List<Integer> arr){
        if(target == 0){
            list.add(new ArrayList<>(arr));
            return;
        }else if (target < 0) {
            return;
        }
        for(int i = start; i < nums.length; i ++){
            arr.add(nums[i]);
            findOne(nums, target - nums[i],i + 1,list, arr);
            arr.remove(arr.size() - 1);
        }
    }


}

package niuke;

import java.util.*;

/**
 * @description
 * @author: liguangwei
 * @create: 2020-08-02 20:54
 **/
public class Test {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        List<Integer> list = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry entity = iterator.next();

        }
    }
}

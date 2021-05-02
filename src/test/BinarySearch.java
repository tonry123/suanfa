package test;

/**
 * @description
 * @author: liguangwei
 * @create: 2021-01-30 10:58
 **/
public class BinarySearch {

    public static void main(String[] args) {

    }

    public int find(int[] a, int b){
        int low = 0;
        int high = a.length-1;
        while(low <= high){
            int mid = (low + high ) /2;
            if(a[mid] == b){
                return a[mid];
            }
            if(a[mid] > b){
                high = mid-1;
            }
            if(a[mid] < b){
                low = mid+1;
            }
        }
        return -1;
    }


    public int find2(int[] a, int b){
        if(a.length == 0 ){
            return -1;
        }
        int low = 0;
        int high = a.length - 1;

        while ( low <= high) {

            int mid = (low + high) / 2;
            if (b == a[mid]) {
                return b;
            }

            if (b > a[mid]) {
                low = mid + 1;
            }
            if (b < a[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }
}

package test;


import java.util.Arrays;

/**
 * @description
 * @author: liguangwei
 * @create: 2021-01-10 16:09
 **/
public class Sort {

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        int[] a1 = quickSort(a,0,5);
//        System.out.println(a1[4]);


    }
    public static int[] maopao(int[] a, int n){

        if (n <= 1) return a;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n-1-i; j ++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j +1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }

    public static int[] charu(int[] a, int n){
        if (n <= 1) return a;
        for(int i = 1; i < n; i ++){
            int tem = a[i];
            int j = i - 1;
            for(; j >= 0; j --){
                if(tem < a[j]){
                    a[j+1] = a[j];
                }else {

                    break;
                }
            }
            a[j+1] = tem;
        }

        return a;
    }



    public static int[] xuanze(int[] a, int n){
        if (n <= 1) return a;
        for(int i= 0; i < n; i++){
            int k = i;
            for(int j = i+1; j < n; j ++ ){
                if(a[k] > a[j]){
                    k = j;
                }
            }
            int temp = a[i];
            a[i] = a[k];
            a[k] =temp;
        }
        return a;
    }


    /*
    快排
     */
    private static int[] quickSort(int[] a, int head, int tail) {

        int low = head;
        int high = tail;
        int pivot = a[low];
        if (low < high) {

            while (low<high) {
                while (low < high && pivot <= a[high]) high--;
                a[low] = a[high];
                while (low < high && pivot >= a[low]) low++;
                a[high]=a[low];
            }
            a[low] = pivot;

            if(low>head+1) quickSort(a,head,low-1);
            if(high<tail-1) quickSort(a,high+1,tail);
        }

        return a;

    }


    /**
     * 归并排序
     */
    public  int[] guibing(int[] arr){
        if(arr.length < 2){
            return arr;
        }
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr,0,middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(guibing(left), guibing(right));

    }

    public int[] merge(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int i=0, j = 0,count = 0;
        while (i < a.length && j < b.length){
            if(a[i] <= b[j]){
                c[count++] = a[i];
                i ++;
            }else {
                c[count++] = b[j];
                j ++;
            }
        }
        if(i <= a.length){
            while (i < a.length){
                c[count++] = a[i];
            }
        }

        if(j <= b.length){
            while (j < b.length){
                c[count++] = b[j];
            }
        }
        return c;
    }













}























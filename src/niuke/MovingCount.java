package niuke;

//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
// 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
// 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

/**
 * @description
 * @author: liguangwei
 * @create: 2020-08-02 15:39
 **/
public class MovingCount {
    public static void main(String[] args) {
        System.out.println(movingCount(15,20,20));

//        System.out.println(digui(101));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols]; //记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }

    public static int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j)  > threshold || flag[i][j] == 1) return 0;
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    public static int numSum(int num) {
        if (num < 10) {
            return num;
        } else {
            int a = num % 10;
            return a + numSum(num / 10);
        }
    }





}

/**
 * 如果用循环数组,不行，应为可以从下一行到达
 */

import java.util.Scanner;

class ArraysUtils {

    int[][] createArray(int size) {
        int i = 0;
        int[][] result = new int[size][size];
        Scanner scanner = new Scanner(System.in);
        while(i < result.length) {
            int j = 0;
            while (j < result[i].length) {
                System.out.printf("Podaj wartość na indeksie [%d][%d]\n", i, j);
                result[i][j] = scanner.nextInt();
                j++;
            }
            i++;
        }
        return result;
    }

    int sumArray(int[] array) {
        int sum = 0;
        int i = 0;
        while(i < array.length) {
            sum += array[i];
            i++;
        }
        return sum;
    }

    int findBiggestIndex(int[][] array) {
        int biggestIndex = 0;
        int biggestSum = Integer.MIN_VALUE;
        int i = 0;
        while (i < array.length) {
            int rowSum = sumArray(array[i]);
            if(rowSum > biggestSum) {
                biggestIndex = i;
                biggestSum = rowSum;
            }
            i++;
        }
        return biggestIndex;
    }

}

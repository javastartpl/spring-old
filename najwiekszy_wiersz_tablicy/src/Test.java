import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        ArraysUtils arraysUtils = new ArraysUtils();
        int[][] array = arraysUtils.createArray(3);
        int biggestIndex = arraysUtils.findBiggestIndex(array);
        int biggestSum = arraysUtils.sumArray(array[biggestIndex]);
        System.out.printf("Największa suma liczb jest w wierszu %d i wynosi %d",
                (biggestIndex + 1), biggestSum);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 7, 6, 4, 2};
        System.out.print("actual array: ");
        printArr(array);
        directSort(array);
        System.out.println();
        System.out.print("sorted array: ");
        printArr(array);

    }
    public static int[] directSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            if (i != minPos) {
                int temp = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = temp;
            }
        }
        return arr;
    }
    public static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}

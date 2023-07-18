public class Main {
    public static void main(String[] args) {
        int[] arr = {6, 1, 4, 3, 5, 9, 8, 2};
        System.out.print("Неотсортированный массив: ");
        printArr(arr);
        bubble_sort(arr);
        System.out.println();
        System.out.print("Отсортированный массив: ");
        printArr(arr);

    }
    public static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static int[] bubble_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}

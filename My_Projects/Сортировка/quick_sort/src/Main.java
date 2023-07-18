public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 3, 4, 5};
        sort(arr, 0, arr.length - 1);
        for (int i:arr) {
            System.out.print(i + " ");
        }

    }
    public static void sort(int[] arr, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = arr[(startPosition + endPosition) / 2];

        do {
            while (arr[leftPosition] < pivot) {
                leftPosition++;
            }
            while (arr[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = arr[leftPosition];
                    arr[leftPosition] = arr[rightPosition];
                    arr[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }
        while (leftPosition <= rightPosition);
            if (leftPosition < endPosition) {
                sort(arr, leftPosition, rightPosition);
            }
            if (startPosition < rightPosition){
                sort(arr, startPosition, rightPosition);
            }
        }
    }

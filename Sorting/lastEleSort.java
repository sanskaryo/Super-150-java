public class lastEleSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 5};
        int index = Sort(arr, arr.length - 1);
        System.out.println("The last element should be placed at index: " + index);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int Sort(int[] arr, int i) {
        int item = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > item) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = item;
        return j + 1;
    }
}
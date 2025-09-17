public class Sorting {
    public static void main(String[] args){
        int[] numbers = new int[10];

        numbers[0] = 25;
        numbers[1] = -3;
        numbers[2] = 5;
        numbers[3] = 10;
        numbers[4] = 38;
        numbers[5] = 62;
        numbers[6] = 20;
        numbers[7] = -8;
        numbers[8] = 173;
        numbers[9] = 65;

        System.out.println("Before Sorting: ");
        printArrayElements(numbers);

        System.out.println("\n\nAfter Bubble Sort: ");
        bubbleSort(numbers);
        printArrayElements(numbers);

        System.out.println("\n\nAfter Selecion Sort: ");
        selectionSort(numbers);
        printArrayElements(numbers);
    }

    private static void printArrayElements(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void bubbleSort(int[] arr){
        for(int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--){
            for(int i = 0; i < lastSortedIndex; i++){
                if(arr[i] < arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr){
        for(int lastSortedIdex = arr.length - 1; lastSortedIdex > 0; lastSortedIdex--){
            int smallest = 0;

            for(int i = 1; i <= lastSortedIdex; i++){
                if(arr[i] < arr[smallest]){
                    smallest = i;
                }
            }
            if(smallest != lastSortedIdex){
                int temp = arr[smallest];
                arr[smallest] = arr[lastSortedIdex];
                arr[lastSortedIdex] = temp;
            }
        }
    }
}

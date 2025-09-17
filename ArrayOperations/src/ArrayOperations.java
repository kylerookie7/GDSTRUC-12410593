public class ArrayOperations {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;

        int searchValue = 5;

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == searchValue) {
                System.out.println(searchValue + " is in index " + i);
            }
        }
    }
}

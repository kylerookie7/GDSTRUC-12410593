public class Practice {
    public static void main(String[] args) {
        // Declare an array of floats that can hold 20 elements
        float[] numbers = new float[20];

        // Assign some values (optional, just for testing)
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 1.5f;  // example values
        }

        // Print all 20 elements
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }
    }
}


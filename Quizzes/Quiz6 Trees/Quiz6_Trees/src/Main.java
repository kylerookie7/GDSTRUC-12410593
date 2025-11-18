import javax.swing.plaf.synth.SynthTextAreaUI;


public class Main {
    public static void main(String[] args)
    {
        int arr[] = {25, 20, 15, 27, 30, 29, 26, 22, 32};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        Tree bst = new Tree();
        bst.insert(25);
        bst.insert(20);
        bst.insert(15);
        bst.insert(27);
        bst.insert(30);
        bst.insert(29);
        bst.insert(26);
        bst.insert(22);
        bst.insert(32);


        bst.inOrderTraverse();
        System.out.println();


        System.out.print("Highest and Smallest Values: ");
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            } else if(arr[i] <= min)
            {
                min = arr[i];
            }
        }


        System.out.println("\nMin: " + min + "\nMax: " + max);
    }


}

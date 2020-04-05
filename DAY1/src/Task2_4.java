
import java.util.Arrays;

public class Task2_4 {
    public static void main(String[] args){
        int[] myArray;
        myArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < myArray.length - 1; i++){
            int temp = myArray[i];
            myArray[i] = myArray[i+1];
            myArray[i+1] = temp;
        }
        String myArrayString = Arrays.toString(myArray);
        System.out.println(myArrayString);
    }
}

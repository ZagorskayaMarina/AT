import java.util.Arrays;

public class Task2_5 {
    public static void main(String[] args){
        //int arrLength = (int) ((Math.random() * 100) + 1);
        int[] arr1 =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String arr1String = Arrays.toString(arr1);
        System.out.println(arr1String);
        int[] newArr1 = shift(arr1,2);
        String newArr1String = Arrays.toString(newArr1);
        System.out.println(newArr1String);
    }

    public static int[] shift(int[] arr, int delta){
        int currentIndex, movedIndex, temp;
        for (int i = 0; i < greatestCommonDivisor(delta, arr.length); i++){
            temp = arr[i];
            currentIndex = i;

            if(delta > 0){
                while (true) {
                    movedIndex = currentIndex + delta;
                    if(movedIndex >= arr.length){
                        movedIndex = movedIndex - arr.length;
                    }
                    if (movedIndex == i)
                        break;
                    arr[currentIndex] = arr[movedIndex];
                    currentIndex = movedIndex;
                }
            }
            if(delta < 0){
                while (true){
                    movedIndex = currentIndex - delta;
                    if (movedIndex <= arr.length){
                        movedIndex = movedIndex + arr.length;
                    }
                    if (movedIndex == i)
                        break;
                arr[currentIndex] = arr[movedIndex];
                currentIndex = movedIndex;
                }
            }
            arr[currentIndex] = temp;
        }
    return arr;
    }

    static int greatestCommonDivisor(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return greatestCommonDivisor(b, a % b);
    }
}

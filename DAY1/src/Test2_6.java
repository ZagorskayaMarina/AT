
import java.util.Arrays;
import java.util.stream.Collectors;

public class Test2_6 {
    public static void main(String[] args){
        int[] arr1 =  {11, 2, 3, 12, 5, 6, 13, 8, 9, 20, 16, 22, 29};
        Arrays.stream(arr1)
              .filter(x -> (x % 2 == 0) && x > 10)
              .boxed().collect(Collectors.toList())
              .forEach(System.out::println);
}
}

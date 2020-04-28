//i++ - post-increment which means executes some instruction before it increments i
//++i is pre-increment which means before executes some instruction it increments i first and then executes this instruction
public class Task2_1 {
    public static void main(String[] args){
        System.out.println(getI());
        System.out.println(getJ());
    }

    private static int getI(){
        int i = 0;
        return i++;
    }

    public static int getJ(){
        int j = 0;
        return ++j;
    }
}

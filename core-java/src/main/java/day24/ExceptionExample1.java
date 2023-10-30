package day24;

public class ExceptionExample1 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        //here the program will come execute completely . the first two lines only executes it wont execute 3 line
      // and give exception in second line itself
        /*  System.out.println("program started");
        System.out.println(arr[arr.length]);
        System.out.println("program ended");*/


        //Now in below code the program will execute completely . but the exception which is arised will be displayed
        //after execution of all the 3 lines . at last

        System.out.println("program started");
        try {
            System.out.println(arr[arr.length]);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        System.out.println("program ended");
        //we can use multiple catch block with single try block but we cannot use multiple finally block
        //we have two types of exceptios checked and uncked
        //checked exception are known by the compiler
        //uncheckd exceptoin are not known by the compiler
    }
}

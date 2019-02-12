import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args)
    {
        //List
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        TimeIt.code(() ->
        System.out.println(
                numbers
                        //.stream()                 //takes 5 seconds
                        .parallelStream()           //takes 1 second: BE VERY CAREFUL WITH PARALLEL STREAM -> uses a lot of threads and resources
                        .filter(e ->  e% 2 == 0)    // get even numbers
                        .mapToInt(e -> compute(e))       //double them
                        .sum()));
    }

    public static int compute(int number)
    {
        //assume this is time intensive
        try{ Thread.sleep(1000); } catch(Exception ex) {}
        return number * 2;
    }


}

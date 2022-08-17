import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueTripletsSimple {

    final static int[] NUMBERS = {-1, 0, 1, 2, -1, -4};

    public static void main(String[] args) {

        List<int[]> result = new ArrayList<>();

        for (int a : NUMBERS) {
            for (int b : NUMBERS) {
                for (int c : NUMBERS) {
                    if (a + b + c == 0) {
                        result.add(new int[]{a, b, c});
                    }
                }
            }
        }

        result.forEach(item -> System.out.println(Arrays.toString(item)));
    }
}

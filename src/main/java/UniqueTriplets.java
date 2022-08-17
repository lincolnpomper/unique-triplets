import java.util.ArrayList;
import java.util.List;

public class UniqueTriplets {

    final static int[] NUMBERS = {-1, 0, 1, 2, -1, -4};

    public static void main(String[] args) {
        new UniqueTriplets();
    }

    public UniqueTriplets() {

        List<Triplet> result = new ArrayList<>();

        for (int a = 0; a < NUMBERS.length; a++) {

            int[] numbersB = copyExcept(NUMBERS, a);
            for (int b = 0; b < numbersB.length; b++) {

                int[] numbersC = copyExcept(numbersB, b);
                for (int numberC : numbersC) {

                    if (NUMBERS[a] + numbersB[b] + numberC == 0) {
                        Triplet triplet = new Triplet(NUMBERS[a], numbersB[b], numberC);
                        if (!contains(result, triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }

        result.forEach(System.out::println);
    }

    private boolean contains(List<Triplet> result, Triplet item) {

        for (Triplet triplet : result) {
            if (triplet.equals(item)) {
                return true;
            }
        }

        return false;
    }

    static int[] copyExcept(int[] source, int except) {

        int[] destination = new int[source.length - 1];

        int pos = 0;
        for (int i = 0; i < source.length; i++) {
            if (i == except) {
                continue;
            }
            destination[pos++] = source[i];
        }
        return destination;
    }

    class Triplet {

        int a;
        int b;
        int c;

        Triplet(int a, int b, int c) {

            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return a + ", " + b + ", " + c;
        }


        @Override
        public boolean equals(Object o) {

            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass())
                return false;

            Triplet triplet = (Triplet) o;

            return triplet.a == this.a && triplet.b == this.b && triplet.c == this.c ||
                    triplet.a == this.a && triplet.b == this.c && triplet.c == this.b ||
                    triplet.a == this.b && triplet.b == this.a && triplet.c == this.c ||
                    triplet.a == this.b && triplet.b == this.c && triplet.c == this.a ||
                    triplet.a == this.c && triplet.b == this.b && triplet.c == this.a ||
                    triplet.a == this.c && triplet.b == this.a && triplet.c == this.b;
        }
    }
}

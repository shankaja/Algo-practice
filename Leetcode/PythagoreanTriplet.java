public class PythagoreanTriplet {
// project euler - 9

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int z = 0;
        loop:
        for (int a = 1; a < 1000; a++) {
            for (int b = 1; b < 1000; b++) {
                long formulaVal = 2 * a * b + 1000000L - 2000 * (a + b);
                if (formulaVal == 0) {
                    x = a;
                    y = b;
                    z = 1000 - a - b;
                    break loop;
                }
            }
        }

        System.out.println(x * y * z);
    }

}

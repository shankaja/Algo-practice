public class SquareRoot {



    public static void main(String[] args) {
        double v = sqrtPow(12);
        System.out.println(v);
        System.out.println(v*v);
        double sqrt = sqrt(12);
        System.out.println(sqrt);
        System.out.println(sqrt*sqrt);
    }

    static double sqrtPow(double n) {
        return Math.pow(n, 0.5);
    }

    private static final double TOLERANCE = 0.0000000000001;

    static double sqrt(double n) {
        int i = 0;
        while (true) {
            if (i * i == n) return i;
            if (i * i > n) {
                return doubleSqrt(i - 1.0, i, n);
            }
            i++;
        }
    }

    static double doubleSqrt(double l, double r, double n) {
        double middle = (l + r) / 2;
        if (Math.abs(middle * middle - n) < TOLERANCE) return Math.round(middle*10000000000d)/10000000000d;
        if (middle * middle > n) return doubleSqrt(l, middle, n);
        if (middle * middle < n) return doubleSqrt(middle, r, n);
        return Double.NaN;
    }
}

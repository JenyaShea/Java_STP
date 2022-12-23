public class Func {
    public static double function(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23 ;
    }
    public static double find_root(double start, double end) {

        double x = (end + start) / 2;
        if (end - start <= 0.001) {
            return start;
        }
        if(function(start) * function(x) > 0) {
            return find_root(x, end);
        } else {
            return find_root(start, x);
        }
    }
}

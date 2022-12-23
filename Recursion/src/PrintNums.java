public class PrintNums {
    public static int pr_nums(int i, int n) {
        if (i > n) {
            return 1;
        }
        System.out.println(i);
        return pr_nums(i+1,n);
    }
}

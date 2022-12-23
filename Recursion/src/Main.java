import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        task_1();
//        task_2();
//        task_3();
        bt();
    }

    public static void task_1() {
        PrintNums.pr_nums(1,24);
    }

    public static void task_2() {
        int[] array = new int[100000000];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(300);
        }
        Arrays.sort(array);
        System.out.println("Перебор");
        long start = System.nanoTime();
        Blsearch.lineSearch(array, 224);
        long finish = System.nanoTime();
        System.out.println("Finish - Start: " + (double) (finish - start));

        System.out.println("Бинарный поиск");
        start = System.nanoTime();
        Blsearch.binarySearch(array, 224, 0, array.length);
        finish = System.nanoTime();
        System.out.println("Finish - Start: " + (double) (finish - start));
    }

    public static void task_3() {
        System.out.println("\n" + "Calculated Root = " + Func.find_root(0,10));
    }
    public static void bt(){
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(9);
        binaryTree.add(6);
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);

        System.out.println(binaryTree.containsNode(6));
    }
}
public class Blsearch {

    public static int binarySearch(int[] array, int p , int b, int al) {

        int middle = (b + al) / 2;

        if (al <= b) return -1;

        if (array[middle] == p) {
            return middle;

        } else if (array[middle] > p) {
            return binarySearch(array, p, b, middle - 1);
        } else {
            return binarySearch(array, p, middle + 1, al);
        }
    }

    public static int lineSearch(int[] array, int x) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        System.out.println("Элемента" + x + " в массиве нет ");
        return -1;
    }
}

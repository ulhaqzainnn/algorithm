package Start;
public class minValue {
    public static void main(String[] args) {
        int[] array = new int[] {54, 32, 78, 92, 48, 38, 49, 30, 6, 11, 19};
        int minValue = array[0];
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        System.out.println("Min value is: " + minValue);
        System.out.println("Min index is: " + minIndex);
    }
}

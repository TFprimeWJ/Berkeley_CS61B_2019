package AdHocTesting;

public class TestSort {
    /** Test the sort method of the Sort class. */
    public static void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        for (int i = 0; i < input.length; i+=1) {
            if (!input[i].equals(expected[i])) {
                System.out.println("Mismatch in position in " + i + ", expected: " + expected[i] + ", but got: " + input[i] + ".");;
                break;
            }
        }
    }

    public static void main(String[] args) {
        testSort();
    }
}

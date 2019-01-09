import java.util.ArrayList;
import java.util.Arrays;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {



        if (lessThan > sortedArray[sortedArray.length-1])
            return sortedArray.length;
        if (lessThan < sortedArray[0])
            return 0;
        if (lessThan == sortedArray[sortedArray.length/2])
            return sortedArray.length/2;

        if (lessThan < sortedArray[sortedArray.length/2]) {
            int[] newSortedArray = Arrays.copyOfRange(sortedArray, 0, sortedArray.length/2);
            return countNumbers(newSortedArray, lessThan);
        }
        if (lessThan > sortedArray[sortedArray.length/2]) {
            int[] newSortedArray = Arrays.copyOfRange(sortedArray,sortedArray.length/2 + 1, sortedArray.length);
            return sortedArray.length/2 + 1 + countNumbers(newSortedArray, lessThan);
        }

        return 0; // Buna gerek yok aslında.

    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7, 9 }, 5));
    }
}


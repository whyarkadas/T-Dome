import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] findTwoSum(int[] list, int sum) {

        Map<Integer, Integer> numPositions;

        numPositions = new HashMap<>();

        System.out.println("sum: " + sum);
        if (list == null || list.length <= 1)
            return null;

        for (int i = 0; i < list.length; i++) {

            int toRetrieve = sum - list[i];

            if (numPositions.containsKey(toRetrieve)) {
                if (toRetrieve + list[i] == sum)
                    return new int[]{numPositions.get(toRetrieve), i};
            }
            numPositions.put(list[i], i);
        }
        return null;

    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);

        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }

        /*if(indices != null) {
            int i=0;
            while(indices.length > i){
                System.out.println(indices[i] + " " + indices[i+1]);
                i+=2;
            }
        }*/
    }
}
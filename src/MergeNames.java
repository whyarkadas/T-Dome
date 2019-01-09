import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;


public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");

        ArrayList<String> allUniqueNames = new ArrayList<String>();
        allUniqueNames.addAll(Arrays.asList(names1));
        for (String name : names2) {
            if ( !Arrays.stream(names1).anyMatch(name::equals)){
                allUniqueNames.add(name);
            }
        }


        allUniqueNames = new ArrayList<String>(new LinkedHashSet<String>(allUniqueNames));
        return allUniqueNames.toArray(new String[allUniqueNames.size()]);
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}

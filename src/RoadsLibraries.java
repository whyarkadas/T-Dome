import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RoadsLibraries {
    public static int getRoot(int[] map, int ind){
        if(map[ind] < 0)
            return ind;
        else
            return getRoot(map, map[ind]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int number_of_cities = in.nextInt();
            int number_of_roads = in.nextInt();
            long cost_lib = in.nextLong();
            long cost_road = in.nextLong();
            int[] map = new int[number_of_cities];
            Arrays.fill(map, -1);
            for(int a1 = 0; a1 < number_of_roads; a1++){
                int city_1 = in.nextInt()-1;
                int city_2 = in.nextInt()-1;
                int root_1 = getRoot(map, city_1);
                int root_2 = getRoot(map, city_2);
                if(root_1 != root_2){
                    if(map[root_1]<map[root_2]){
                        map[root_1] = map[root_1]+map[root_2];
                        map[root_2] = root_1;
                    }else{
                        map[root_2] = map[root_1]+map[root_2];
                        map[root_1] = root_2;
                    }
                }
            }
            //get sets
            Queue queue = new LinkedList();
            for(int i=0;i<number_of_cities;i++){
                if(map[i] < 0)
                    queue.add(map[i]);
            }
            //build library: size*cost_lib
            //build route: (size-1)*cost_road+cost_lib
            if(cost_lib>cost_road){
                long sum = 0;
                while(!queue.isEmpty()){
                    sum += ((int)queue.poll()+1)*cost_road-cost_lib;
                }
                System.out.println(-sum);
            }else{
                long sum = 0;
                while(!queue.isEmpty()){
                    sum += ((int)queue.poll())*cost_lib;
                }
                System.out.println(-sum);
            }
        }
    }
}

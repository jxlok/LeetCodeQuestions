//Problem Statement: A city's skyline is the outer contour of the silhouette formed by all the buildings
// in that city when viewed from a distance. Given the locations and heights of
// all the buildings, return the skyline formed by these buildings collectively.
//
//The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
//
//lefti is the x coordinate of the left edge of the ith building.
//righti is the x coordinate of the right edge of the ith building.
//heighti is the height of the ith building.
//You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
//
//The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form
// [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except
// the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where
// the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
//
//Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance,
// [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into
// one in the final output as such: [...,[2 3],[4 5],[12 7],...]

import java.util.*;

public class SkyLine {

    public static List<List<Integer>> getSkyline(int[][] buildings){

        int numBuildings = buildings.length;
        //sorted map with index and heights
        SortedMap<Integer, Integer> heights = new TreeMap<>();

        //loop through buildings and acquire height of silhouette at each index
        for(int[] building : buildings){
            int left = building[0];
            int right = building[1];
            int height = building[2];

            //if left already exists, find the taller building
            if(heights.containsKey(left)){
                heights.put(left, Math.max(heights.get(left), height));
            }
            else{
                heights.put(left, height);
            }

            //if right already exists, find the taller building
            if(heights.containsKey(right)){
                heights.put(right, Math.max(heights.get(right), height));
            }
            else{
                heights.put(right, height);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> lower = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        lower.add(0);
        int height=0;
        int lowerBuilding=0;
        //loop through heights with skyline
        for(int key : heights.keySet()){

            //if bigger height found, add to result
            if(heights.get(key)>height){
                result.add(List.of(key, heights.get(key)));
                height=heights.get(key);
                lower.add(heights.get(key));
            }
            //if smaller height, add to priority queue
            else if(heights.get(key)<height){
                lower.add(heights.get(key));
            }
            //if equal, deduct the difference
            else{
                result.add(List.of(key, lowerBuilding));
                if(lower.peek()!=null) {
                    lowerBuilding = lower.poll();
                }
                height=lowerBuilding;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(getSkyline(buildings));
    }

}

import java.util.*;

public class WeakCharacter {

    public static int numberOfWeakCharacters(int[][] properties) {

//        HashSet<Integer> weak = new HashSet<>();
//
//        //loop through every character and determine if they are weak
//        for(int i=0;i<properties.length-1;i++){
//
//            //already checked is weak
//            if(weak.contains(i)){
//                continue;
//            }
//
//            for(int j=i+1;j< properties.length;j++){
//
//                //compare if curr is weak
//                if(properties[i][1] < properties[j][1] && properties[i][0] < properties[j][0]){
//                    weak.add(i);
//                }
//                //check if opponent check is weak
//                else if(properties[j][1] < properties[i][1] && properties[j][0] < properties[i][0]){
//
//                    weak.add(j);
//                }
//            }
//        }
//
//        return weak.size();
//
//        int result=0;
//
//        //attacks hashmap filled ith attack and indexes
//        TreeMap<Integer, List<Integer>> attacks = new TreeMap<>();
//
//        //loop through and add attacks to hashmap
//        for(int i=0;i< properties.length; i++){
//
//            int attack = properties[i][0];
//            if(attacks.containsKey(attack)){
//                attacks.get(attack).add(i);
//            }
//            else{
//                List<Integer> initialList = List.of(i);
//                attacks.put(attack, initialList);
//            }
//        }
//
//        //loop through and check those which had higher attacks
//        for (int[] property : properties) {
//
//            int attack = property[0];
//
//            int opponent = attack + 1;
//
//            while (attacks.containsKey(opponent)) {
//
//                for (int index : attacks.get(opponent)) {
//                    if (properties[index][1] > property[1]) {
//                        result++;
//                        break;
//                    }
//                }
//                opponent++;
//            }
//        }

        //sort by attack and if same value compare by defense (descending order)
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int weakCharacters = 0;
        int max = Integer.MIN_VALUE;

        //loop through from end/biggest
        for(int i= properties.length-1;i>=0;i--){

            //if defense less than max, then weaker since we are going from biggest to smallest and same offense accounted for due to sorted in descending order
            if(properties[i][1] < max){
                weakCharacters++;
            }
            //if defense greater than max, new max detected
            else{
                max = properties[i][1];
            }
        }
        return weakCharacters;
    }

    public static void main(String[] args) {
        int[][] properties = {{1,5},{10,4},{4,3}};
        System.out.println(numberOfWeakCharacters(properties));
    }
}

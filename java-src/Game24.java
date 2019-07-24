import java.util.*;
public class Game24 {
    public static boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int i : nums) list.add((double)i);
        return helper(list);
    }

    static boolean helper(List<Double> list){
        if(list.size() == 1){
            if(list.get(0) - 24 < 0.00001 && list.get(0) - 24 > -0.000001) return true;
            else return false;
        }
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                double[] oper = new double[6];
                oper[0] = list.get(i) + list.get(j);
                oper[1] = list.get(i) - list.get(j);
                oper[2] = list.get(j) - list.get(i);
                oper[3] = list.get(i) * list.get(j);
                oper[4] = list.get(i) / list.get(j);
                oper[5] = list.get(j) / list.get(i);
                List<Double> nextlvl = new ArrayList<>(list);
                nextlvl.remove(j);
                nextlvl.remove(i);
                for(int k = 0; k < 6; k++){
                    List<Double> lvl = new ArrayList<>(nextlvl);
                    lvl.add(oper[k]);
                    if(helper(lvl)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){

        System.out.println(        judgePoint24(new int[]{1,2,1,2}));
    }
}

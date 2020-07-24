package greed;

import java.util.*;

public class GroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();

        int[] sign = new int[groupSizes.length];//设置标识来判断是否需要忽略
        for (int i = 0; i < groupSizes.length; i++) {

            if (sign[i] == 0) {
                ans.add(find(groupSizes, sign, i));//将两个嵌套的list解偶来进行
            }
        }
        return ans;
    }

    private List<Integer> find(int[] groupSizes, int[] sign, int pos) {
        List<Integer> list = new ArrayList<>();

        for (int i = pos; i < groupSizes.length; i++) {
            if (groupSizes[pos] == list.size()) {
                return list;
            } else if (sign[i] == 0 && groupSizes[pos] == groupSizes[i]) {
                list.add(i);
                sign[i] = 1;
            }
        }
        return list;
    }

//        List<List<Integer>> res = new ArrayList<>();
//        int[] vis = new int[groupSizes.length];
//        for (int i = 0; i < groupSizes.length; i++) {
//            if (vis[i] == 0) {
//                res.add(find(groupSizes, vis, i));
//            }
//            vis[i] = 1;
//        }
//        return res;
//    }
//
//    private List<Integer> find(int[] groupSizes, int[] vis, int pos) {
//        List<Integer> res = new ArrayList<>();
//        res.add(pos);
//        for (int i = pos + 1; i < groupSizes.length; i++) {
//            if (groupSizes[pos] == res.size()) {
//                return res;
//            }
//            if (groupSizes[pos] == groupSizes[i] && vis[i] == 0) {
//                res.add(i);
//                vis[i] = 1;
//            }
//        }
//        return res;
}

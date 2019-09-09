package sort;

import java.util.ArrayList;
import java.util.HashMap;

public class AllCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        HashMap<Integer, ArrayList<int[]>> hashMap = new HashMap<>();

        // 建立hashMap,以长度为key,list为value,如果key相同则将坐标以数组的形式添加到list中
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int k = Math.abs(r - r0) + Math.abs(c - c0);
                if (hashMap.containsKey(k)) {
                    ArrayList<int[]> arrayList = hashMap.get(k);
                    arrayList.add(new int[]{r, c});
                } else {
                    ArrayList<int[]> arrayList = new ArrayList<>();
                    arrayList.add(new int[]{r, c});
                    hashMap.put(k, arrayList);
                }
            }
        }

        //以key排序
        int key = 0;
        ArrayList<int[]> arrayList = new ArrayList<>();
        while (hashMap.containsKey(key)) {
            arrayList.addAll(hashMap.get(key));
            key++;
        }

        //转换数据类型
        int[][] res = new int[R * C][2];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i][0] = arrayList.get(i)[0];
            res[i][1] = arrayList.get(i)[1];

        }

        return res;
    }
}

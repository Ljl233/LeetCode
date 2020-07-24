package intersection;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<Integer> nums3 = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < len1; i++) {
            boolean p;
            if (nums3.indexOf(nums1[i])<0) {
                 p=false;
            }else{
                p=true;
            }
            if (!p && isExist(nums1[i], nums2))
               nums3.add(nums1[i]);
        }
            int[] res=new int[nums3.size()];
        for (int i=0;i<res.length;i++){
            res[i]=nums3.get(i);
        }
        return res;
    }

    boolean isExist(int a, int[] b) {
        for (int value : b) {
            if (a == value) return true;
        }
        return false;
    }


}

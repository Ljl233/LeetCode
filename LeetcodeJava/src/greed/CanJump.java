package greed;

public class CanJump {
//    public boolean canJump(int[] nums) {
//        return canJumpFromPosition(0, nums);
//    }
////回溯法
//    boolean canJumpFromPosition(int i, int[] nums) {
//        if (i == nums.length - 1) {
//            return true;
//        }
//
//        int maxCanJump = Math.min(i + nums[i], nums.length - 1);
//        for (int position = maxCanJump; position > i; position--) {
//            if (canJumpFromPosition(position, nums)) {
//                return true;
//            }
//        }
//        return false;
//    }

    //自頂至下的动态规划
//
    Index[] memo;
//
//    public boolean canJump(int[] nums) {
//        memo = new Index[nums.length];
//        for (int i = 0; i < memo.length; i++) {
//            memo[i] = Index.UNKNOWN;
//        }
//        memo[memo.length - 1] = Index.GOOD;
//
//        return canJunpFromPosition(0, nums);
//    }
//
//    boolean canJunpFromPosition(int position, int[] nums) {
//        if (memo[position] != Index.UNKNOWN) {
//            return memo[position] == Index.GOOD;
//        }
//
//
//        int furthestJump = Math.min(position + nums[position], nums.length - 1);
//        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//            if (canJunpFromPosition(nextPosition, nums)) {
//                memo[position] = Index.GOOD;
//                return true;
//            }
//        }
//
//        memo[position] = Index.BAD;
//        return false;
//
//    }

//    自底向上的动态规划
//    public boolean canJump(int[] nums) {
//        memo = new Index[nums.length];
//        for (int i = 0; i < memo.length; i++) {
//            memo[i] = Index.UNKNOWN;
//        }
//        memo[memo.length - 1] = Index.GOOD;
//
//        for (int i = nums.length - 2; i >= 0; i--) {
//            int furthestPosition = Math.min(i + nums[i], nums.length - 1);
//            for (int j = i + 1; j <= furthestPosition; j++) {
//                if (memo[j]==Index.GOOD){
//                    memo[i]=Index.GOOD;
//                    break;
//                }
//            }
//        }
//        return memo[0]==Index.GOOD;
//    }

    public boolean canJump(int[] nums) {
        int good = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i+nums[i]>=good){
                good=i;
            }
        }
        return good==0;
    }
}

enum Index {GOOD, BAD, UNKNOWN};
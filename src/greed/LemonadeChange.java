package greed;

import java.util.ArrayList;
import java.util.List;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0, tenNum = 0, tweNum = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fiveNum++;
                    break;
                case 10:
                    if (fiveNum > 0) {
                        fiveNum--;
                        tenNum++;
                    } else return false;
                    break;
                case 20:
                    if (tenNum > 0 && fiveNum > 0) {
                        tenNum--;
                        fiveNum--;
                        tweNum++;
                    } else if (tenNum == 0 && fiveNum > 2) {
                        fiveNum -= 3;
                        tweNum++;
                    } else return false;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}

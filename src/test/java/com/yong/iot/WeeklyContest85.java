package com.yong.iot;

public class WeeklyContest85 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec2[0] < rec1[2] && rec2[1] < rec1[3]
            && rec2[2] >rec1[2] && rec2[3]>rec1[3]) {
            return true;
        }
        if (rec1[0] < rec2[2] && rec1[1] < rec2[3]
            && rec1[2] >rec2[2] && rec1[3]>rec2[3]) {
            return true;
        }
        return false;
    }

}

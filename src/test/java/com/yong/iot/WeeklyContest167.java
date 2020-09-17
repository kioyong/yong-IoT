package com.yong.iot;

public class WeeklyContest167 {

    public void test() {

    }

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            String s = moves.substring(i, i + 1);
            switch (s) {
                case "U":
                    x += 1;
                    break;
                case "D":
                    x -= 1;
                    break;
                case "R":
                    y += 1;
                    break;
                case "L":
                    y -= 1;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }

        }
        return x == 0 & y == 0;
    }

}

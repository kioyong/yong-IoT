package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class WeeklyContest139 {

    @Test
    public void test() {
        String s = gcdOfStrings("leet", "code");
        log.info(s);
    }

    public String gcdOfStrings(String str1, String str2) {
        String res = "";
        AAA:
        for (int i = 1; i <= str1.length() && i <= str2.length(); i++) {
            String temp = str1.substring(0, i);
            for (int j = i; j <= str2.length(); j = j + i) {
                if (j == str2.length()) {
                    continue;
                }
                if (j + i <= str2.length()) {
                    String temp2 = str2.substring(j, j + i);
                    if (!temp.equals(temp2)) {
                        continue AAA;
                    }
                }else{
                    continue AAA;
                }
            }
            for (int j = i; j <= str1.length(); j = j + i) {
                if (j == str1.length()) {
                    if(str2.substring(0,j).equals(str1)){
                        continue;
                    }

                }
                if (j + i <= str1.length()) {
                    if (j + i <= str1.length()) {
                        String temp2 = str1.substring(j, j + i);
                        if (!temp.equals(temp2)) {
                            continue AAA;
                        }
                    }
                }else{
                    continue AAA;
                }
            }
            res = temp;
        }
        return res;

    }

}

package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class FindRestaurantTest {

    @Test
    public void test() {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"KFC","Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] result = findRestaurant(list1, list2);
        log.debug("result ={}", Arrays.asList(result).toString());
    }

    private String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int index = list1.length + list2.length;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (index == i + j) {
                        list.add(list1[i]);
                    }else if (index > i + j) {
                        index = i + j;
                        list.clear();
                        list.add(list1[i]);
                    }
                }
            }
        }
        return list.toArray(new String[0]);
    }
}

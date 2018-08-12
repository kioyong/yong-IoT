package com.yong.iot.model;

import lombok.*;

import java.util.List;

//import org.springframework.data.annotation.Id;

/**
 * @acthor yong.a.liang
 * @date 2017/11/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Mark extends BaseEntity implements Comparable<Mark> {
    //    @Id
    private String id;
    private String title, type;
    private boolean isActive, isLocked;
    private List<Item> items;
    private Item item;
    private Integer count;

    public static Mark updateMark(Mark oldRecord, Mark newRecord) {
        oldRecord.setActive(newRecord.isActive());
        oldRecord.setItems(newRecord.getItems());
        oldRecord.setItem(newRecord.getItem());
        oldRecord.setLocked(newRecord.isLocked());
        oldRecord.setTitle(newRecord.getTitle());
        oldRecord.setType(newRecord.getType());
        oldRecord.setCount(newRecord.getCount());
        return oldRecord;
    }

    @Override
    public int compareTo(Mark o) {
//        return this.getCreatedDate().compareTo(o.getCreatedDate());
        return -1;
    }

}

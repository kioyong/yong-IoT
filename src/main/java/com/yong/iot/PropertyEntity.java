package com.yong.iot;

import org.springframework.beans.factory.parsing.PropertyEntry;

public class PropertyEntity extends BaseEntity<String, PropertyEntry,String> implements HasActivity<ActivityEntity>{


    private ActivityEntity activity;

    @Override
    public ActivityEntity getActivity() {
        return activity;
    }


    public void setActivity(ActivityEntity activity) {
        this.activity = activity;
    }
}

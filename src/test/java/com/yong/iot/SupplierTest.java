package com.yong.iot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierTest {

    @Test
    public void test() {


//        String name1 = getActivityName(SupplierService::getPropertyEntity, s -> Optional.ofNullable(s).map(PropertyEntity::getActivity).map(ActivityEntity::getName).orElse("default Activity Name"));
//        String name2 = getActivityName(SupplierService::getLocationEntity, s -> Optional.ofNullable(s).map(LocationEntity::getParent).map(PropertyEntity::getActivity).map(ActivityEntity::getName).orElse("default Activity Name"));
//        String name3 = getActivityName(SupplierService::getTableEntity, s -> Optional.ofNullable(s).map(TableEntity::getParent).map(LocationEntity::getParent).map(PropertyEntity::getActivity).map(ActivityEntity::getName).orElse("default Activity Name"));
//        System.out.println(Optional.ofNullable(SupplierService.getPropertyEntity()).map(s -> Optional.ofNullable(s).map(PropertyEntity::getActivity).map(ActivityEntity::getName).orElse("default Activity Name")).get());
//        System.out.println(name1);
//        System.out.println(name2);
//        System.out.println(name3);


    }

    public <L extends BaseEntity<String, ?, String>> String getActivityName(Supplier<L> s, Function<L, String> f) {
        return f.apply(s.get());
    }

    public List<String> getFromPropertyName(String name) {
        if ("property1".equals(name)) {
            return Arrays.asList("test1", "test2");
        } else {
            return new ArrayList<>();
        }
    }
}

class SupplierService {
    public static PropertyEntity getPropertyEntity() {
        ActivityEntity activity = new ActivityEntity();
        activity.setId("activity001");
        activity.setName("test");
        PropertyEntity property = new PropertyEntity();
        property.setId("001");
        property.setName("property1");
        property.setActivity(activity);
        return property;
    }

    public static LocationEntity getLocationEntity() {
        PropertyEntity property = getPropertyEntity();
        LocationEntity location = new LocationEntity();
        location.setId("A001");
        location.setParent(property);
        location.setName("location1");
        return location;
    }

    public static TableEntity getTableEntity() {
        LocationEntity location = getLocationEntity();
        TableEntity table = new TableEntity();
        table.setId("T001");
        table.setParent(location);
        table.setName("table1");
        return table;
    }


}

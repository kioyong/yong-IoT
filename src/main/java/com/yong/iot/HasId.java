package com.yong.iot;

import java.io.Serializable;

public interface HasId<ID> extends Serializable {
    ID getId();
}

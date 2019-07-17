package com.yong.iot;

import java.io.Serializable;

public interface HasName<N> extends Serializable {

    N getName();
}

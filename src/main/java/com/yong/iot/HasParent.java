package com.yong.iot;

import java.io.Serializable;

public interface HasParent<T> extends Serializable {

    T getParent();
}

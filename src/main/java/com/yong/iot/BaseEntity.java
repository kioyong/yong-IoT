package com.yong.iot;

public abstract class BaseEntity<ID, P, N> implements HasId<ID>,HasParent<P>,HasName<N> {

    private ID id;
    private P parent;
    private N name;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public P getParent() {
        return parent;
    }

    public void setParent(P parent) {
        this.parent = parent;
    }

    public N getName() {
        return name;
    }

    public void setName(N name) {
        this.name = name;
    }
}

package com.sampath.filesystem;

import java.util.Date;

public abstract class AbstractNode {
    private String name;
    private Date createdAt;
    public AbstractNode(String name)
    {
        this.name = name;
        createdAt = new Date();
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}

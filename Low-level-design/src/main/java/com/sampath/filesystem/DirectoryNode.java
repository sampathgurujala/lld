package com.sampath.filesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectoryNode extends AbstractNode {
    private final Map<String,AbstractNode> children;
    public DirectoryNode(String name)
    {
        super(name);
        children = new HashMap<>();
    }
    public void addNode(AbstractNode node)
    {
        children.put(node.getName(), node);
    }
    public AbstractNode getNode(String nodeName)
    {
        return children.getOrDefault(nodeName,null);
    }
    public List<AbstractNode> getChildren()
    {
         return new ArrayList<>(this.children.values());
    }

}

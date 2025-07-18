package com.sampath.filesystem;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface NodeSearchStrategy {
    public List<AbstractNode> search(DirectoryNode root, Map<String, Objects> params);
}

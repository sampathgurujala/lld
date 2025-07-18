package com.sampath.filesystem;

public class FileNode extends AbstractNode{

    private String content;
    private long size;

    public FileNode(String filename)
    {
        super(filename);
        this.content = new String("");
        this.size = 0;
    }

    public void appendContent(String newContent)
    {
        this.content+=newContent;
        this.size+=newContent.length();
    }

    public String getContent()
    {
        return  content;
    }
    public long getSize()
    {
        return size;
    }
}

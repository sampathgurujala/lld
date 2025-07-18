package com.sampath.filesystem;

import java.util.List;
import java.util.Map;

public class FileSystem {
    public static FileSystem INSTANCE=null;
    private DirectoryNode root;

    private FileSystem() {
        this.root = new DirectoryNode("/");
    }


    public synchronized FileSystem getInstance()
    {
        if(INSTANCE==null)
            INSTANCE = new FileSystem();
        return INSTANCE;
    }
    public DirectoryNode traverse(String path, boolean createMissingDirs)
    {
        String[] parts = path.split("/");
        DirectoryNode currentNode = root;
        for(int i=1;i<parts.length;i++)
        {
            if(!(currentNode.getNode(parts[i]) instanceof DirectoryNode))
            {
                if(createMissingDirs)
                currentNode.addNode(new DirectoryNode(parts[i]));
                else
                    return null;
            }
            currentNode = (DirectoryNode) currentNode.getNode(parts[i]);
        }
        return currentNode;
    }
    public void mkdir(String dirPath, boolean createMissingDirs)
    {
       DirectoryNode createdDir =  traverse(dirPath,createMissingDirs);
       if(createdDir==null)
           throw new RuntimeException("Directory was not created!!");

       return;
    }
    public void addFile(String filePath , String content)
    {

        DirectoryNode dirNode = traverse(filePath.substring(0,filePath.lastIndexOf("/")),false);
        if(dirNode==null)
            throw new RuntimeException("invalid Path. Please give valid one!!");
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        FileNode file = (FileNode) dirNode.getNode(fileName);
        if(file==null)
                file = new FileNode(fileName);
        file.appendContent(content);
        dirNode.addNode(file);
        return;
    }

    public List<AbstractNode> search(NdoeSearchStrategy strategy, Map<String,Object> searchParams)
    {

    }

}

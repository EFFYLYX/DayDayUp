package designpattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
运用共享急速有效的支持大量细粒度的对象

如果系统有大量类似的对象，可以节省大量的内存及CPU资源

String就是享元模式 flyweight
 */
public class FlyWeightTest {
    public static void main(String[] args){
        TreeFactory treeFactory = new TreeFactory();

        //从treeFactory找tree，如果没有，则建立tree，将treenode的tree属性指向该tree
        //从treeFactory找到tree，如果已经建立了tree，将treenode的tree属性指向该tree
        TreeNode treeNode = new TreeNode(3,4,TreeFactory.getTree("xxx", "xxxxx"));
        TreeNode treeNode1 = new TreeNode(5,4,TreeFactory.getTree("xxx", "xxxxx"));


        TreeNode treeNode2 = new TreeNode(1,4,TreeFactory.getTree("yyy", "xxxxx"));
        TreeNode treeNode3 = new TreeNode(5,9,TreeFactory.getTree("yyy", "xxxxx"));


    }
}

class TreeFactory{
    private static Map<String,Tree> map = new ConcurrentHashMap<>();
    public static Tree getTree(String name, String data){
        if(map.containsKey(name)){
            return map.get(name);
        }
        Tree tree = new Tree(name,data);
        map.put(name,tree);
        return tree;
    }
}

class TreeNode{
    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree){
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}

class Tree{
    private final String name;
    private final String data;

    public Tree(String name, String data){
        this.name = name;
        this.data = data;

    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}

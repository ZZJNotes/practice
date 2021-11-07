package com.alitest;

import java.util.List;

/**
 * @Author zj
 * @Date 2021/10/20 21:19
 * @Description
 */

public class Node {

    private String path;

    private String value;

    private List<Node> children;

    public Node(){

    }

    public Node(String path, String value, List<Node> children) {
        this.path = path;
        this.value = value;
        this.children = children;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}

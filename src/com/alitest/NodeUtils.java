package com.alitest;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author zj
 * @Date 2021/10/20 21:20
 * @Description
 */

public class NodeUtils {

    public static Node getNode(List<Node> nodes, String path) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getChildren().size() != 0) {
                getNode(nodes.get(i).getChildren(), path);
            }
            if (nodes.get(i).getPath().equals(path)) {
                return nodes.get(i);
            }
            return new Node();
        }
        return new Node();


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Node children20 = new Node("level0_0/level1_0/level2_0", "value", new ArrayList<>());
        Node children21 = new Node("level0_0/level1_0/level2_1", "value", new ArrayList<>());
        Node children22 = new Node("level0_0/level1_0/level2_1", "value", new ArrayList<>());
        ArrayList<Node> children1 = new ArrayList<>();
        children1.add(children20);
        children1.add(children21);
        children1.add(children22);
        List<Node> nodes = new ArrayList<>();
        Node node = new Node("level0_0/level1_0/","value", children1);
        nodes.add(node);
        Node node1 = NodeUtils.getNode(nodes, "level0_0/level1_0/level2_1");
        System.out.println(node1.getPath());
    }
}

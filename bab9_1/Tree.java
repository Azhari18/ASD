package bab9_1;

import java.util.Random;

class Node {
    int data;
    Node nodeKiri, nodeKanan;

    public Node(int data) {
        this.data = data;
        nodeKiri = nodeKanan = null;
    }

    public void sisipDt(int dtSisip) {
        if (dtSisip < data) {
            if (nodeKiri == null) {
                nodeKiri = new Node(dtSisip);
            } else {
                nodeKiri.sisipDt(dtSisip);
            }
        } else if (dtSisip > data) {
            if (nodeKanan == null) {
                nodeKanan = new Node(dtSisip);
            } else {
                nodeKanan.sisipDt(dtSisip);
            }
        }
    }
}


public class Tree {
    Node root;

    public void sisipDtNode(int dtSisip) {
        if (root == null) {
            root = new Node(dtSisip);
        } else {
            root.sisipDt(dtSisip);
        }
    }

    public void urutTraversal() {
        urut(root);
    }

    private void urut(Node node) {
        if (node == null) {
            return;
        }
        urut(node.nodeKanan);
        System.out.printf("%d ", node.data);
        urut(node.nodeKiri);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Random random = new Random();
        int nilai;

        System.out.println("sisip nilai data berikut : ");
        for (int i = 0; i < 10; i++) {
            nilai = random.nextInt(100);
            System.out.print(nilai + " ");
            tree.sisipDtNode(nilai);
        }

        System.out.println("\n\nUrut traversal");
        tree.urutTraversal();
    }
}
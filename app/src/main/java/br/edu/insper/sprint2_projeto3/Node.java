package br.edu.insper.sprint2_projeto3;


import java.util.ArrayList;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private String simbolo;


    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.simbolo = null;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public String getSimbolo(){
        return simbolo;
    }

    public void setSimbolo(String simbolo){
        this.simbolo = simbolo;
    }

    public void setLeft(Node left) {
        this.left = left;

    }

    public Node getRight() {
        return right;
    }


    public void setRight(Node right) {
        this.right = right;
    }
}

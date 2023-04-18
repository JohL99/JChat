package jsjf.obj;

import jsjf.Message;

public class Node {

    private Message message;
    private Node left;
    private Node right;

    public Node(Message message) {
        setMessage(message);;
        left = null;
        right = null;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Node getLeft() {
        return left;
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

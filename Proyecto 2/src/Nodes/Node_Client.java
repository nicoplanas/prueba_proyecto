package Nodes;

import Classes.Class_Client;

public class Node_Client {
    private Class_Client client;
    private Node_Client next;

    public Node_Client(Class_Client client) {
        this.client = client;
        this.next = null;
    }
    
    // MÉTODOS GET.
    public Class_Client getClient() {
        return client;
    }

    public Node_Client getNext() {
        return next;
    }

    // MÉTODOS SET.
    public void setClient(Class_Client client) {
        this.client = client;
    }

    public void setNext(Node_Client next) {
        this.next = next;
    }
}
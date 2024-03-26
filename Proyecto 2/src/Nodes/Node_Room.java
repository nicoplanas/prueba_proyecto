package Nodes;

import Classes.Class_Room;

public class Node_Room {
    private int key;
    private Class_Room room;
    private Node_Room right;
    private Node_Room left;
    
    /**
     * Método constructor de la clase nodo.
     * @param key atributo de tipo int identificador del nodo.
     * @param room atributo de tipo objeto valor que contiene el nodo.
     */
    public Node_Room(int key, Class_Room room) {
        this.key = key;
        this.room = room;
        this.right = null;
        this.left = null;
    }
    
    /**
     * Este método inicializa la inserción recursiva de nodos.
     * @param nodo_room el número que identifica al nodo.
     */
    public void insertNodo(Node_Room nodo_room) {
        
        // VALIDAMOS SI ES MENOR O MAYOR QUE EL PADRE.
        
        if (nodo_room.getKey() < this.key) {
            
            // SE INSERTA EN EL LADO IZQUIERDO.
            
            if (this.left == null) {
                this.left = nodo_room;
            } else {
                this.left.insertNodo(nodo_room);
            }
        } else {
            
            // SE INSERTA EN EL LADO DERECHO.
            
            if (this.right == null) {
                this.right = nodo_room;
            } else {
                this.right.insertNodo(nodo_room);
            }
        }
    }
    
    // MÉTODOS GET.
    public int getKey() {
        return key;
    }

    public Class_Room getRoom() {
        return room;
    }

    public Node_Room getRight() {
        return right;
    }

    public Node_Room getLeft() {
        return left;
    }
    
    // MÉTODOS SET.
    public void setKey(int key) {
        this.key = key;
    }

    public void setRoom(Class_Room room) {
        this.room = room;
    }

    public void setRight(Node_Room right) {
        this.right = right;
    }

    public void setLeft(Node_Room left) {
        this.left = left;
    }
}

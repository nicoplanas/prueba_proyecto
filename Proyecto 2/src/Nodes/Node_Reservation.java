package Nodes;
import Classes.Class_Reservation;

/**
 * Clase para crear Nodos de tipo Reservación para Arboles.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Node_Reservation {
    private int key;
    private Class_Reservation reservation;
    private Node_Reservation right;
    private Node_Reservation left;
    
    /**
     * Método constructor de la clase Node_Reservation.
     * @param key atributo de tipo int identificador del nodo.
     * @param reservation atributo de tipo objeto valor que contiene el nodo.
     */
    public Node_Reservation(int key, Class_Reservation reservation) {
        this.key = key;
        this.reservation = reservation;
        this.right = null;
        this.left = null;
    }
    
    /**
     * Este método inicializa la inserción recursiva de nodos.
     * @param reservation el elemento que guarda el nodo.
     */
    public void insertNodo(Node_Reservation reservation) {
        
        // VALIDAMOS SI ES MENOR O MAYOR QUE EL PADRE.
        
        if (reservation.getKey() < this.key) {
            
            // SE INSERTA EN EL LADO IZQUIERDO.
            
            if (this.left == null) {
                this.left = reservation;
            } else {
                this.left.insertNodo(reservation);
            }
        } else {
            
            // SE INSERTA EN EL LADO DERECHO.
            
            if (this.right == null) {
                this.right = reservation;
            } else {
                this.right.insertNodo(reservation);
            }
        }
    }
    
    /**
     * Método para comprobar si un nodo es hoja
     * @return retorna true si es hoja y false si no lo es.
     */
    public boolean isLeaf(){
        return getLeft() == null && getRight() == null;
    }

    /**
     * Método para saber si solo tiene hijo izquierdo.
     * @return retorna true si tiene hijo izquierdo.
     */
    public boolean hasLeftSon() {
        return getLeft() != null;
    }

    /**
     * Método para saber si solo tiene hijo derecho.
     * @return retorna true si tiene hijo derecho.
     */
    public boolean hasRightSon() {
        return getRight() != null;
    }

    //MÉTODOS GET
    public int getKey() {
        return key;
    }
    
    public Class_Reservation getReservation() {
        return reservation;
    }
    
    public Node_Reservation getRight() {
        return right;
    }
    
    public Node_Reservation getLeft() {
        return left;
    }

    //MÉTODOS SET.
    public void setKey(int key) {
        this.key = key;
    }

    public void setReservation(Class_Reservation reservation) {
        this.reservation = reservation;
    }

    public void setRight(Node_Reservation right) {
        this.right = right;
    }

    public void setLeft(Node_Reservation left) {
        this.left = left;
    }
    
}
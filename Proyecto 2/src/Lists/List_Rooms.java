package Lists;

import Nodes.Node_Room;

/**
 * Clase para crear Lista de habitaciones.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class List_Rooms {
    private Node_Room head;
    int size;

    /**
     * Constructor de la clase List_Rooms.
     */
    public List_Rooms() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Método para insertar al inicio.
     * @param room Habitación que se desea insertar en la lista.
     */
    public void insert(Node_Room room) {
        Node_Room currentRoom = head;
        
        if (this.isEmpty()) {
            head = room;
        } else {
            while (currentRoom.getRight() != null) {
                currentRoom = currentRoom.getRight();
            }
        }
        size ++;
    }

    /**
     * Método para imprimir la lista de habitaciones.
     * @return Retorna un String con los atributos de las habitación contaneados.
     */
    public String print() {
        Node_Room currentNodo = head;
        String result = "LISTA:\n\n";
        
        while (currentNodo != null) {
            result += Integer.toString(currentNodo.getRoom().getNumber()) + "\n";
            currentNodo = currentNodo.getRight();
        }
        return result;
    }
    
    // MÉTODOS GET.
    public Node_Room getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    // MÉTODOS SET.
    public void setHead(Node_Room head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
}

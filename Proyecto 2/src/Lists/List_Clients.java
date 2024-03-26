package Lists;

import Nodes.Node_Client;

/**
 * Clase para crear Lista de Clientes.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class List_Clients {
    private Node_Client peak;
    int size;

    /**
     * Constructor de la clase List_Clients.
     */
    public List_Clients() {
        this.peak = null;
        this.size = 0;
    }
    
    /**
     * Método para insertar al inicio.
     * @param client Cliente que se desea insertar.
     */
    public void insertBegining(Node_Client client) {
        if (isEmpty()) {
            peak = client;
        } else {
            client.setNext(peak);
            peak = client;
        }
        size ++;
    }

    // MÉTODOS GET.
    public Node_Client getHead() {
        return peak;
    }

    public int getSize() {
        return size;
    }

    // MÉTODOS SET.
    public void setHead(Node_Client head) {
        this.peak = head;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        return peak == null;
    }
}

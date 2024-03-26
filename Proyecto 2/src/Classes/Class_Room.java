package Classes;

import Lists.List_Clients;
import Nodes.Node_Client;

/**
 * Clase Habitación.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Class_Room {
    private int number;
    private String type;
    private int floor;
    private List_Clients clientHistory;
    private boolean available;

    /**
     * Constructor de la clase Class_Room.
     * @param number número de habitación.
     * @param type  tipo de habitación.
     * @param floor piso donde está ubicada la habitación.
     * @param clientHistory historial de clientes que usaron esa habitación.
     */
    public Class_Room(int number, String type, int floor, List_Clients clientHistory) {
        this.number = number;
        this.type = type;
        this.floor = floor;
        this.clientHistory = clientHistory;
        this.available = true;
    }
    
    /**
     * Método para imprimir el historial de clientes que usaron dicha habitación.
     * @return Retorna un String con toda la información del atributo clientHistory.
     */
    public String printHistory() {
        String result = "HISTORIAL DE CLIENTES - HABITACIÓN #" + number + ":\n\n";
        int idx = 1;
        
        Node_Client aux = clientHistory.getHead();
        
        while (aux != null) {
            result += idx + ") " + aux.getClient().getName() + ".\n";
            aux = aux.getNext();
            idx ++;
        }
        return result;
    }
    
    // MÉTODOS GET.
    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public int getFloor() {
        return floor;
    }

    public List_Clients getClientHistory() {
        return clientHistory;
    }

    public boolean getAvailable() {
        return available;
    }
    
    // MÉTODOS SET.
    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setClientHistory(List_Clients clientHistory) {
        this.clientHistory = clientHistory;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

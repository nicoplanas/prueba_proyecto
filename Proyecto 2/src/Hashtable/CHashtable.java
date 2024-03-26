package Hashtable;

import Classes.Class_Client;
import Classes.Class_Reservation;
import Classes.Class_Room;
import Main.Global;
import Nodes.Node_Client;
import Nodes.Node_Reservation;
import Nodes.Node_Reservation_List;
import Nodes.Node_Room;

/**
 * Clase para crear el Hash Table.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class CHashtable {
    private Node_Reservation_List[] clientTable;
    private int capacity;

    /**
     * Constructor de la Clase CHashtable
     * @param capacity Capacidad del hashTable.
     */
    public CHashtable(int capacity) {
        this.capacity = capacity;
        clientTable = new Node_Reservation_List[capacity];
    }

    /**
     * Este método se encarga de calcular el índice del dato que se desea guardar.
     * @param name el nombre del cliente que se desea buscar.
     * @param lastname el apellido del cliente que se desea buscar.
     * @return retorna la posición donde se almacenará el nuevo elemento en el Hash Table.
     */
    public int getHashIndex(String name, String lastname) {
        
        // SUMA LOS VALORES ASCII DE LOS CARACTERES DEL NOMBRE Y APELLIDO.
        int characterSum = 0;
        
        for (char c : (name + lastname).toCharArray()){
            characterSum += (int) c;
        }
        
        // RETORNA EL MÓDULO DE LA SUMA DE LOS CARACTERES CON LA CAPACIDAD DE LA TABLA.
        return characterSum % capacity;
    }

    /**
     * Método para añadir un elemento Nodo al HashTable.
     * @param client Cliente que se desea añadir.
     * @param arrival_date Fecha de llegada del cliente.
     */
    public void addClientTable(Class_Client client, String arrival_date){
        int index = getHashIndex(client.getName(), client.getLastname());
        
        if (clientTable[index] != null) {
            Node_Reservation_List currentNode = clientTable[index];
             
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }

            currentNode.setNext(new Node_Reservation_List(new Class_Reservation(client, null, arrival_date, null)));
        } else {
            clientTable[index] = new Node_Reservation_List(new Class_Reservation(client, null, arrival_date, null));
        }
    }
    
    /**
     * Método para eliminar al cliente del Hash Table.
     * @param id
     * @return 
     */
    public Class_Client checkInClient(int id) {
        Node_Reservation reservation = Global.getReservations().search(id, Global.getReservations().getRoot());
        String roomType = reservation.getReservation().getRoom_type();

        // BUSCAMOS LA HABITACIÓN QUE ESTÉ DISPONIBLE DEPENDIENDO DEL TIPO QUE DESEE EL CLIENTE.
        Class_Room roomAvailable = Global.getRooms().searchRoomType(roomType, Global.getRooms().getRoot());
        roomAvailable.setAvailable(false);

        // AÑADIMOS EL CLIENTE AL REGISTRO DE ESTADO EN EL HASHTABLE.
        Global.getClients().addClientTable(reservation.getReservation().getClient(), reservation.getReservation().getArrival());
        
        // ASIGNAMOS LA HABITACIÓN AL CLIENTE.
        reservation.getReservation().getClient().setRoomNumber(Integer.toString(roomAvailable.getNumber()));

        // EN EL ARBOL RESERVACIONES ELIMINAMOS LA RESERVACIÓN DEL CLIENTE.
        Global.getReservations().delete(id, Global.getReservations().getRoot(), null);
        
        return reservation.getReservation().getClient();
    }
    
    /**
     * Método para eliminar al cliente del Hash Table.
     * @param name Nombre del Cliente.
     * @param lastname Apellido del Cliente.
     * @return 
     */
    public Class_Client checkOutClient(String name, String lastname) {
        
        int index = getHashIndex(name, lastname);
        Node_Reservation_List currentNode = clientTable[index];
        Node_Reservation_List prevNode = clientTable[index];

        if (clientTable[index] != null) {
            if (currentNode.getNext() != null) {
                while (currentNode != null) {
                    if (currentNode.getReservation().getClient().getName().equals(name) && currentNode.getReservation().getClient().getLastname().equals(lastname)) {
                        
                        int room_number = Integer.parseInt(currentNode.getReservation().getClient().getRoomNumber());
                        Node_Room room = Global.getRooms().search(room_number, Global.getRooms().getRoot());
                        Node_Client client = new Node_Client(currentNode.getReservation().getClient());
                        room.getRoom().getClientHistory().insertBegining(client);
                        
                        if (clientTable[index] == currentNode) {
                            clientTable[index] = currentNode.getNext();
                            break;
                        } else {
                            prevNode.setNext(currentNode.getNext());
                            break; 
                        }
                    }
                    prevNode = currentNode;
                    currentNode = currentNode.getNext();
                    }
            } else if (currentNode.getReservation().getClient().getName().equals(name) && currentNode.getReservation().getClient().getLastname().equals(lastname)) {
                
                int room_number = Integer.parseInt(currentNode.getReservation().getClient().getRoomNumber());
                Node_Room room = Global.getRooms().search(room_number, Global.getRooms().getRoot());
                Node_Client client = new Node_Client(currentNode.getReservation().getClient());
                room.getRoom().getClientHistory().insertBegining(client);

                clientTable[index] = null;
                }
            }
            return currentNode.getReservation().getClient();
        }

    /**
     * Método para identificar en el Arbol de habitaciones, las habitaciones OCUPADAS.
     */
    public void notAvailableRooms(){
        for (int i = 0; i < clientTable.length-1; i++) {
            while(clientTable[i] != null){
                if(clientTable[i].getReservation().getClient().getRoomNumber() != null){
                    int numberRoom = Integer.parseInt(clientTable[i].getReservation().getClient().getRoomNumber());
                    Class_Room room = Global.getRooms().search(numberRoom, Global.getRooms().getRoot()).getRoom();
                    room.setAvailable(false);
                }
                clientTable[i] = clientTable[i].getNext();
            }
        }
    }

    /**
     * Este método busca al cliente en base a su nombre y apellido.
     * @param name Nombre del Cliente.
     * @param lastname Apellido del Cliente.
     * @return Retorna la información del cliente.
     */
    public String searchClient(String name, String lastname){
        
        int index = getHashIndex(name, lastname);
        Node_Reservation_List currentNode = clientTable[index];
        String searchResult = "";
        
        while (currentNode != null) {
            if (currentNode.getReservation().getClient().getName().equals(name) && currentNode.getReservation().getClient().getLastname().equals(lastname)) {
                searchResult += currentNode.getReservation().getClient().showInfoStatus() + "Llegada: " + currentNode.getReservation().getArrival();
            } currentNode = currentNode.getNext();
        }
        return searchResult;
    }

    // MÉTODOS GET.
    public Node_Reservation_List[] getClientTable() {
        return clientTable;
    }

    public int getCapacity() {
        return capacity;
    }
}

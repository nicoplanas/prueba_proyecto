package Main;

import Lists.List_Clients;
import Hashtable.CHashtable;
import Classes.*;
import Nodes.*;
import Trees.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 * Clase para crear un objeto de tipo global.
 * @author nicolasplanas
 */
public class Global {
    private static CHashtable clients = new CHashtable(1000);
    private static Tree_Reservations reservations = new Tree_Reservations();
    private static Tree_Rooms rooms = new Tree_Rooms();
    private static String filePathReservations = "/Users/nicolasplanas/Desktop/Proyecto 2/Booking_hotel - reservas.csv/";
    private static String filePathRooms = "/Users/nicolasplanas/Desktop/Proyecto 2/Booking_hotel - habitaciones.csv";
    private static String filePathHistoric = "/Users/nicolasplanas/Desktop/Proyecto 2/Booking_hotel - Histórico.csv";
    private static String filePathStatus = "/Users/nicolasplanas/Desktop/Proyecto 2/Booking_hotel - estado.csv";
    
    /**
     * Este método lee el documento de tipo 'csv' de las reservaciones, crea instancias
     * de tipo 'Class_Client' y 'Class_Reservation' las cuales guarda dentro de un nodo
     * para posteriomente insertalo en el árbol.
     */
    public static void cvsReaderReservations() {
        String line = "";
        int cont = 0;
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePathReservations));

            while ((line = br.readLine()) != null) {
                if (cont > 0) {
                    String[] values = line.split(",");
                    Class_Client client = new Class_Client(values[0], values[1], values[2], values[3], values[4], values[6], null);
                    Class_Reservation reservation = new Class_Reservation(client, values[5], values[7], values[8]);
                    Node_Reservation nodo_reservation = new Node_Reservation(idInt(client.getId()), reservation);   
                    Global.getReservations().insertar(nodo_reservation);
                }
                cont += 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Ups! Algo salio mal...");
        }
    }

    /**
     * Este método lee el documento de tipo 'csv' de las habitaciones y el histórico, crea instancias
     * de tipo 'Class_Room' y 'Class_Client' las cuales guarda dentro de un nodo
     * para posteriomente insertalo en el árbol.
     */
    public static void cvsReaderRoomsHistory() {
        String line = "";
        String line2 = "";
        
        int cont = 0;
        int cont2 = 0;
        
        try {
            BufferedReader br_historic = new BufferedReader(new FileReader(filePathHistoric));
            BufferedReader br_rooms = new BufferedReader(new FileReader(filePathRooms));

            while ((line = br_rooms.readLine()) != null) {
                List_Clients list = new List_Clients();
                if (cont > 0) {
                    String[] values = line.split(",");
                    Class_Room room = new Class_Room(Integer.parseInt(values[0]), values[1],Integer.parseInt(values[2]), list);
                    Node_Room nodo_room= new Node_Room(room.getNumber(), room);
                    rooms.insertar(nodo_room);
                }
                cont += 1;
            }

            while ((line2 = br_historic.readLine()) != null) {
                Node_Room currentRoom = rooms.getRoot();

                if (cont2 > 0) {
                    String[] values = line2.split(",");
                    Class_Client client = new Class_Client(values[0], values[1], values[2], values[3], values[4], null, values[6]);
                    Node_Client nodo_client = new Node_Client(client);
                    
                    while (currentRoom.getKey() != Integer.parseInt(nodo_client.getClient().getRoomNumber())) {
                        if (currentRoom.getKey() > Integer.parseInt(nodo_client.getClient().getRoomNumber())) {
                            currentRoom = currentRoom.getLeft();
                        } else {currentRoom = currentRoom.getRight();}
                    } if (currentRoom.getKey() == Integer.parseInt(nodo_client.getClient().getRoomNumber())) {
                        currentRoom.getRoom().getClientHistory().insertBegining(nodo_client);
                        }
                    }
                cont2 += 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Ups! Algo salio mal...");
        }
    }

    /**
     * Este método lee el documento de tipo 'csv' de los clientes que se encuentra hospedados
     * actualmente en alguna habitación, crea instancias de tipo 'Class_Client' y las guarda 
     * dentro de un nodo para posteriomente insertalo en un hash table.
     */
    public static void cvsReaderHash() {
        String line = "";
        int cont = 0;
    
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/nicolasplanas/Desktop/Proyecto 2/Booking_hotel - estado.csv"));

            while ((line = br.readLine()) != null) {
                if (cont > 0) {
                    String[] values = line.split(",");
                    if (!"".equals(values[0])) {
                        Class_Client client = new Class_Client(null, values[1], values[2], values[3], values[4], values[5], values[0]);
                        clients.addClientTable(client, values[6]);
                        }
                    }
                cont += 1;
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Ups! Algo salio mal...");
        }
    }
    
    /**
     * Este método convierte la cedula de tipo 'String' que recibe del 'csv'
     * y lo convierte en un 'int', al hacerle un 'split(".")' para luego sumar
     * los valores de este array en una variable 'String' vacía la
     * cual se castea a un 'int'.
     * @param value
     * @return 
     */
    private static int idInt(String value) {
        String idStr = "";
        String[] client_id = value.split("\\.");

        for (int i = 0; i < client_id.length; i++) {
            idStr += client_id[i];
        }
        return Integer.parseInt(idStr);
    }

    // MÉTODOS GET.
    public static Tree_Reservations getReservations() {
        return reservations;
    }

    public static Tree_Rooms getRooms() {
        return rooms;
    }

    public static CHashtable getClients() {
        return clients;
    }
}

package Classes;

/**
 * Clase Reservación
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Class_Reservation {
    private Class_Client client;
    private String room_type;
    private String arrival;
    private String departure;

    /**
     * Constructor de la clase Class_Reservation.
     * @param client Cliente que pertenece a dicha reservación.
     * @param room_type Tipo de habitación que desea el cliente.
     * @param arrival   Llegada del cliente.
     * @param departure Salida del cliente.
     */
    public Class_Reservation(Class_Client client, String room_type, String arrival, String departure) {
        this.client = client;
        this.room_type = room_type;
        this.arrival = arrival;
        this.departure = departure;
    }

    // METODOS GET.
    public Class_Client getClient() {
        return client;
    }

    public String getRoom_type() {
        return room_type;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    // METODOS SET.
    public void setClient(Class_Client client) {
        this.client = client;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
}

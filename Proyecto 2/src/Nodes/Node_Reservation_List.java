package Nodes;

import Classes.Class_Reservation;

/**
 *
 * @author nicolasplanas
 */
public class Node_Reservation_List {
    private Class_Reservation reservation;
    private Node_Reservation_List next;

    public Node_Reservation_List(Class_Reservation reservation) {
        this.reservation = reservation;
        this.next = null;
    }

    public Class_Reservation getReservation() {
        return reservation;
    }

    public Node_Reservation_List getNext() {
        return next;
    }

    public void setReservation(Class_Reservation reservation) {
        this.reservation = reservation;
    }

    public void setNext(Node_Reservation_List next) {
        this.next = next;
    }
}

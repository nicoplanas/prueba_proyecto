package Classes;

/**
 * Clase Cliente.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Class_Client {
    private String id;
    private String name;
    private String lastname;
    private String email;
    private String gender;
    private String phone;
    private String room_number;

    /**
     * Constructor de la clase Class_Client.
     * @param id ID del Cliente.
     * @param name Nombre del Cliente.
     * @param lastname Apellido del Cliente.
     * @param email Correo del Cliente.
     * @param gender Sexo del Cliente.
     * @param phone Número de telefono del cliente.
     * @param room_number Número de habitación del cliente.
     */
    public Class_Client(String id, String name, String lastname, String email, String gender, String phone, String room_number) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.room_number = room_number;
    }

    /**
     * Método para obtener toda la información del cliente.
     * @return Retorna un String con todos los atributos contenados.
     */
    public String showInfo() {
        String result = "";
        result += "Nombre y apellido: " + name + " " + lastname + "\n";
        result += "Cédula: " + id + "\n";
        result += "Email: " + email + "\n";
        result += "Género: " + gender + "\n";
        result += "Telefono: " + phone + "\n";
        return result;
    }
    
    /**
     * Método para obtener toda la información del estados del Cliente.
     * @return Retorna un String con todos los atributos contenados.
     */
    public String showInfoStatus() {
        String result = "";
        result += "Habitación: " + room_number + "\n";
        result += "Nombre y apellido: " + name + " " + lastname + "\n";
        result += "Email: " + email + "\n";
        result += "Género: " + gender + "\n";
        result += "Telefono: " + phone + "\n";
        return result;
    }

    // MÉTODOS GET.
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }
    
    public String getRoomNumber() {
        return room_number;
    }
    
    // MÉTODOS SET.
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setRoomNumber(String room_number) {
        this.room_number = room_number;
    }
}

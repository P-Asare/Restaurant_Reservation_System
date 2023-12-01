import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Reservation {

    private static ArrayList<Integer> allIds = new ArrayList<>(100);
    private static int maxId = 100;
    private int reservationId;
    private Customer customer;
    private LocalDate date;
    private LocalTime time;
    private Table table;

    /**
     * Constructor for Reservation object
     * 
     * @param id of reservation
     * @param cName 
     * @param table being reserved`
     */
    public Reservation(Customer customer, Table table){
        this.setReservationId();
        this.setCustomer(customer);
        this.setTable(table);
        this.setTime();
        this.setDate();

    }

    /**
     * Getter for reservation Id
     * 
     * @return reservationId
     */
    public int getReservationId() {
      return this.reservationId;
    }

    /**
     * setter for reservation id by automatically
     * generating integer between 0 and 100 
     * and assigning id
     * 
     * @param value
     */
    public void setReservationId() {
        Random rand = new Random();
        int id = 0;
        
        // find the right integer to be id of reservation
        while (true){
            id = rand.nextInt(Reservation.maxId);
            if (!Reservation.allIds.contains(id)) break;
        }

        Reservation.allIds.add(id);
        this.reservationId = id;
    }

    /**
     * getter for customer name
     * 
     * @return customer name
     */
    public Customer getCustomer() {
      return this.customer;
    }

    /**
     * setter for customer name
     * 
     * @param value
     */
    public void setCustomer(Customer value) {
      this.customer = value;
    }

    /**
     * getter for date of reservation
     * 
     * @return local date of reservation
     */
    public LocalDate getDate() {
      return this.date;
    }

    /**
     * setter for date of reservation
     * 
     * @param value
     */
    public void setDate() {
      this.date = LocalDate.now();
    }

    /**
     * getter for time of reservation
     * 
     * @return local time of reservation
     */
    public LocalTime getTime() {
      return this.time;
    }

    /**
     * setter for time of reservation
     * 
     * @param value
     */
    public void setTime() {
      this.time = LocalTime.now();
    }

    /**
     * getter for table reserved
     * 
     * @return table reserved
     */
    public Table getTable() {
      return this.table;
    }

    /**
     * setter for table reserved
     * 
     * @param value
     */
    public void setTable(Table value) {
      this.table = value;
    }

    @Override
    public String toString(){
        return "Id: " + this.reservationId + 
            "\nTableseats: " + this.table.getSeats() + 
            "\nDatetime: " + this.getDate() + " " + this.getTime();
    }
}

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {

    private AvailableTables tables;
    private ReservationsBooking reservations;
    private WaitList waitListManagement;
    private int reservationCapacity = 23; // limits the number of tables to 23 tables
    private int waitListCapacity = 7; // allow a maximum of 7 waitlisters only

    /**
     * Constructor for a restaurant
     * that allows a reservation capacity of 23
     * and a waitlist capacity of 7
     * 
     * @throws Exception
     */
    public Restaurant() throws Exception{
        tables = new AvailableTables();
        reservations = new ReservationsBooking(reservationCapacity);
        waitListManagement = new WaitList(waitListCapacity);
        this.populateRestaurantTables();
    }

    /**
     * Create tables with varying seating numbers
     * for the restaurant
     * 
     * @throws Exception
     */
    public void populateRestaurantTables() throws Exception{

        ArrayList<Integer> capacities = new ArrayList<>();
        Random rand = new Random();

        // randomly assign table sizes for table objects
        // random assignment to prevent binary tree from being unbalanced
        for (; capacities.size() < reservationCapacity; ){
            int cap = rand.nextInt(reservationCapacity) + 1;
            if (capacities.contains(cap)) continue; // tables are not to have repeating seat capacities

            this.tables.insert(cap);
            capacities.add(cap);
        }
    }

    /**
     * Book table for a customer who made a 
     * booking 
     * 
     * @param cName
     * @param criteria
     * @throws Exception
     */
    public void bookTable(String cName, int criteria) throws Exception{

        Table tbl = this.tables.search(criteria); // Find table for customer
        this.tables.removeOccupiedTable(criteria); // Remove table from free tables
        this.reservations.insert(cName, tbl); // reserve table for specified customer in hashtable
    }

    /**
     * Cancel reservation made by a customer
     * 
     * @param cName
     * @throws Exception
     */
    public void cancelReservation(String cName) throws Exception{
        
        // get table and change the status of the table
        Table tbl = this.reservations.retrieve(cName);
        tbl.setStatus(1);

        this.reservations.delete(cName); // delete from reserved tables in hashtable
        this.tables.insert(tbl.getSeats()); // put table back in binary tree

    }

    /**
     * Find and display the reservation
     * Details of a customer
     * 
     * @param cName
     */
    public void findReservation(String cName) throws Exception{

        Reservation reserv = this.reservations.retrieveReservation(cName);
        System.out.println(reserv);
    }

    /**
     * Add a walk in customer to the waitlist
     */
    public void addWalkInCustomer(String cName) throws Exception{
        this.waitListManagement.enqueue(cName);
    }

    /**
     * Match a walk in customer with a table
     * and reservation
     * 
     * @param cName
     * @param criteria
     * @throws Exception
     */
    public void offerTable(String cName, int criteria) throws Exception{
        Table tbl = this.tables.search(criteria); // find table for customer in waitlist
        this.tables.removeOccupiedTable(criteria); // remove specified table
        this.reservations.insert(cName, tbl); // match the table to the customer as occupied or booked
    }

    /**
     * Provides the number of occupied tables
     * out of the number of available tables
     * 
     * @return String describing occupancy
     */
    public String occupancyStatus(){

        int occupied = this.reservationCapacity - this.reservations.tableLength(); // calculate the free tables
        return occupied + " out of " + this.reservationCapacity;
    }
    
}

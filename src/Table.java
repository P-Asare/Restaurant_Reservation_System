import java.util.ArrayList;
import java.util.Random;

public class Table{

    private static ArrayList<Integer> allIds = new ArrayList<>();
    private int seats;
    private enum status {TAKEN, FREE};
    private status statusVariable;
    private int tableId;
    private static int maxId = 100;

    /**
     * Constructor for Table object
     * 
     * @param seats
     */
    public Table(int seats) throws Exception{
        this.setSeats(seats);
        this.setTableId();
        this.setStatus(1);
    }

    /**
     * Getter for the number of seats at
     * a table
     * 
     * @return number of seats
     */
    public int getSeats(){
        return this.seats;
    }

    /**
     * Setter for the number of seats at
     * a table
     * 
     * @param seats
     */
    public void setSeats(int seats){
        this.seats = seats;
    }

    /**
     * Getter for the status of a table
     * 
     * @return the status of the table
     */
    public status getStatus(){
        return statusVariable;
    }

    /**
     * Set the status of a table 
     * to taken or free where 1
     * is free and 2 is taken
     * 
     * @param statusPick
     * @throws Exception
     */
    public void setStatus(int statusPick) throws Exception{

        if (statusPick == 1) this.statusVariable = status.FREE;
        else if (statusPick == 2) this.statusVariable = status.TAKEN;
        else throw new Exception("Options are only 1 and 2");
    }

    /**
     * Set the id of a particular table
     * by random assignment
     * 
     */
    public void setTableId(){
        Random rand = new Random();
        int id = 0;
        
        // find the right integer to be id of reservation
        while (true){
            id = rand.nextInt(Table.maxId);
            if (!Table.allIds.contains(id)) break;
        }

        this.tableId = id;
    }

    /**
     * Getter for the table ide
     * 
     * @return int of table id
     */
    public int getTableId(){
        return this.tableId;
    }

    @Override
    public String toString(){
        return "ID: "+getTableId() + ", Seats: " + 
            getSeats() + ", Status: " + getStatus() + "\n";
    }
}
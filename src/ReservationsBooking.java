public class ReservationsBooking {

    private int size;
    private Reservation[] bookings;
    private int capacity;

    public ReservationsBooking(int capacity) throws Exception{
        if (!this.isPrime(capacity)) throw new Exception("Enter a prime number");

        bookings = new Reservation[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * Check whether or not reservations
     * have been made
     * 
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * Check the number of reservations that have been made
     * 
     * @return size of table
     */
    public int tableLength(){
        return this.size;
    }

    /**
     * Primary hash function for
     * hash table
     * 
     * @param key
     * @return hash value
     */
    public int primaryHash(String key){

        int hash = Math.abs(key.hashCode());
        return (hash % this.capacity);
    }

    /**
     * Secondary hash function 
     * 
     * @param key
     * @return hash value
     */
    public int secondaryHash(String key){
        int numToUse = nextPrime(this.capacity);
        int hash = Math.abs(key.hashCode());
        return (numToUse - (hash % numToUse));
    }

    /**
     * helper function to check if a number
     * is a prime number. Helps the hashing
     * functions
     * 
     * @param num
     * @return true/false
     */
    private boolean isPrime(int num){
        boolean notPrime = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                notPrime = true;
                break;
            }
        }

        return !notPrime;
    }

    /**
     * Finds the closest prime number close to
     * but less than the capacity of the hashtable
     * 
     * @param num
     * @return integer
     */
    private int nextPrime(int num){
        
        int nextNum = num - 1;

        while (!isPrime(nextNum)){
            nextNum--;
        }

        return nextNum;
    }

    /**
     * Insert a reservation object into the 
     * hashtable but with customer name as key and the
     * reserved table as value
     * 
     * @param cName
     * @param table
     * @throws Exception
     */
    public void insert(String cName, Table table) throws Exception{

        if (this.size == this.capacity) throw new Exception("The hash table is full");

        int newIndex = -1;
        int primaryIndex = primaryHash(cName);
        int secondaryIndex = secondaryHash(cName);

        int i = 0;
        while (i < this.capacity) {
            int index = (primaryIndex + (i * secondaryIndex)) % this.capacity;

            if (this.bookings[index] == null){
                newIndex = index;
                break;
            }
            else if (this.bookings[index].getTable() == table){
                this.bookings[index].setTable(table);
                return;
            }
            i++;
        }

        if (newIndex != -1){
            Customer cust = new Customer(cName);
            table.setStatus(2); // change table to being taken
            this.bookings[newIndex] = new Reservation(cust, table);
            size++;
        }

    }

    /**
     * Delete a reservation from the hashtable
     * 
     * @param key
     * @throws Exception
     */
    public void delete(String key) throws Exception{
        int primaryIndex = primaryHash(key);
        int secondaryIndex = secondaryHash(key);

        int i = 0;
        while (i < this.capacity){
            int index = (primaryIndex + i * secondaryIndex)%capacity;
            if (this.bookings[index] != null && this.bookings[index].getCustomer().getName().equals(key)){
                this.bookings[index] = null;
                size--;
                return;
            }
            i++;
        }
        throw new Exception("Key not found");
    }

    /**
     * A reservation based on the name
     * of the customer provided
     * 
     * @param key
     * @return Table reserved by customer
     */
    public Table retrieve(String key) throws Exception{
        int primaryIndex = primaryHash(key);
        int secondaryIndex = secondaryHash(key);

        int i = 0;
        while (i < this.capacity){
            int index = (primaryIndex + i*secondaryIndex)%capacity;
            
            if (this.bookings[index] == null){ // when the key is not found in table
                throw new Exception("Reservation not made by customer");
            }
            else if (this.bookings[index].getCustomer().getName().equals(key)){
                return this.bookings[index].getTable();
            }
            i++;
        }
        return null;
    }

    /**
     * Retrieves the reservation made
     * by a customer
     * 
     * @param key
     * @return the reservation object
     * @throws Exception
     */
    public Reservation retrieveReservation(String key) throws Exception{
        int primaryIndex = primaryHash(key);
        int secondaryIndex = secondaryHash(key);

        int i = 0;
        while (i < this.capacity){
            int index = (primaryIndex + i*secondaryIndex)%capacity;
            
            if (this.bookings[index] == null){ // when the key is not found in table
                throw new Exception("Reservation not made by customer");
            }
            else if (this.bookings[index].getCustomer().getName().equals(key)){
                return this.bookings[index];
            }
            i++;
        }
        return null;
    }
    
}

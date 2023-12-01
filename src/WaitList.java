public class WaitList {

    private String[] people;
    private int size;
    private int head;
    private int tail;
    private int capacity;

    /**
     * Constructor for a waitlist object
     * 
     * @param capacity
     */
    public WaitList(int capacity){
        people = new String[capacity];
        head = -1;
        tail = -1;
        setCapacity(capacity);
    }
    
    /**
     * Getter for the number of people
     * on the waitlist
     * 
     * @return the number of people inline
     */
    public int getSize() {
      return this.size;
    }

    /**
     * getter for the capacity of
     * the waitlist
     * 
     * @return maximum capacity
     */
    public int getCapacity() {
      return this.capacity;
    }

    /**
     * Setter for the capacity of
     * the waitlist
     * 
     * @param value
     */
    public void setCapacity(int value) {
      this.capacity = value;
    }

    /**
     * Check whether the queue is empty
     * @return true/false
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * Add new customer to the waitlist
     * 
     * @param cust
     * @throws Exception
     */
    public void enqueue(String cust) throws Exception{

        if(getSize() == getCapacity()) throw new Exception("Waitlist is full");

        if (this.isEmpty()){
            head++;
            tail++;
            this.people[head] = cust;
        }
        else{
            tail = (tail + 1) % capacity; // to allow circular nature of queue
            this.people[tail] = cust;
        }

        size++;

    }

    /**
     * Removes a customer from the waitlist
     * when a table has been found for them
     * 
     * @return Customer object
     * @throws Exception
     */
    public String dequeue() throws Exception{
        String toRemove = null;

        if (isEmpty()) throw new Exception("Waitlist is empty");
        else{
            toRemove = people[head];
            people[head] = null;
            head = (head + 1) % capacity;
        }
        
        size--;
        return toRemove;
    }
}

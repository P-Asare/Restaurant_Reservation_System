public class Customer {

    private String name;

    /**
     * Constructor for customer object
     * @param name
     */
    public Customer(String name){
        this.setName(name);
    }
    
    /**
     * Getter for customer name
     * 
     * @return name
     */
    public String getName() {
      return this.name;
    }

    /**
     * Setter for customer name
     * 
     * @param value
     */
    public void setName(String value) {
      this.name = value;
    }
}

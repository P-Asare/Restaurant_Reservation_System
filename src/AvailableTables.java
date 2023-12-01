public class AvailableTables {
    
    /**
     * Blueprint for node object
     * for tree data structure
     * 
     */
    public class Node<T>{
        Node<T> left;
        Node<T> right;
        T data;

        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node<Table> root;
    int size;

    /**
     * Constructor for available tables
     * binary tree
     * 
     */
    public AvailableTables(){
        root = null;
    }

    /**
     * Remove a table from tree
     * based on its number of seats
     * 
     * @param capacity
     */
    public void removeOccupiedTable(int capacity){
        root = deleteFunc(this.root, capacity);
    }

    /**
     * Helper function to delete nodes from table
     * structure
     * 
     * @param root
     * @param capacity
     * @return Node<Table>
     */
    private Node<Table> deleteFunc(Node<Table> root, int capacity){

        if (root == null){
            return null;
        }

        if (capacity < root.data.getSeats()){
            root.left = deleteFunc(root.left, capacity);
        }
        else if (capacity > root.data.getSeats()){
            root.right = deleteFunc(root.right, capacity);
        }
        else{
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }

            root.data = minVal(root.right);

            root.right = deleteFunc(root.right, root.data.getSeats());
        }

        return root;
    }

    /**
     * Helper function to find 
     * the minimum node in a subtree
     * 
     * @param node
     * @return Table
     */
    private Table minVal(Node<Table> node){

        Table minTable = node.data;

        while (node.left != null){
            minTable = node.left.data;
            node = node.left;
        }
        return minTable;
    }

    /**
     * Add a new table to the
     * available tables binary tree
     * 
     * @param capacity of the table
     */
    public void insert(int capacity) throws Exception{
        if (this.root == null){
            this.root = new Node<Table>(new Table(capacity));
        }
        else{
            Node<Table> parent = null;
            Node<Table> temp = root;

            while (temp != null){
                parent = temp;
                if (capacity > temp.data.getSeats()) temp = temp.right;
                else temp = temp.left;
            }

            if (capacity < parent.data.getSeats()) parent.left = new Node<Table>(new Table(capacity));
            else parent.right = new Node<Table>(new Table(capacity));
        }
    }

    /**
     * Search for a particular table
     * based on its number of seats
     * 
     * @param capacity
     * @return Table object found
     * @throws Exception
     */
    public Table search(int capacity) throws Exception{

        Node<Table> temp = root;

        while(temp != null){
            if (capacity > temp.data.getSeats()){
                temp = temp.right;
            }
            else if (capacity < temp.data.getSeats()){
                temp = temp.left;
            }
            else{
                return temp.data;
            }
        }

        // throw exception if table is not foundtr
        throw new Exception("No table with this capacity");
    }

    /**
     * Display every table in 
     * tree
     * 
     * @param node
     */
    public void goThrough(Node<Table> node){

        if (node != null){
            goThrough(node.left);
            System.out.println(node.data.getSeats());
            goThrough(node.right);
        }
    }
}

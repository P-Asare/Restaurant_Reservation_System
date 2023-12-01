import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);
        
        try {
            // A restaurant that can take 23 reservation bookings and 7 walk in bookings
            Restaurant rest = new Restaurant();

            System.out.println("Hi. Welcome to our restaurant booking platform");

            while (true) {
                System.out.println("The current occupancy status of the restaurant is: " + rest.occupancyStatus() + " tables free.");

                System.out.println("Are you reserving a table (r), walking in (w), cancelling a reservation (c), or quitting (q)?");
                String choice = kb.nextLine().toLowerCase();

                if (choice.equals("r")){
                    
                    System.out.println("Please enter your name: ");
                    String name = kb.nextLine();
                    
                    System.out.println("How many seats do you want between 1 and 23? ");
                    int seats = kb.nextInt();
                    kb.nextLine(); // to correct error of nextInt not reading input

                    System.out.println(); // spacing purposes

                    rest.bookTable(name, seats);
                    System.out.println("Thank you. Your reservation has been made. Hope to see you soon.");
                    rest.findReservation(name);
                    System.out.println();
                }
                else if (choice.equals("w")){
                    System.out.println("Please enter your name: ");
                    String name = kb.nextLine();
                    
                    System.out.println("How many seats do you want? ");
                    int seats = kb.nextInt();
                    kb.nextLine(); // to correct error of nextInt not reading input

                    System.out.println(); // spacing purposes

                    rest.addWalkInCustomer(name);
                    System.out.println("You have been added to the waitlist. You will be given a table eventually.");
                    System.out.println();
                }
                else if (choice.equals("q")){
                    System.out.println("Quitting...");
                    break;
                }
                else if (choice.equals("c")){
                    System.out.println("Please enter your name: ");
                    String name = kb.nextLine();

                    rest.cancelReservation(name);

                    System.out.println("Canceling...");
                    System.out.println("Your reservation has been cancelled.");
                    System.out.println();
                }
                else {
                    System.out.println("Please enter the right kind of input.");
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        kb.close();
    }
}

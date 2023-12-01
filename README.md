RESTAURANT RESERVATION SYSTEM 

DESCRIPTION
This project implements a Restaurant Reservation System designed to manage tables, bookings, and a waitlist for a restaurant.

TABLE OF CONTENTS 

Getting Started
Folder Structure
Dependency Management
Installation
Usage
ContributION



GETTING STARTED 
Welcome to the Restaurant Reservation System project! This guide helps you set up and work with the codebase in Visual Studio Code.

FOLDER STRUCTURE 
The workspace contains the following folders:

src: Contains the source code files.
lib: Manages external dependencies.
bin: Holds the compiled output files.
You can modify the folder structure by updating the settings in .vscode/settings.json.

DEPENDANCY MANAGEMENT
To manage dependencies for your Java projects, utilize the JAVA PROJECTS view in Visual Studio Code. Further details can be found in this guide.

IMSTALLATION
Please follow these steps to install and set up the project:

Clone this repository to your local machine.
Open the project in Visual Studio Code.


USAGE
open  the terminal 
navigate to the directory where you saved the file 
compile the app java using javac App.java 


The system supports the following functionalities:
Table management
Reservation bookings
Waitlist management


CONTRIBUTION
Nana Adowa Elegba:
Carefully wrote up the classes and their needed functions.
Tested the interface and code.

Emmanuel:
Drew up a UML diagram that carefully showcased the classes and their functions and relations to each other.
Tested the interface and code.

Palal and Elikem:
Implemented each of the classes and the functions and the interface.


Credits
TABLE MANAGEMENT 
The table management system within this project is organized as follows:

Each table is represented as an object/class containing attributes such as table number, seat, status (occupied/vacant), and location in the restaurant.
Free Tables are stored in a Tree
Reservation bookings are associated with specific tables, linking reservation details with the respective table information.

RESERVATION BOOKINGS 
Reservation bookings in this project are structured as follows:

Each reservation is represented by an object/class containing details such as , customer information, date, time, table ID.
Reservations are stored in a hashtable  where each entry holds the details of a particular reservation.


WAITLIST MANAGEMENT 
The waitlisRt management system encompasses:

A queue-based structure to manage the waitlist, where walk-in customers are added to the queue when they request a table but none are available.
The system handles dequeuing customers as tables become available, managing the order of seating based on the queue.

All these structures facilitate efficient management of tables, reservation bookings, and waitlist requests within the restaurant system.

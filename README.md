# Smart-Library-Management-System
A Java-based console application for managing books, students, borrowing, returning, and library records.
## Project Overview
The Smart Library Management System is a simple Java-based application developed to manage some of the common activities carried out in a library.
In a library, keeping track of books, students, and borrowing activities can become difficult if everything is maintained manually. This project provides a small menu-driven system where these activities can be handled from one place.

The user can add and view books, search for a particular book, remove books, register students, borrow and return books, and generate a basic report.

The project was developed as part of the Programming in Java course and focuses on applying Java concepts to a practical problem.
## Features
The application provides the following options:

- Add Book
- Display Books
- Search Book
- Delete Book
- Register Student
- Borrow Book
- Return Book
- Generate Report
- Exit
## How the System Works
When the program starts, a menu is displayed in the console.

The user selects an operation by entering the corresponding option number. Based on the selected option, the program asks for the required information and performs the operation.

For example, when a user wants to borrow a book, the system checks the required information and the availability of the book before completing the operation.

The program also keeps the required information in text files so that the records can be used again when the application is run.
## Main Parts of the Project
### Book Management
This part deals with adding, displaying, searching and deleting books.
### Student Registration
This part is used to register students who need to use the library.
### Borrow and Return 
This part manages the borrowing and returning of books and updates their availability.
### Report Generation 
This option provides a simple summary of the library information.
### File Handling
Text files are used to store book information, student information and library activity records.
## Technologies and Tools Used

- Java
- Object-Oriented Programming
- ArrayList
- Exception Handling
- Java I/O
- File Handling
- Text Files
- VS Code
## Project Files
- Main.java
- Book.java
- Library.java
- FileManager.java
- LibraryException.java
- books.txt
- students.txt
- library_log.txt

## Description of Files
### Main.java

This is the starting point of the program. It displays the menu and takes input from the user.
### Book.java

This class represents a book. It contains the basic information related to a book and its availability.
### Library.java

This class contains the main library operations such as adding, searching, deleting, borrowing and returning books.
### FileManager.java

This class is responsible for reading and writing the information stored in the text files.
### LibraryException.java

This is a custom exception class used to handle errors related to library operations.
## Requirements

To run the project, the following are required:

Java Development Kit (JDK)
A Java-supported editor or IDE such as VS Code
Command Prompt or Terminal##
## How to Run the Project
### Step 1: Open the Project

Download or clone the repository and open the project folder in VS Code or another Java-supported IDE.
### Step 2: Check Java Installation

Open the terminal and check whether Java is installed:java -version
### Step 3: Compile the Program

Compile the Java files using:javac *.java
### Step 4: Run the Program

Start the application using:java Main
The main menu will appear in the terminal.
## Example Menu
1. Add Book
2. Display Books
3. Search Book
4. Delete Book
5. Register Student
6. Borrow Book
7. Return Book
8. Generate Report
9. Exit
Enter the number of the operation that you want to perform.
## Data Files

The project uses three text files:
### books.txt

Contains information related to books.
### students.txt

Contains information related to registered students.
### library_log.txt

Contains records of activities performed in the library system.
## Testing

The main features of the application were tested by running different operations from the menu.

Some of the test cases include:
- Adding a book with valid details
- Displaying books
- Searching for an existing book
- Searching for a book that is not available
- Registering a student
- Borrowing an available book
- Trying to borrow a book that is already unavailable
- Returning a borrowed book
- Deleting a book
- Generating a report
- Entering an invalid menu option
The purpose of testing was to check the normal working of the system as well as how it responds to incorrect or unavailable inputs.
## Screenshots
1. Main Menu
 <img width="423" height="259" alt="Screenshot 2026-09-17 154031" src="https://github.com/user-attachments/assets/1dc2b518-d243-47ee-9665-7ec6c77b3e4b" />
 
2. Add Book
 <img width="448" height="406" alt="Screenshot 2026-09-17 154553" src="https://github.com/user-attachments/assets/913d7b28-589e-4fc2-980d-5179d1d70036" />

3. Display Books
 <img width="1197" height="480" alt="Screenshot 2026-09-17 154755" src="https://github.com/user-attachments/assets/34abb80c-5e97-45d3-9393-a83300b14580" />

4. Register Student
 <img width="438" height="391" alt="Screenshot 2026-09-17 155310" src="https://github.com/user-attachments/assets/5dccf3b8-fa5b-4dea-bba3-0027052ccfab" />

5. Borrow Book
 <img width="407" height="355" alt="Screenshot 2026-09-17 155554" src="https://github.com/user-attachments/assets/bc9b0aaa-0329-4aae-b93e-177350ae71ad" />

6. Return Book
 <img width="431" height="409" alt="Screenshot 2026-09-17 155721" src="https://github.com/user-attachments/assets/bf483d87-171c-4b88-94a4-811d12bdf7f5" />

7. Generate Report
 <img width="540" height="139" alt="Screenshot 2026-09-17 160132" src="https://github.com/user-attachments/assets/49fa706c-34a1-4610-b5be-cfe58a914731" />

## Project Structure 
The project is divided into separate classes so that each part has a clear responsibility.

This makes the program easier to understand and also makes it easier to modify a particular part without changing the whole application.
## Future Improvements
Some features that could be added in a future version are:
- A graphical user interface
- Separate user roles
- Better search options
- Book issue and return dates
- Fine calculation
- More detailed reports
- Additional input validation
## Conclusion
The Smart Library Management System is a small application developed to demonstrate how Java programming concepts can be used to solve a practical problem.

The project helped in understanding how classes, objects, collections, exception handling and file handling can work together in one application.

It also provided practical experience in organizing a Java project into different files and testing the different functions of the system.

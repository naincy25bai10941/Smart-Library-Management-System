import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        Library library =
                new Library();

        boolean exit = false;

        while (!exit) {

            System.out.println(
                "\n===== SMART LIBRARY MANAGEMENT =====");

            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Register Student");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Generate Report");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            try {

                int choice =Integer.parseInt(scanner.nextLine());


                switch (choice) {

                    case 1:
                        System.out.print("Enter Book ID: ");

                        int id =Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Book Title: ");

                        String title =scanner.nextLine();

                        System.out.print("Enter Author: ");

                        String author =scanner.nextLine();

                        System.out.print("Enter Category: ");

                        String category = scanner.nextLine();

                        library.addBook(id,title,author,category);

                        break;


                    case 2:
                        library.displayBooks();
                        break;

                    case 3:

                        System.out.print("Enter title, author or category: ");

                        String word = scanner.nextLine();
                        library.searchBook(word);
                        break;


                    case 4:
                        System.out.print("Enter Book ID: ");
                        id = Integer.parseInt(scanner.nextLine());
                        library.deleteBook(id);
                        break;

                    case 5:

                        System.out.print("Enter Student ID: ");

                        int studentId =Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Student Name: ");

                        String name =scanner.nextLine();

                        System.out.print("Enter Student Email: ");

                        String email =scanner.nextLine();

                        library.registerStudent(studentId,name,email);

                        break;

                    case 6:

                        System.out.print("Enter Book ID: ");

                        int bookId =Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Student ID: ");

                        studentId =Integer.parseInt(scanner.nextLine());

                        library.borrowBook(bookId,studentId);
                        break;


                    case 7:

                        System.out.print("Enter Book ID: ");

                        bookId =Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Student ID: ");

                        studentId =Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Late Days: ");

                        int lateDays = Integer.parseInt(scanner.nextLine());

                        library.returnBook(bookId,studentId,lateDays);
                        break;


                    case 8:

                        library.generateReport();
                        break;


                    case 9:

                        exit = true;

                        System.out.println("Thank you for using " + "Smart Library Management System!");
                        break;


                    default:
                        System.out.println("Invalid choice.");
                }


            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
} 
    


import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private FileManager fileManager;


    public Library() {

        fileManager = new FileManager();

        try {

            books = fileManager.loadBooks();

        } catch (Exception e) {

            books = new ArrayList<>();

            System.out.println("Could not load old books.");
        }
    }


    public void addBook(int id, String title, String author, String category) throws Exception {

        if (id <= 0) {

            throw new LibraryException("Book ID must be positive.");
        }

        if (title.trim().isEmpty() || author.trim().isEmpty() || category.trim().isEmpty()) { 
            throw new LibraryException("Book details cannot be empty.");
        }

        for (Book book : books) {

            if (book.getId() == id) {
                throw new LibraryException("Book ID already exists.");
            }
        }

        Book book = new Book(id,title,author,category,true);

        books.add(book);

        fileManager.saveBooks(books);

        fileManager.writeLog("Book added: " + title);

        System.out.println("Book added successfully.");
    }


    public void displayBooks() {

        if (books.isEmpty()) {

            System.out.println("No books available.");

            return;
        }

        System.out.println("\n========== BOOKS ==========");

        for (Book book : books) {
            System.out.println(book);
        }
    }


    public void searchBook(String word) throws LibraryException {

        if (word.trim().isEmpty()) {

            throw new LibraryException("Search cannot be empty.");
        }

        boolean found = false;

        System.out.println("\n========== SEARCH RESULT ==========");

        for (Book book : books) {

            if (book.getTitle()
                .toLowerCase()
                .contains(word.toLowerCase()) 

                || book.getAuthor()
                .toLowerCase()
                .contains(word.toLowerCase())

                || book.getCategory()
                    .toLowerCase()
                    .contains(word.toLowerCase())) {

                System.out.println(book);

                found = true;
            }
        }

        if (!found) {

            System.out.println("No matching book found.");
        }
    }


    public void deleteBook(int id) throws Exception {

        for (Book book : books) {

            if (book.getId() == id) {

                if (!book.isAvailable()) {
                    throw new LibraryException("Borrowed book cannot be deleted.");
                }

                books.remove(book);

                fileManager.saveBooks(books);

                fileManager.writeLog( "Book deleted: " + id);

                System.out.println("Book deleted successfully.");

                return;
            }
        }

        throw new LibraryException( "Book not found.");
    }


    public void registerStudent(int id,String name,String email) throws Exception {

        if (id <= 0 ||
            name.trim().isEmpty() ||
            !email.contains("@")) {

            throw new LibraryException("Invalid student details.");
        }

        if (fileManager.studentExists(id)) {

            throw new LibraryException("Student ID already exists.");
        }

        fileManager.saveStudent(id, name, email);

        fileManager.writeLog("Student registered: " + id);

        System.out.println("Student registered successfully.");
    }


    public synchronized void borrowBook(int bookId,int studentId) throws Exception {

        if (!fileManager.studentExists(studentId)) {

            throw new LibraryException("Student not found.");
        }

        for (Book book : books) {

            if (book.getId() == bookId) {

                if (!book.isAvailable()) {

                    throw new LibraryException("Book is already borrowed.");
                }

                book.setAvailable(false);

                fileManager.saveBooks(books);

                fileManager.writeLog("Book " + bookId +" borrowed by student " +studentId);

                System.out.println("Book borrowed successfully.");

                return;
            }
        }

        throw new LibraryException("Book not found.");
    }


    public synchronized void returnBook(int bookId,int studentId,int lateDays) throws Exception {

        if (!fileManager.studentExists(studentId)) {

            throw new LibraryException("Student not found.");
        }

        if (lateDays < 0) {
            throw new LibraryException("Late days cannot be negative.");
        }

        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.isAvailable()) {
                    throw new LibraryException("This book is not borrowed.");
                }

                book.setAvailable(true);

                double fine = lateDays * 5.0;

                fileManager.saveBooks(books);

                fileManager.writeLog("Book " + bookId +" returned by student " +studentId +". Fine: Rs." + fine);

                System.out.println("Book returned successfully.");

                System.out.println("Fine: Rs." + fine);

                return;
            }
        }

        throw new LibraryException("Book not found.");
    }


    public void generateReport() {

        Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        int total = books.size();
                        int available = 0;

                        for (Book book : books) {

                            if (book.isAvailable()) {
                                available++;
                            }
                        }

                        int borrowed = total - available;

                        System.out.println("\n========== LIBRARY REPORT ==========");

                        System.out.println("Total Books: " + total);

                        System.out.println( "Available Books: " + available);

                        System.out.println("Borrowed Books: " + borrowed);

                        System.out.println("Report generated successfully.");
                    }
                });

        thread.start();
    }
}
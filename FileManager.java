import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private final String BOOK_FILE = "books.txt";
    private final String STUDENT_FILE = "students.txt";
    private final String LOG_FILE = "library_log.txt";


    public void saveBooks(ArrayList<Book> books) throws IOException {
        FileWriter writer = new FileWriter(BOOK_FILE);

        for (Book book : books) {

            writer.write(
                book.getId() + "|" +
                book.getTitle() + "|" +
                book.getAuthor() + "|" +
                book.getCategory() + "|" +
                book.isAvailable() + "\n"
            );
        }

        writer.close();
    }


    public ArrayList<Book> loadBooks() throws IOException {

        ArrayList<Book> books = new ArrayList<>();

        File file = new File(BOOK_FILE);

        if (!file.exists()) {
            return books;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split("\\|");

            if (data.length == 5) {

                int id = Integer.parseInt(data[0]);

                Book book = new Book(id, data[1], data[2], data[3], Boolean.parseBoolean(data[4]));
                books.add(book);
            }
        }

        reader.close();

        return books;
    }


    public void saveStudent(int id, String name, String email) throws IOException {

        FileWriter writer = new FileWriter(STUDENT_FILE, true);

        writer.write(id + "|" +name + "|" +email + "\n");

        writer.close();
    }


    public boolean studentExists(int id) throws IOException {

        File file = new File(STUDENT_FILE);

        if (!file.exists()) {
            return false;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split("\\|");

            if (data.length > 0 && Integer.parseInt(data[0]) == id) {

                reader.close();
                return true;
            }
        }

        reader.close();

        return false;
    }


    public void writeLog(String message) {

        try {

            FileWriter writer = new FileWriter(LOG_FILE, true);

            writer.write(message + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Could not write log.");
        }
    }
} 
    


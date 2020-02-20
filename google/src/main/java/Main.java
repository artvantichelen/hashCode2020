import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        File file = new File("C:/Users/arthur/hashCode/hashCode2020/google/src/main/resources/input/a_example.txt");

        try {
            Hub hub = null;
            FileReader fileReader = new FileReader(file);
            PrintWriter writer = new PrintWriter("C:/Users/arthur/hashCode/hashCode2020/google/src/main/resources/output/a_example_result.txt", "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            Integer lineNbr = 1;
            Integer libraryIndex = 0;
            String[] tabString = line.split(" ");
            ScanPlanning scanPlanning = new ScanPlanning(Integer.parseInt(tabString[0]), Integer.parseInt(tabString[1]), Integer.parseInt(tabString[2]));
            ArrayList<Library> libraries = new ArrayList<>();
            ArrayList<Book> books = new ArrayList<>();
            Library library = null;
            while (line != null) {
                if(lineNbr == 2) {
                    String[] tabScoring = line.split(" ");
                    for (int i = 0; i < tabScoring.length; i++) {
                        Book book = new Book(i, Integer.parseInt(tabScoring[i]));
                        books.add(book);
                    }
                }
                if(lineNbr > 2 && lineNbr % 2 != 0) {
                    String[] tabLibrary = line.split(" ");
                    for (int i = 0; i < tabLibrary.length; i++) {
                        library = new Library(Integer.parseInt(tabLibrary[0]), Integer.parseInt(tabLibrary[1]), Integer.parseInt(tabLibrary[2]), libraryIndex);
                        libraryIndex++;
                    }
                }
                if(lineNbr > 2 && lineNbr % 2 == 0) {
                    String[] tabBook = line.split(" ");
                    ArrayList<Book> booksForLibrary = new ArrayList<>();
                    for (int i = 0; i < tabBook.length; i++) {
                        booksForLibrary.add(books.get(Integer.parseInt(tabBook[i])));
                    }
                    library.setBooks(booksForLibrary);
                    libraries.add(library);
                }
                line = bufferedReader.readLine();
                lineNbr++;
            }
            // Output
            hub = new Hub(libraries, scanPlanning);
            writer.println(hub.getLibrariesSort().size());
            for (Library l : hub.getLibrariesSort()) {
                writer.println(l.getName()+" "+l.getScanBooks().size());
                for (Book b : l.getScanBooks()) {
                    writer.print(b.getId()+" ");
                }
                writer.print("\n");
                
            }
            writer.close();
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

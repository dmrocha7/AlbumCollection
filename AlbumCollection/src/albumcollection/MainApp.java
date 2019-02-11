package albumcollection;
                                 
import java.io.File; 
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

/**
 *
 * @author David Rocha dr1340
 */
public class MainApp {
    private static final String DATABASE_FILE_NAME = "database.txt";

    private static ArrayList<Album> albumCollection = new ArrayList<Album>();
    

    
    public static void main(String[] args) {
        
        readCollectionFromDatabase();
        System.out.println("All saved albums read into database.");
        int value = 5;
        while(value != 5){
            System.out.println("1. Display list	of all	albums in the collection.\n" +
                "2. Add	a new album to the collection.\n" +
                "3. Search for an album	given the name of the artist or title of the \n" +
                "album or part of the name of the artist or title of the album.\n" +
                "4. Delete an album from the collection.\n" +
                "5. Exit program.");
            switch(value){
                case 1:
                    break;
            }
            
        }
           
        Album newAlbum = new Album();
        newAlbum.title = "Blah";

        albumCollection.add(newAlbum);

        writeCollectionToDatabase();
    }

    private static void writeCollectionToDatabase() {

        try {

            FileWriter fileWriter = new FileWriter(DATABASE_FILE_NAME, false);

            for (Album album : albumCollection) {
                String title = album.title;
                fileWriter.write(title + "\n");
            }

            fileWriter.close();

        } catch (Exception ex) {

            System.out.println("Exception: " + ex);
        }
    }

    private static void readCollectionFromDatabase() {

        File file = new File(DATABASE_FILE_NAME);

        try {

            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("~");

            while (scanner.hasNextLine()) {
                String line = scanner.next();
                String artist =  scanner.next();
                int releaseYear =  scanner.nextInt();
                int genre = scanner.nextInt();
                Album album = new Album();
                album.title = line;
                albumCollection.add(album);
            }

        } catch (Exception ex) {

            System.out.println("Exception: " + ex);
        }

    }
}

package albumcollection;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David Rocha dr1340
 */
public class MainApp {
 private static final String DATABASE_FILE_NAME = "database.txt";

    private static ArrayList<Album> albumCollection = new ArrayList<Album>();

    public static void main(String[] args) {

        readCollectionFromDatabase();

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

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Album album = new Album();
                album.title = line;
                albumCollection.add(album);
            }

        } catch (Exception ex) {

            System.out.println("Exception: " + ex);
        }

    }
}

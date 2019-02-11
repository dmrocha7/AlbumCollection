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
        String title = "";
        String artist = "";
        int releaseYear;
        int genre = 0;
        Album album = new Album(title, artist);
        Scanner in = new Scanner(System.in);
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
                case 2:
                    System.out.println("Please enter the Album Title.");
                    title = in.nextLine();
                    System.out.println("Please enter the Artist.");
                    artist = in.nextLine();
                    System.out.println("Please enter the Release Year.");
                    releaseYear = in.nextInt();
                    System.out.println("Please enter the Genre.");
                    artist = in.nextLine();
                    System.out.println("Select the phone type:");
                    System.out.println("0. Rock");
                    System.out.println("1. Rap");
                    System.out.println("2. Country");
                    System.out.println("3. Pop\n");

                    int phoneTypeInt = in.nextInt();
        System.out.println("");

            switch (genre){
                    case 1:
                        album.setMusicGenre(MusicGenre.ROCK);
                        break;
                    case 2:
                        album.setMusicGenre(MusicGenre.RAP);
                        break;
                    case 3:
                        album.setMusicGenre(MusicGenre.COUNTRY);
                        break;
                    case 4:
                        album.setMusicGenre(MusicGenre.POP);
                    default:
                        break;
            }
        }

        System.out.println(album.toString());
             
        }
        
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
                String title = scanner.next();
                String artist =  scanner.next();
                Album album = new Album(title, artist);
                int releaseYear =  scanner.nextInt();
                int genre = scanner.nextInt();
                
                switch (genre) {
                    case 1:
                        album.setMusicGenre(MusicGenre.ROCK);
                        break;
                    case 2:
                        album.setMusicGenre(MusicGenre.RAP);
                        break;
                    case 3:
                        album.setMusicGenre(MusicGenre.COUNTRY);
                        break;
                    case 4:
                        album.setMusicGenre(MusicGenre.POP);
                    default:
                        break;
            }
                
                albumCollection.add(album);
            }

        } catch (Exception ex) {

            System.out.println("Exception: " + ex);
        }

    }
}

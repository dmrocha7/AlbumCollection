package albumcollection;
                                 
import java.io.File; 
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * This program implements an Album Catalog. It allows the user to add new albums,
 display a list of all albums in the collection, search for a specific album,
 delete a specific album.
 * @author David Rocha
 */
public class MainApp {
    private static final String DATABASE_FILE_NAME = "database.ser";

    private static ArrayList<Album> albumCollection = new ArrayList<Album>();

    public static void main(String[] args) throws FileNotFoundException {
      /*  FileOutputStream fileStream = new FileOutputStream(DATABASE_FILE_NAME);
        try {
            ObjectOutputStream os  = new ObjectOutputStream(fileStream);
        } catch (IOException ex) {
            System.out.println("Not Found");
        }*/
        readCollectionFromDatabase();        
        System.out.println("\nAll saved albums read into database.");
        String title = "";
        String artist = "";
        int releaseYear = 0;
        int genre = -1;
        Scanner inC = new Scanner(System.in); 
        int value = -1;
        do {
            System.out.println("1. Display list	of all	albums in the collection.\n"
                + "2. Add a new album to the collection.\n" + "3. Search for "
                + "an album given the name of the artist or title of the\n   " 
                +" album or part of the name of the artist or title of the album.\n"
                + "4. Delete an album from the collection.\n" +
                "5. Play an album.\n" + "\t1.Play.\n" + "\t2.s Fast Forward.\n" +
                "\t3. Rewind.\n" + "\t4. Skip To Next Track (if album is a CD)."
                + "\n" + "\t5. Skip To Previous Track (if album is a CD).\n" +
                "\t6. Exit Player.\n6. Exit program.");            
            value = inC.nextInt();
            switch(value){
                case 1: 
                    for (Album album : albumCollection) {
                        System.out.println(album.toString());
                    }
                    break;
                case 2:
                    Scanner in = new Scanner(System.in);
                    System.out.println("Please enter the Album Title.");
                    title = in.nextLine();
                    System.out.println("Please enter the Artist.");
                    artist = in.nextLine();
                    System.out.println("Please enter the Release Year.");
                    boolean test = false;  
                    while(test == false) {
                        if(in.hasNextInt()) {
                            releaseYear = in.nextInt();
                            test = true;
                        }
                        else if(!in.hasNextInt()) {
                            System.out.println("Enter a number please.");
                            in.next();
                        }
                    }
                    
                    Album album = new Album(artist, title, releaseYear);
                        System.out.println("Select the phone type:");
                        System.out.println("0. Rock");
                        System.out.println("1. Rap");
                        System.out.println("2. Country");
                        System.out.println("3. Pop\n"); 
                        test = false;
                    
                        while(test == false) {
                         if(in.hasNextInt()) {
                                genre = in.nextInt();
                                test = true;
                            }
                            else if(!in.hasNextInt() ) {
                                System.out.println("Enter a number 0-3.");
                                in.next();
                            }
                        }
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
                    
                    albumCollection.add(album);
                    System.out.println("Album has been added to Collection2.\n");
                    break;
                    
                case 3:   
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter name of artist or title of album," +
                     " or part of the name of the artist or title of the album.");
                    int b = 0;
                    String temp = "";
                    temp = input.nextLine();
                    for (Album a : albumCollection) {
                        if(a.getArtist().contains(temp)|| a.getTitle().contains(temp)) {
                            System.out.println("Album exists."); 
                            b++;
                        }                       
                    }
                    if(b == 0)
                            System.out.println("Album does not exist."); 
                    break;
                case 4:
                    Scanner i = new Scanner(System.in);
                    System.out.println("Enter the title of the album " +
                            "you would like to delete.");
                    String t = i.nextLine();
                    for (Album a : albumCollection) {
                        if(a.getTitle().equals(t)) 
                            albumCollection.remove(a);
                    }
                    break;
                case 5:
                    
                    break;
            }
        }
        while(value != 6);
        
        writeCollectionToDatabase();
    }

/**
 * This method writes all the albums in the database to the txt file.
 */
    private static void writeCollectionToDatabase() {

        try {
            FileWriter fileWriter = new FileWriter(DATABASE_FILE_NAME, false);

            for (Album album : albumCollection) {
                String title = album.getTitle();
                fileWriter.write(title + "~");
                String artist = album.getArtist();
                fileWriter.write(artist + "~");
                int releaseYear = album.getReleaseYear();
                fileWriter.write(releaseYear + "~");
                MusicGenre musicGenre = album.getMusicGenre();
                int genre = -1;
                
                if(musicGenre.equals(musicGenre.RAP)) {
                    genre = 0;
                } else if(musicGenre.equals(musicGenre.ROCK)) {
                    genre = 1;
                } else if(musicGenre.equals(musicGenre.COUNTRY)) {
                    genre = 2;
                } else if(musicGenre.equals(musicGenre.POP)) {
                    genre = 3;
                } 
                fileWriter.write(genre + "\n");
            }
            fileWriter.close();

        } catch (Exception ex) {

            System.out.println("Exception: " + ex);
        }
    }

/**
 * /**
 * This method reads all the albums from the database to the txt file.
 */
    private static void readCollectionFromDatabase() {
        
        File file = new File(DATABASE_FILE_NAME);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] details = line.split("~");
                String title = details[1];                
                String artist =  details[0]; 
                int releaseYear =  Integer.parseInt(details[2]);
                Album album = new Album(artist, title, releaseYear);
                int genre = Integer.parseInt(details[3]);
                
                switch (genre) {
                    case 0:
                        album.setMusicGenre(MusicGenre.ROCK);
                        break;
                    case 1:
                        album.setMusicGenre(MusicGenre.RAP);
                        break;
                    case 2:
                        album.setMusicGenre(MusicGenre.COUNTRY);
                        break;
                    case 3:
                        album.setMusicGenre(MusicGenre.POP);
                    default:
                        break;
                }
                albumCollection.add(album);
            }
        } catch (Exception ex) { //make filenotfound
            
            System.out.println("Exception: " + ex);
        }

    }
}

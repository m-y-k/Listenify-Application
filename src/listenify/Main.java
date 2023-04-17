package listenify;

import java.util.*;

public class Main {

    public static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Old Hindi Songs", "Arijit Singh");

        album.addSongToAlbum("Jhoome Jo Pathaan", 3.5);
        album.addSongToAlbum("Channa Mereya", 4.5);
        album.addSongToAlbum("Naina", 5.0);

        albums.add(album);

        album = new Album("New Songs", "Prateek Kuhad");

        album.addSongToAlbum("Kasoor", 3.5);
        album.addSongToAlbum("Tum Mile", 4.5);
        album.addSongToAlbum("Baarishein", 5.0);

        albums.add(album);


        LinkedList<Song> playList = new LinkedList<>();

        albums.get(0).addSongToPlayList("Jhoome Jo Pathaan", playList);
        albums.get(0).addSongToPlayList("Naina", playList);
        albums.get(1).addSongToPlayList("Kasoor", playList);
        albums.get(1).addSongToPlayList("Baarishein", playList);


        // print the playList
        play(playList);
    }

    public static void play(LinkedList<Song> playList) {

        ListIterator<Song> listIterator = playList.listIterator();

        // validation checks
        if (playList.size() == 0) {
            return;
        }

        printMenu();

        System.out.println("Now playing " + listIterator.next());

        Scanner sc = new Scanner(System.in);

        boolean forward = true;

        boolean quit = false;

        while (quit == false) {

            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    // quit
                    quit = true;
                    break;

                case 1:
                    // to play the next song
                    if (forward == false) { // iterator is behind the last printed value
                        listIterator.next();
                        forward = true;
                    }

                    // to the next song
                    if (listIterator.hasNext()) {
                        System.out.println(listIterator.next().toString());
                    }
                    else {
                        System.out.println("The last song is playing");
                    }
                    break;

                case 2:
                    // to play previous song
                    if (forward == true) { // already towards the right of the last printed value
                        listIterator.previous();
                        forward = false;
                    }

                    // to the previous song
                    if (listIterator.hasPrevious()) {
                        System.out.println(listIterator.previous().toString());
                    }
                    else {
                        System.out.println("Already at the first song");
                    }
                    break;

                case 3:
                    // replay current song
                    if (forward == true) { // I am on the right hand side
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    }
                    else { // I am on the left hand side
                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                    break;

                case 4:
                    //list of all songs
                    printAllSongs(playList);
                    break;

                case 5:
                    // print all availabe options
                    printMenu();
                    break;

                case 6:
                    // delete current song
                    try {
                        if (playList.size() > 0) {

                            System.out.println(listIterator.previous().toString() + " has been removed from the playList");
                            listIterator.remove();

                            if (playList.size() > 0 && listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.next().toString());
                            } else if (playList.size() > 0 && listIterator.hasNext()) {
                                System.out.println("Now playing " + listIterator.previous().toString());
                            }
                            else {
                                System.out.println("The playList is empty");
                            }
                        }
                    }catch (Exception e) {
                        System.out.println("The " + e.getMessage() + " exception has occurred");
                    }
                    break;
            }
        }
    }

    private static void printAllSongs(LinkedList<Song> songs) {

        ListIterator<Song> listIterator = songs.listIterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().toString());
        }
    }

    public static void printMenu() {

        System.out.println("Availabe options\n press");
        System.out.println("0 - to quit\n" +
                        "1 - to play next song\n" +
                        "2 - to play previous song\n" +
                        "3 - to replay the current song\n" +
                        "4 - list of all songs\n" +
                        "5 - print all available options\n" +
                        "6 - delete current song");
    }
}
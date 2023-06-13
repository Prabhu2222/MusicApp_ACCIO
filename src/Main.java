import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
      Album album1=new Album("Butta bomma","Arman Malik");
      Album album2=new Album("Doorie","Atif aslam");

      album1.addSong("Butta Bomma",4.3);
      album1.addSong("Srivalli",3.2);

      album2.addSong("Doorie",3.1);
      album2.addSong("Kuch Is Tarah",4.2);
      album2.addSong("Mahi Ve",4);
      album2.addSong("Mahi Ve",4);

      //find song
        if(album1.findSong("abc")){
            System.out.println(" song \"abc\" is  present in the album");
        }else{
            System.out.println("song \"abc\" is not present in the album");
        }

        if(album2.findSong("Doorie")){
            System.out.println("song \"Doorie\" is present in the album");
        }else{
            System.out.println("song \"Doorie\" is not present in the album");
        }
       //create playlist
        LinkedList<Song> myPlaylist=new LinkedList<>();

        album1.addToPlaylistFromAlbum("Srivalli",myPlaylist);
        album2.addToPlaylistFromAlbum(2,myPlaylist);
        album1.addToPlaylistFromAlbum(1,myPlaylist);

        //wrong song
        album1.addToPlaylistFromAlbum(5,myPlaylist);
        album2.addToPlaylistFromAlbum("random song",myPlaylist);

//        ListIterator<Song> itr=myPlaylist.listIterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//
//        }
        //playing the song
        play(myPlaylist);
    }
    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> itr=playlist.listIterator();
        //if list is empty
       if(!itr.hasNext()){
           System.out.println("your playlist is empty");
       }
        System.out.println("Now playing: ");
        System.out.println(itr.next());
        printMenu();
        boolean forward=true;
        boolean backward=false;
        int repeatCount=0;

        Scanner scn=new Scanner(System.in);
        while(true){
            System.out.println("Please enter your option: ");
            int option=scn.nextInt();
            switch(option){
                case 1:
//                    if(itr.hasPrevious()==false){
//                        System.out.println("Now playing: ");
//                        System.out.println(itr.next());
//                        forward=true;
//                        backward=false;
//                        break;
//                    }
                    if(backward==true){
                        itr.next();
                        backward=false;
                        forward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now playing: ");
                        System.out.println(itr.next());
                        forward=true;
                        backward=false;

                    }else{
                        System.out.println("You have reached at the end of playlist");
                    }
                    break;
                case 2:
//                    if(itr.hasNext()==false){
//                        System.out.println("Now playing: ");
//                        System.out.println(itr.previous());
//                        backward=true;
//                        forward=false;
//                        break;
//                    }
                    if(forward==true){
                        itr.previous();
                        backward=true;
                        forward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now playing: ");
                        System.out.println(itr.previous());
                        backward=true;
                        forward=false;

                    }else{
                        System.out.println("You have reached the beginning of the playlist");
                    }
                    break;
                case 3:

                        if(forward==true && itr.hasNext()!=false){
                            System.out.println("Now playing: ");
                            System.out.println(itr.previous());
                            backward=true;
                            forward=false;

                        }else if(backward==true && itr.hasPrevious()!=false){
                            System.out.println("Now playing: ");
                            System.out.println(itr.next());
                            forward=true;
                            backward=false;

                        }


                    break;
                case 4:
                    printSongs(playlist);
                    break;
                case 5:
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    exit(7);
            }
        }
    }
    public static void printSongs(LinkedList<Song> playlist){
        for(Song ele:playlist){
            System.out.println(ele);
        }
    }
    public static void printMenu(){
        System.out.println("1.Play next song");
        System.out.println("2.Play previous song");
        System.out.println("3.Repeat the current song");
        System.out.println("4.Show all the songs in the playlist");
        System.out.println("5.Delete the current song");
        System.out.println("6.Show its menu again");
        System.out.println("7.Exit");
    }
}
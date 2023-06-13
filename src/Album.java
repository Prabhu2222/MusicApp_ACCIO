import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    //Album is of some movie or singer but playlist is something that user makes
    private String AlbumName;
    private String Artist;
    private List<Song> songList;

    public Album(){}
    public Album(String AlbumName,String Artist){
        this.AlbumName=AlbumName;
        this.Artist=Artist;
        songList=new ArrayList<>();
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }
    public List<Song> getSongList(){
        return songList;
    }
    public void setSongList(List<Song> list){
        this.songList=list;
    }
    public boolean findSong(String songTitle){
        for(Song ele:songList){
            if(ele.getTitle().equals(songTitle)){
//                System.out.println("Congrats! your song is present in the current Album");
                return true;
            }
        }
        return false;
    }
    //return type of add song is boolean coz first we have to check whether the song exists in the Album or not
    public boolean addSong(String songTitle,double songPlayTime){
        //first check whether song is present or not
        if(findSong(songTitle)){
            System.out.println("Current song already exists");
            return false;
        }
        //create object of song
        Song newSong=new Song(songTitle,songPlayTime);
        songList.add(newSong);
        System.out.println("Congrats! Song has been added to the current Album");
        return true;
    }
    //by default linked list is doubly linked list in java
    //in playlist u just need to add song name not create object of song coz the song already exists in album
    public boolean addToPlaylistFromAlbum(String songName, LinkedList<Song> myPlayList){
        //first check if the song already exists in the album or not
        //second check if the song already exist in the playlist or not

        if(findSong(songName)){
           for(var song:songList){
               if(song.getTitle().equals(songName)){
                   myPlayList.add(song);
                   System.out.println("Congrats! the song has been added to your playlist: "+myPlayList);
                   return true;
               }
           }
        }
        System.out.println("Sorry! the current song doesn't exist in the Album");
        return false;
    }
    //overloaded addToPlaylistFromAlbum() method
    //adding song on the basis of song position like 1st song ,2nd song ,3rd song
    public boolean addToPlaylistFromAlbum(int songPosition, LinkedList<Song> myPlayList){
        int index=songPosition-1;
        //check if song is present in the playlist or not then add
        //also check if index is int the range or not
        if(index>=0 && index<songList.size()){
            Song s=songList.get(index);
            myPlayList.add(s);
            System.out.println("Congrats! song has been added to your playlist: "+myPlayList);
            return true;
        }
        System.out.println("Invalid song number");
        return false;

    }


}

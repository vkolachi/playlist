import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Album arjitAlbum=new Album("arijiy singh","arjits album");
       Album alanalbum=new Album("Alan Walker","walkers album");
        System.out.println(arjitAlbum.addSongToAlbums("kesaria",3.5));
        System.out.println(arjitAlbum.addSongToAlbums("tum kya mila",4.2));
        System.out.println(arjitAlbum.addSongToAlbums("lal ishq",5.1));

        System.out.println(alanalbum.addSongToAlbums("faded",3.5));
        System.out.println(alanalbum.addSongToAlbums("Alone",4.1));
        System.out.println(alanalbum.addSongToAlbums("Darkside",5.3));

        LinkedList<Song> myPlayList=new LinkedList<>();
        System.out.println(arjitAlbum.addToListFromAlbum("kesaria",myPlayList));
        System.out.println(arjitAlbum.addToListFromAlbum(2,myPlayList));

        System.out.println(alanalbum.addToListFromAlbum(2,myPlayList));
        System.out.println(alanalbum.addToListFromAlbum(10,myPlayList));
        play(myPlayList);
    }
    private static void play(LinkedList<Song> myPlayList){


        if(myPlayList.size()==0){
            System.out.println("Your playlis is empty");
            return;
        }
        ListIterator<Song> itr=myPlayList.listIterator();
        System.out.print("NOW PLAYING:");
        System.out.println(itr.next());
        Scanner sc=new Scanner(System.in);
        printMenu();
        boolean quit=false;
        while (!quit){
            System.out.println("please enter your choice");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(!itr.hasNext()){
                        System.out.println("YOUR AT END OF PLAYLIST");
                    }
                    else{
                        System.out.println("CURRENTLLY PLAYING"+itr.next());
                    }
                    break;
                case 3:
                    if(!itr.hasPrevious()){
                        System.out.println("YOUR AT START OF PLAYLIST");
                    }
                    else{
                        System.out.println("CURRENTLLY PLAYING"+itr.previous());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(myPlayList);
                    break;
                case 7:
                    quit=true;
                    break;
                default:
                    System.out.println("WRONG CHOICE.PLEASE SELECT AGAIN");
            }
        }

    }

    private static void printSongs(LinkedList<Song> myPlayList) {
    for(Song song:myPlayList){
        System.out.println(song);
    }

    }

    private static void printMenu(){
        System.out.println("1.SHOW THE MENU AGAIN");
        System.out.println("2.PLAY NEXT SONG");
        System.out.println("3.PLAY PREVIOUS SONG");
        System.out.println("4.PLAY CURRENT SONG AGAIN");
        System.out.println("5.DELETE SONG FROM PLAYLIST");
        System.out.println("6.PRINT ALL SONGS IN PLAYLIST");
        System.out.println("7.QUIT APPLICATION");
    }
}
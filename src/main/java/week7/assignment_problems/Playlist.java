package week7.assignment_problems;

public class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int size) {
        songs = new String[size];
        count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];

        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        String[] songs = p.getSongs();

        for (String song : songs) {
            System.out.println(song);
        }

        System.out.println(p.getSongCount());
    }
}
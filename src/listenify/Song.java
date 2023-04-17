package listenify;

public class Song {
    public String title;
    public double duration;

    public Song(String name, double duration) {
        this.title = name;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}

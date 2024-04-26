package Media;

public class Track implements playable {
    private String title;
    private int length;

    // Contructors
    public Track(String title, int length) {
        this.length = length;
        this.title = title;
    }

    // Getter and Setter
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}

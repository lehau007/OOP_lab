package AimsProject.hust.soict.globalict.aims.media.disc;

import AimsProject.hust.soict.globalict.aims.media.Media;

public class Disc extends Media {
    private int length = 0;
    private String director;
    // Constructors
    public Disc(int id, String title) {
        this.setId(id);
        this.setTitle(title);
    }
    public Disc(int id, String title, String category,  float cost){
        this.setId(id);
        this.setTitle(title);
        this.setCost(cost);
        this.setCategory(category);
    }
    public Disc(int id, String title, String category, String director, float cost){
        this.setId(id);
        this.setTitle(title);
        this.setCost(cost);
        this.setCategory(category);
        this.director = director;
    }
    public Disc(int id, String title, String category, String director, int length, float cost){
        this.setId(id);
        this.setTitle(title);
        this.setCost(cost);
        this.setCategory(category);
        this.director = director;
        this.length = length;
    }
    //Getter
    public String getDirector() {
        return this.director;
    }

    public int getLength() {
        return this.length;
    }
}

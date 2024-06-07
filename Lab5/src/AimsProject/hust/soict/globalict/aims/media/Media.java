package AimsProject.hust.soict.globalict.aims.media;

import AimsProject.hust.soict.globalict.aims.media.comparator.MediaComparatorByCostTitle;
import AimsProject.hust.soict.globalict.aims.media.comparator.MediaComparatorByTitleCost;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    // isMatch method
    public boolean isMatch(String title){
        return this.getTitle().equals(title);
    }
    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        Media other = (Media) obj;
        if (this.getTitle() == null){
            return other.getTitle() == null;
        } else return title.equals(other.title);
    }
}

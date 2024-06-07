package AimsProject.hust.soict.globalict.aims.media.disc;

import javax.swing.JOptionPane;

import AimsProject.hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void play() throws PlayerException{
        if (this.getLength() >= 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
        	JOptionPane.showMessageDialog(null, "ERROR: Track length is non-positive!", "Illegal Track Length", JOptionPane.WARNING_MESSAGE);
            System.out.println("***Can not play this track***");
            throw new PlayerException("ERROR: Track length is non-positive!");        
        }
    }
    // toString method
    public String toString(){
        return "[ "+ this.getTitle() + ", " + this.getLength() + " ]";
    }
    // equals method

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Track other = (Track) obj;
        if (this.getTitle() == null){
            if(other.title != null){
                return false;
            }
        } else if (!title.equals(other.title)){
            return false;
        }
        return length == other.getLength();
    }
}

package AimsProject.hust.soict.globalict.aims.media.comparator;

import AimsProject.hust.soict.globalict.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost  implements Comparator<Media> {

    @Override
    public int compare(Media media1, Media media2) {
        try {
            int titleDiff = media1.getTitle().compareTo(media2.getTitle());
            if (titleDiff != 0) {
                return titleDiff;
            }

            float costDiff = media1.getCost() - media2.getCost();
            if (costDiff > 0) {
                return 1;
            } else if (costDiff < 0) {
                return -1;
            }
            return 0;
        } catch (NullPointerException e) {
            return -1;
        }
    }

}

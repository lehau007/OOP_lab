package hust.soict.global_ict.aims.media.Comparator;

import java.util.Comparator;
import hust.soict.global_ict.aims.media.Media;

public class Title_Cost implements Comparator <Media>{
	public int compare(Media m1, Media m2) {
		Double cost1 = (double) m1.getCost();
		Double cost2 = (double) m2.getCost();
		String title1 = m1.getTitle();
		String title2 = m2.getTitle();
		int titleDiff = title1.compareTo(title2);
		
		return titleDiff == 0 ? cost1.compareTo(cost2) : titleDiff;  
	}
}


package Media.Comparator;

import java.util.Comparator;

import Media.media;

public class Title_Cost implements Comparator <media>{
	public int compare(media m1, media m2) {
		Double cost1 = (double) m1.getCost();
		Double cost2 = (double) m2.getCost();
		String t1 = m1.getTitle();
		String t2 = m2.getTitle();
		int titleDiff = t1.compareTo(t2);
		
		return titleDiff == 0 ? cost1.compareTo(cost2) : titleDiff;  
	}
}

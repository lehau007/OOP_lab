package Media.Comparator;

import java.util.Comparator;

import Media.media;

public class Cost_Tilte implements Comparator <media> {
	public int compare(media m1, media m2) {
		Double cost1 = (double) m1.getCost();
		Double cost2 = (double) m2.getCost();
		String t1 = m1.getTitle();
		String t2 = m2.getTitle();
		int costDiff = cost1.compareTo(cost2);
		
		return costDiff == 0 ? t1.compareTo(t2) : costDiff;  
	}
}
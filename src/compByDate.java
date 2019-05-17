import java.util.Comparator;

public class compByDate implements Comparator<Project>{

	public int compare(Project p1, Project p2) {
		
		int dateP1;
		int dateP2;
		
		dateP1 = p1.getEndDate().getYear() * 365 +
				+	p1.getEndDate().getMonth() * 30;
		
		dateP2 = p2.getEndDate().getYear() * 365 +
				+	p2.getEndDate().getMonth() * 30;
		
		
		if( dateP1 > dateP2 )
			return 1;
		
		if( dateP1 < dateP2 )
			return -1;
		
		if( dateP1 == dateP2 )
			return ( p1.hashCode() > p2.hashCode() ) ? 1 : -1;
		
		return 0;
	}
	
}
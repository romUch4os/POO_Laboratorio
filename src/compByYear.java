import java.util.Comparator;

public class compByYear implements Comparator<AcademicProduction>{

	public int compare(AcademicProduction sub1, AcademicProduction sub2) {

		if( ((Publication) sub1).getYear() > ((Publication) sub2).getYear() )
			return 1;
		
		if( ((Publication) sub1).getYear() < ((Publication) sub2).getYear() )
			return -1;
		
		if( ((Publication) sub1).getYear() == ((Publication) sub2).getYear() )
			return ( ((Publication) sub1).hashCode() > ((Publication) sub2).hashCode() ) ? 1 : -1;
		
		return 0;
	}
	
}
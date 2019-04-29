import java.util.List;
import java.util.ArrayList;

public class Publication extends AcademicProduction{
	
	private List <Collaborator> authors;
	private String conference;
	private int year;
	
	public Publication() {
		
		authors = new ArrayList<Collaborator>();
	}
	
	public String getConference() {
		return conference;
	}
	public void setConference(String conference) {
		this.conference = conference;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getNumAuthors() {
		return authors.size();
	}
	
	public void setAuthor(Collaborator author) {
		authors.add(author);
	}
	
	public boolean isValid() {
		
		if( getNumAuthors() > 0 )
			return true;
		
		return false;
	}
	
	
	
}
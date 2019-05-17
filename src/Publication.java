import java.util.Collection;
import java.util.HashSet;

public class Publication extends AcademicProduction{
	
	private Collection<Collaborator> authors;
	private String conference;

	public Publication() {
		
		authors = new HashSet<Collaborator>();
	}
	
	public String getConference() {
		return conference;
	}
	public void setConference(String conference) {
		this.conference = conference;
	}
	
	public int getNumAuthors() {
		return authors.size();
	}
	
	public void setAuthor(Collaborator author) {
		authors.add(author);
	}
}
public class Publication extends AcademicProduction{
	
	private int numAuthors = 0;
	private Collaborator[] authors;
	private String conference;
	private int year;
	
	public Publication() {
		
		authors = new Collaborator[25];
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
		return numAuthors;
	}
	
	public void setAuthor(Collaborator author) {
		authors[numAuthors] = author;
		numAuthors++;
	}
	
	
}
public class AcademicProduction{
	
	private int id;
	private String title;
	private Date date;
	
	public AcademicProduction() {
		
		date = new Date();
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getYear() {
		return date.getYear();
	}
	
	public void setYear(int year) {
		date.setYear(year);
	}
	
	// implementation of equals adn hashCode to hashSet
	public boolean equals(AcademicProduction ap) {
		
		if( ap == null )
			return false;
		
		if( this == ap )
			return true;
		
		return this.hashCode() == ap.hashCode();
	}
	
	public int hashCode() {
		
		id = title.hashCode();
		return id;
	}
}
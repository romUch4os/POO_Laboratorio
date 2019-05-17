import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class Project {
	
	private int id;
	private String title;
	private Date startDate;
	private Date endDate;
	private String agency;
	private String value;
	private String goal;
	private String description;
	private String status = "EM ELABORACAO";
	private Teacher manager;
	private Collection<Collaborator> collaborators;
	private Collection<AcademicProduction> submissions;
	
	public Project() {
		
		collaborators = new HashSet<Collaborator>();
		submissions = new HashSet<AcademicProduction>();
	}
	
	public int getNumCollaborators() {
		return collaborators.size();
	}
	
	public int getNumSubmissions() {
		return submissions.size();
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getAgency() {
		return agency;
	}
	
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getGoal() {
		return goal;
	}
	
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Teacher getManager() {
		return manager;
	}
	
	public void setManager(Teacher manager) {
		this.manager = manager;
	}
	
	public String getDate() {
		
		String date;
		
		date = Integer.toString(startDate.getMonth()) + "/" + Integer.toString(startDate.getYear());
		
		date = date + " ~ ";
		
		date = date + Integer.toString(endDate.getMonth()) + "/" + Integer.toString(endDate.getYear());
		
		return date;
	}
	
	public Collaborator getCollaborator(String collaborator) {
		
		for( Collaborator c: collaborators)
			if( c.getName().equals(collaborator) )
				return c;
		
		return null;
	}
	
	public void setCollaborator(Collaborator collaborator) {
		collaborators.add(collaborator);
	}
	
	public boolean isInProject(Collaborator c) {
		return collaborators.contains(c);
	}
	
	public void setSubmission(AcademicProduction submission) {
		submissions.add(submission);
	}
	
	//	verifica e atualiza etapas do projeto
	//	etapas: elaboracao -> andamento -> conclusao
	public boolean updateStatus() {
		
		if( status.contentEquals("EM ELABORACAO") ) {
			status = "EM ANDAMENTO";
			return true;
		}
		
		if( status.contentEquals("EM ANDAMENTO") ) {
			
			if( getNumSubmissions() > 0 ) {
				
				for( Collaborator c : collaborators )
					if( c instanceof GraduationStudent )
						((GraduationStudent) c).freeStudent();
				
				status = "CONCLUIDO";
				
				return true;
			}
		}
		
		return false;
	}
	
	public Collection<Collaborator> listCollaborators() {
		
		return collaborators;
	}
	
	//	retorna submissions ordenadas por ano
	public Collection<AcademicProduction> listSubmissions() {
		
		Collection<AcademicProduction> sortedSub = new TreeSet<AcademicProduction>(new compByYear());
		sortedSub.addAll(submissions);
		
		return sortedSub;
	}
	
	//	implementation of equals and hashCode to hashSet
	public boolean equals(Project p) {
		
		if( p == null )
			return false;
		
		if( this == p )
			return true;
		
		return this.hashCode() == p.hashCode();
	}
	
	public int hashCode() {
		
		id = title.hashCode();
		return id;
	}
}
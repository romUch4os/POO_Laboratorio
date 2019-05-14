import java.util.Collection;
import java.util.HashSet;

public class Collaborator{
	
	private int id;
	private String name;
	private String email;
	private Collection<Project> projects;
	private Collection<AcademicProduction> submissions;
	
	public Collaborator() {
		
		projects = new HashSet<Project>();
		submissions = new HashSet<AcademicProduction>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setProject(Project project) {
		projects.add(project);
	}
	
	public void setSubmission(AcademicProduction submission) {
		submissions.add(submission);
	}
	
	public String listProjects() {

		String projectList = "";
		
		for( Project p: projects )
			projectList = projectList + p.getTitle() + "; ";
			
		return projectList;
	}

	public String listSubmissions() {
		
		String submissionsList = "";
		
		for( AcademicProduction s: submissions )
			submissionsList = submissionsList + s.getTitle() + "; ";
			
		return submissionsList;
	}

	// tentaativa implementar hashCode e equals
	public boolean equals(Object obj) {
		
		if( obj == null )
			return false;
		
		if(!( obj instanceof Collaborator ))
			return false;
		
		if( this == obj )
			return true;
		
		//return getName() == ((Collaborator) obj).getName();
		return this.hashCode() == ((Collaborator) obj).hashCode();
	}

	public int hashCode() {
		
		id = name.hashCode();
		return id;
	}
}
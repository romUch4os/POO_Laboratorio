import java.util.Set;
import java.util.HashSet;

public class Collaborator{
	
	private String name;
	private String email;
	private Set<Project> projects;
	private Set<AcademicProduction> submissions;
	
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
	
	//	a listagem pode ser feita apenas com um get
	//	mas preferi visualmente assim
	
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
}
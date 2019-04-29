import java.util.List;
import java.util.ArrayList;

public class Collaborator{
	
	private String name;
	private String email;
	private List<Project> projects;
	private List<AcademicProduction> submissions;
	
	public Collaborator() {
		
		projects = new ArrayList<Project>();
		submissions = new ArrayList<AcademicProduction>();
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
	
	public void setSubmissions(AcademicProduction submission) {
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
}
public class Collaborator{
	
	private String name;
	private String email;
	private int numProjects = 0;
	private Project[] projects;
	private int numSubmissions = 0;
	private AcademicProduction[] submissions;
	
	public Collaborator() {
		
		projects = new Project[25];
		submissions = new AcademicProduction[25];
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
		projects[numProjects] = project;
		numProjects++;
	}
	
	public void setSubmissions(AcademicProduction submission) {
		submissions[numSubmissions] = submission;
		numSubmissions++;
	}
	
	public String listProjects() {
		
		String projectList = "";
		
		for(int i = 0; i < numProjects; i ++)
			projectList = projectList + projects[i].getTitle() + "; ";
			
		return projectList;
	}

	public String listSubmissions() {
		
		String submissionsList = "";
		
		for(int i = 0; i < numSubmissions; i++)
			submissionsList = submissionsList + submissions[i].getTitle() + "; ";
			
		return submissionsList;
	}
}
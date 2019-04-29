public class Lab{
	
	private String name = "fucking LAB da UFSJ";
	private int numCollaborators = 0;
	private Collaborator[] collaborators;
	private int numProjects = 0;
	private Project[] projects;
	private int numSubmissions = 0;
	private AcademicProduction[] submissions;
	
	public Lab(){
		
		collaborators = new Collaborator[25];
		projects = new Project[25];
		submissions = new AcademicProduction[25];
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getNumCollaborators() {
		return numCollaborators;
	}
	
	public int getNumProjects() {
		return numProjects;
	}
	
	public int getNumSubmissions() {
		return numSubmissions;
	}
	
	public Project getProject(String title) {
		
		for(int i = 0; i < numProjects; i++)
			if(projects[i].getTitle().equals(title))
				return projects[i];
		
		return null;
	}
	
	public Collaborator getCollaborator(String name) {
		
		for(int i = 0; i < numCollaborators; i++)
			if(collaborators[i].getName().equals(name))
				return collaborators[i];
		
		return null;
	}
	
	/*
	public boolean addProject(Project project) {
		
		for(Project p: projects)
			if(p.getTitle().equals(project.getTitle()))
				return false;
		
		for(Collaborator c: collaborators)
			if(c.getName().equals(project.getManager()))
				if(!(c instanceof Teacher))
					return false;
		
		projects[projects.length] = project;
		
		return true;
		
	}
	*/

	public boolean addProject(Project project) {
		
		for(int i = 0; i < numProjects; i++)
			if(projects[i].getTitle().equals(project.getTitle()))
				return false;
		
		Collaborator collaborator = getCollaborator(project.getManager().getName());
		
		if(collaborator == null)
			return false;
		
		if(!(collaborator instanceof Teacher))
			return false;
		
		project.setCollaborator(collaborator);
		collaborator.setProject(project);
		
		projects[numProjects] = project;
		numProjects++;
		
		return true;
	}
	
	public boolean addCollaborator(Collaborator collaborator) {
		
		for(int i = 0; i < this.numCollaborators; i++) 
			if(collaborators[i].getName().equals(collaborator.getName()))
				return false;
		
		collaborators[numCollaborators] = collaborator;
		numCollaborators++;
		
		return true;
		
	}
	public boolean addSubmission(AcademicProduction submission) {
		
		if(submission instanceof Publication)
			if(((Publication) submission).getNumAuthors() <= 0)
				return false;
		
		submissions[numSubmissions] = submission;
		numSubmissions++;
		return true;
	}
	
	
	public boolean allocCollaborator(String collaborator, String project) {
		
		Collaborator c = getCollaborator(collaborator);
		Project p = getProject(project);
		
		if(c instanceof GraduationStudent)
			if(((GraduationStudent) c).getInProject())
				return false;
			else
				((GraduationStudent) c).setInProject(true);
		
		c.setProject(p);
		p.setCollaborator(c);
		
		return true;
	}
	
	public int getNumBuilding() {
		
		int num = 0;
		
		for(int i = 0; i < numProjects; i++)
			if(projects[i].getStatus().equals("EM ELABORACAO"))
				num++;
		
		return num;
	}
	
	public int getNumInProgress() {
		
		int num = 0;
		
		for(int i = 0; i < numProjects; i++)
			if(projects[i].getStatus().equals("EM ANDAMENTO"))
				num++;
		
		return num;
	}
	
	public int getNumFinished() {
		
		int num = 0;
		
		for(int i = 0; i < numProjects; i++)
			if(projects[i].getStatus().equals("CONCLUIDO"))
				num++;
		
		return num;
	}
		
}
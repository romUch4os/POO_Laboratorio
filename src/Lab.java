import java.util.Set;
import java.util.HashSet;

public class Lab{
	
	private String name = "fucking LAB da UFSJ";
	// fazer as modificacoes pra passar pra collaborators pra HashSet
	// e dos outros comentarios
	private Set<Collaborator> collaborators;
	private Set<Project> projects;
	private Set<AcademicProduction> submissions;
	
	public Lab(){
		
		collaborators = new HashSet<Collaborator>();
		projects = new HashSet<Project>();
		submissions = new HashSet<AcademicProduction>();
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getNumCollaborators() {
		return collaborators.size();
	}
	
	public int getNumProjects() {
		return projects.size();
	}
	
	public int getNumSubmissions() {
		return submissions.size();
	}
	
	public boolean isCollaborator(String name) {
		
		for( Collaborator c: collaborators )
			if( c.getName().equals(name) )
				return true;
		
		return false;
	}
	
	public Collaborator getCollaborator(String name) {
		
		for( Collaborator c: collaborators )
			if( c.getName().equals(name))
				return c;
		
		return null;
	}
	
	public boolean isProject(String title) {
		
		for( Project p: projects )
			if( p.getTitle().equals(title) )
				return true;
		
		return false;
	}
	
	public Project getProject(String title) {
		
		for( Project p: projects )
			if( p.getTitle().equals(title))
				return p;
		
		return null;
	}
	
	public boolean isSubmission(String title) {
		
		for( AcademicProduction s: submissions )
			if( s.getTitle().equals(title) )
				return true;
		
		return false;
	}
	
	public AcademicProduction getSubmission(String title) {
		
		for( AcademicProduction s: submissions )
			if( s.getTitle().equals(title))
				return s;
		
		return null;
	}

	public boolean addProject(Project project) {
		
		if(!( isCollaborator( project.getManager().getName() ) ))
			return false;
		
		Collaborator collaborator = getCollaborator( project.getManager().getName() );
		
		if(!( collaborator instanceof Teacher ))
			return false;
		
		project.setCollaborator(collaborator);
		collaborator.setProject(project);
		
		projects.add(project);
		
		return true;
	}
	
	public boolean addCollaborator(Collaborator collaborator) {
		
		if( isCollaborator( collaborator.getName() ))
			return false;
		
		collaborators.add(collaborator);
		
		return true;
		
	}
	
	public boolean addSubmission(AcademicProduction submission) {
		
		if( submission instanceof Publication )
			if(!( ((Publication) submission).isValid() ))
				return false;
		
		submissions.add(submission);
		return true;
	}
	
	
	public boolean allocCollaborator(String collaborator, String project) {
		
		if(!( isCollaborator(collaborator) ))
			return false;
		
		if(!( isProject(project) ))
			return false;
		
		Collaborator c = getCollaborator(collaborator);
		Project p = getProject(project);
		
		if( c instanceof GraduationStudent )
			if( ((GraduationStudent)c).getInProject() )
				return false;
			else
				((GraduationStudent)c).setInProject(true);
		
		c.setProject(p);
		p.setCollaborator(c);
		
		return true;
	}
	
	public int getNumBuilding() {
		
		int num = 0;
		
		for( Project p: projects )
			if( p.getStatus().equals("EM ELABORACAO") );
				num++;
		
		return num;
	}
	
	public int getNumInProgress() {
		
		int num = 0;
		
		for( Project p: projects )
			if( p.getStatus().equals("EM ANDAMENTO") )
				num++;
		
		return num;
	}
	
	public int getNumFinished() {
		
		int num = 0;
		
		for( Project p: projects )
			if( p.getStatus().equals("CONCLUIDO") )
				num++;
		
		return num;
	}
		
}
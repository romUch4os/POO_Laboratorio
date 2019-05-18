import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

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

	//	verifica se o colaborador eh estudante de graduacao
	//	e se ja esta em algum projeto
	//	(se for graduando soh pode estar em 1 em andamento)
	public boolean isAllocable() {
		
		if( this instanceof GraduationStudent )
			if( ((GraduationStudent) this).getInProject() )
				return false;
		
		return true;
	}
	
	//	retorna uma collection dos projetos
	//	ordenados por data de termino
	public Collection<Project> listProjects() {
		
		Collection<Project> sortedP = new TreeSet<Project>(new compByDate());
		sortedP.addAll(projects);
		
		return sortedP;
	}
	
	//	retorna uma collection da producao academica
	//	ordenados por ano
	//	(nesse caso em expecifico, 
	//		a producao academica eh formada apenas por publication)
	public Collection<AcademicProduction> listSubmissions() {
		
		Collection<AcademicProduction> sortedSub = new TreeSet<AcademicProduction>(new compByYear());
		sortedSub.addAll(submissions);
		
		return sortedSub;
	}

	//	implementation of equals and hashCode to haseSet
	public boolean equals(Collaborator c) {
		
		if( c == null )
			return false;
		
		if( this == c )
			return true;
		
		return this.hashCode() == c.hashCode();
	}

	public int hashCode() {
		
		id = name.hashCode();
		return id;
	}
}
import java.util.Collection;
import java.util.HashSet;

public class Lab{
	
	private String name = "fucking LAB da UFSJ";
	private Collection<Collaborator> collaborators;
	private Collection<Project> projects;
	private Collection<AcademicProduction> submissions;
	
	/*
	 *	Todas as collections sao implementadas
	 *	por hashSet, oq nos dah o poder de limitar
	 *	os elementos dos conjuntos por nomes.
	 *	Em suma: nao existe 2 elementos com msm nome.
	 */
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
	
	//	procura colaborador por nome
	public Collaborator getCollaborator(String name) {
		
		for( Collaborator c: collaborators )
			if( c.getName().equals(name) )
				return c;
		
		return null;
	}
	
	//	adiciona o colaborador no laboratorio
	public boolean setCollaborator(Collaborator c) {
		
		return collaborators.add(c);
	}
	
	//	procura projeto por nome
	public Project getProject(String title) {
		
		for( Project p: projects )
			if( p.getTitle().equals(title))
				return p;
		
		return null;
	}
	
	 /* 
	  *	Verifica se o gerente do projeto eh um professor
	  *	e se o periodo em que ocorrerah eh valido.
	  *	Caso passe nas verificacoes, o projeto eh adicionado.
	  */
	public boolean setProject(Project p, Collaborator manager) {
		
		if( ( manager == null ) || !( manager instanceof Teacher ) )
			return false;
		
		if( !( p.getStartDate().validatePeriod(p.getEndDate()) ))
			return false;
		
		if( projects.add(p) ) {
		
			p.setManager((Teacher) manager);
			p.setCollaborator(manager);
			manager.setProject(p);
			return true;
		
		} else
			return false;
	}
	
	//	procura producao academica por nome
	public AcademicProduction getSubmission(String title) {
		
		for( AcademicProduction sub: submissions )
			if( sub.getTitle().equals(title))
				return sub;
		
		return null;
	}
	
	/*
	 * 	A publicacao passa por verificacoes para ser adicionada. 
	 * 	Verificacoes:
	 * 		Existem colaboradores na Collection;
	 * 		Projeto está em andamento;
	 * 		A data da publicacao esta dentro do periodo do projeto;
	 * 		Os colaboradores fazem parte do projeto.
	 */
	public boolean setSubmission(AcademicProduction submission, Project p, Collection<Collaborator> cSet) {
		
		if( ( p == null ) || ( cSet.size() == 0 ) )
			return false;
		
		if( ! (p.getStatus().equals("EM ANDAMENTO") ) )
			return false;
		
		if( !( submission.getDate().validatePublication(p.getStartDate(), p.getEndDate()) ))
			return false;
		
		for( Collaborator c: cSet )
			if( ! ( p.isInProject(c) ) )
				return false;
		
		if( submissions.add(submission) ) {
			
			p.setSubmission(submission);
			for( Collaborator c: cSet )
				c.setSubmission(submission);
			
			return true;
			
		} else
			return false;	
	}
	
	/*
	 * 	Verifica validade de colaborador e projeto
	 * 	Verifica se pode ser alocado
	 * 	Tudo ok -> aloca o colaborador ao projeto
	 * */
	public boolean allocCollaborator(Collaborator c, Project p) {
		
		if( ( c == null ) || ( p == null ) )
			return false;
		
		if( ! ( c.isAllocable() ) )
			return false;
		
		c.setProject(p);
		p.setCollaborator(c);
		
		if( c instanceof GraduationStudent )
			((GraduationStudent) c).setInProject();
		
		return true;
	}
	
	//	retorna o numero de projetos por etapa
	public int getNumBuilding() {
		
		int num = 0;
		
		for( Project p: projects )
			if( p.getStatus().equals("EM ELABORACAO") )
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
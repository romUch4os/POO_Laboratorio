import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;


// 	tirar \n na hora de imprimir as consultas
public class Program{
	
	public static Lab lab = new Lab();
	static Scanner s = new Scanner(System.in);
	
	public static void main(String args[]) {

		int opt;
		
		do {
			
			System.out.println("< Bem vindo ao " + lab.getName() + " >");
			System.out.println("Suas opcoes sao:");
			System.out.println("1)  Menu Projeto( Novo; Atualizar status; Publicar )");
			System.out.println("2)  Adicionar Colaborador");
			System.out.println("3)  Alocar Colaborador");
			System.out.println("4)  Consultar( Colaborador; Projeto )");
			System.out.println("5)  Relatorio Producao Academica");
			System.out.println("0)  Sair");
			System.out.print("Selecione a opcao: ");
			
			opt = readKey();
			
			switch( opt ) {
			
				case 1:
					projectMenu();
					break;
				case 2:
					collaboratorMenu();
					break;
				case 3:
					if( allocCollaborator() )
						System.out.println("Colaborador alocado!!");
					else
						System.out.println("ALOCACAO INVALIDA!!");
					break;
				case 4:
					consultMenu();
					break;
				case 5:
					report();
					break;
				case 0:
					System.out.println("=============");
					System.out.println("|| see ya! ||");
					System.out.println("=============");
					break;
				default:
					System.out.println("OPCAO INVALIDA!!");
					break;
			}
		}while( opt != 0 );
		
		s.close();
	}
	
	public static void projectMenu() {
		
		System.out.println("<---- Menu Projeto ---->");
		System.out.println("1)  Novo projeto");
		System.out.println("2)  Atualizar status do projeto");
		System.out.println("3)  Nova publicacao");
		System.out.println("-)  Qualquer outro valor p/ voltar");
		
		int opt = readKey();
		
		switch(opt) {
		
			case 1:
				if( addProject() )
					System.out.println("Projeto adicionado!!");
				else
					System.out.println("INFORMACOES INVALIDAS!!");
				break;
			case 2:
				if( updateStatus() )
					System.out.println("Status Updated!!");
				else
					System.out.println("IMPOSSIVEL ALTERAR STATUS!!");
				break;
			case 3:
				if( addPublication() )
					System.out.println("Publicacao lancada!!");
				else
					System.out.println("IMPOSSIVEL PUBLICAR!!/INV. INFO!!");
				break;
			default:
				break;
		}
	}
	
	public static void collaboratorMenu() {
		
		System.out.println("<---- Adicionar Colaborador ---->");
		System.out.println("1)  Estudante de Graduacao");
		System.out.println("2)  Estudante de Mestrado");
		System.out.println("3)  Pesquisador");
		System.out.println("4)  Professor");
		System.out.println("-)  Qualquer outro valor p/ voltar");
		
		int opt = readKey();
		
		switch(opt) {
		
			case 1:
				addGradStudent();
				break;
			case 2:
				addMastersStudent();
				break;
			case 3:
				addResearcher();
				break;
			case 4:
				addTeacher();
				break;
			default:
				break;
		}
	}
	
	public static void consultMenu() {
		
		System.out.println("<---- Menu Consulta ---->");
		System.out.println("1)  Colaborador");
		System.out.println("2)  Projeto");
		System.out.println("-)  Qualquer outro valor p/ voltar");
		
		int opt = readKey();
		
		switch(opt) {
		
			case 1:
				consultCollaborator();
				break;
			case 2:
				consultProject();
				break;
			default:
				break;
		}
	}
	
	public static boolean addProject() {
		
		System.out.println("-> Titulo do projeto:");
		String title = s.next();
		
		System.out.println("Professor gerente:");
		String managerName = s.next();
		
		Collaborator manager = lab.getCollaborator(managerName);
		
		int month;
		int year;
		
		System.out.println("Data de inicio(MM-YYYY):");
		System.out.println("Mês:");
		month = readMonth();
		System.out.println("Ano:");
		year = readYear();
		Date startDate = new Date(month, year);
		
		System.out.println("Data de termino(MM-YYYY):");
		System.out.println("Mês:");
		month = readMonth();
		System.out.println("Ano:");
		year = readYear();
		Date endDate = new Date(month, year);
		
		System.out.println("Agencia financiadora:");
		String agency = s.next();
		
		System.out.println("Valor financiado:");
		String value = s.next();
		
		System.out.println("Objetivo do projeto:");
		String goal = s.next();
		
		System.out.println("Descricao do projeto:");
		String description = s.next();
		
		Project project = new Project();
		project.setTitle(title);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		project.setAgency(agency);
		project.setValue(value);
		project.setGoal(goal);
		project.setDescription(description);
		
		return lab.setProject(project, manager);
	}
	
	public static void addCollaborator(Collaborator c) {
		
		System.out.println("-> Nome do colaborador:");
		String name = s.next();
		
		System.out.println("Email do colaborador:");
		String email = s.next();
		
		c.setName(name);
		c.setEmail(email);		
	}
	
	public static void addGradStudent() {
		
		GraduationStudent student = new GraduationStudent();
		
		addCollaborator(student);
		
		if( lab.setCollaborator(student) )
			System.out.println("Estudante de Graduacao addicionado!");
		else
			System.out.println("COLABORADOR JA EXISTE!!");
	}
	
	public static void addMastersStudent() {
		
		MastersStudent student = new MastersStudent();
		
		addCollaborator(student);
		
		if( lab.setCollaborator(student) )
			System.out.println("Estudante de Mestrado addicionado!");
		else
			System.out.println("COLABORADOR JA EXISTE!!");
	}
	
	public static void addResearcher() {
		
		Researcher researcher = new Researcher();
		
		addCollaborator(researcher);
		
		if( lab.setCollaborator(researcher) )
			System.out.println("Pesquisador addicionado!");
		else
			System.out.println("COLABORADOR JA EXISTE!!");
	}
	
	public static void addTeacher() {
		
		Teacher teacher = new Teacher();
		
		addCollaborator(teacher);
		
		if( lab.setCollaborator(teacher) )
			System.out.println("Professor addicionado!");
		else
			System.out.println("COLABORADOR JA EXISTE!!");

	}
	
	public static boolean allocCollaborator() {
		
		System.out.println("-> Alocaremos um colaborador para algum projeto!");
		System.out.println("Colaborador:");
		String name = s.next();
		
		System.out.println("Projeto:");
		String title = s.next();
		
		Collaborator c = lab.getCollaborator(name);
		Project p = lab.getProject(title);
		
		return lab.allocCollaborator(c, p);
	}

	public static boolean updateStatus() {
		
		System.out.println("-> Atualizar status de qual projeto?");
		String title = s.next();
		
		Project project = lab.getProject(title);
		
		if( project == null )
			return false;
		
		return project.updateStatus();
	}
	
	public static boolean addPublication() {
		
		System.out.println("-> A qual projeto pertence a publicacao?");
		String projectTitle = s.next();
		
		Project project = lab.getProject(projectTitle);
		
		System.out.println("Titulo da publicacao:");
		String title = s.next();
		
		System.out.println("Conferencia da publicacao:");
		String local = s.next();
		
		System.out.println("Ano da publicacao:");
		int year = readYear();
	
		Publication publication = new Publication();
		publication.setTitle(title);
		publication.setConference(local);
		publication.setYear(year);
		
		System.out.println("Colaboradores da publicacao:");
		System.out.println("Digite 'final' quando terminar");
		String name;
		Collection<Collaborator> collaborators = new HashSet<Collaborator>();
			
		do {

			System.out.println("Colaborador:");				
			name = s.next();
				
			Collaborator c = lab.getCollaborator(name);
			
			if( c != null )
				collaborators.add(c);
				
		}while( ! ( name.equals("final") ));
			
		return lab.setSubmission(publication, project, collaborators);
	}
	
	public static void consultCollaborator() {
		
		System.out.println("Nome do colaborador:");
		String name = s.next();
		
		Collaborator collaborator = lab.getCollaborator(name);
		
		if( ! (collaborator == null) ) {

			System.out.println("-> Informacoes do colaborador:");
			System.out.println("Nome: " + collaborator.getName());
			System.out.println("Email: " + collaborator.getEmail());

			Collection<Project> sortedP = collaborator.listProjects();
			
			System.out.println("Projetos: ");
			for( Project p : sortedP )
				System.out.print(p.getTitle() + "[" + p.getDate() + "]; ");
			
			Collection<AcademicProduction> sortedSub = collaborator.listSubmissions();
			
			System.out.println("Producao academica: ");
			for( AcademicProduction ap : sortedSub )
				System.out.print(ap.getTitle() + "[" + ap.getYear() + "]; ");
			
		} else
			System.out.println("NOME INVALIDO!!");
	}
	
	public static void consultProject() {
		
		System.out.println("Titulo do projeto:");
		String title = s.next();
		
		Project project = lab.getProject(title);
		
		if( ! (project == null) ){
			
			System.out.println("-> Insformacoes do projeto(" + project.getStatus() + "):");
			System.out.println("Descricao: " + project.getDescription());
			System.out.println("Gerente: " + project.getManager().getName());
			System.out.println("Data: " + project.getDate());
			System.out.println("Agencia: " + project.getAgency());
			System.out.println("Valor finaciado: $" + project.getValue());
			System.out.println("Objetivo: " + project.getGoal());
			
			Collection<Collaborator> collaborators = project.listCollaborators();
			
			System.out.println("Colaboradores: ");
			for( Collaborator c : collaborators )
				System.out.print( c.getName() + "; ");
			
			Collection<AcademicProduction> sortedSub = project.listSubmissions();
			
			System.out.println("Producao academica: ");
			for( AcademicProduction ap : sortedSub )
				System.out.print(ap.getTitle() + "[" + ap.getYear() + "]; ");
			
		} else
			System.out.println("TITULO INVALIDO!!");
	}
	
	public static void report() {
		
		System.out.println("-> Relatorio de producao do laboratorio:");
		System.out.println("Colaboradores:" + lab.getNumCollaborators());
		System.out.println("Projetos em elaboracao:" + lab.getNumBuilding());
		System.out.println("Projetos em andamento:" + lab.getNumInProgress());
		System.out.println("Projetos concluidos:" + lab.getNumFinished());
		System.out.println("Projetos:" + lab.getNumProjects());
		System.out.println("Publicacoes/Orientacoes:" + lab.getNumSubmissions());
		
	}
	
	public static int readKey() {
		
		String reader;
		int n;
		
		reader = s.next();
		
		try {
			n = Integer.parseInt(reader);
		}
		catch( Exception e ) {
			n = -1;
		}
		
		return n;
	}
	
	public static int readMonth() {
		
		String reader;
		int value;
		
		reader = s.next();
		
		try {
			value = Integer.parseInt(reader);
		}
		catch( Exception e ) {
			value = -1;
		}
		
		return ( ( value > 0 ) && ( value < 13 ) ) ? value : -1;
	}
	
	public static int readYear() {

		String reader;
		int value;
		
		reader = s.next();
		
		try {
			value = Integer.parseInt(reader);
		}
		catch( Exception e ) {
			value = -1;
		}
		
		return ( value >= 2009 ) ? value : -1;
	}
}
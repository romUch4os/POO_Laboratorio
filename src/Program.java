import java.util.Scanner;

public class Program{
	
	static Lab lab = new Lab();
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
		
		opt = s.nextInt();
		
			switch(opt) {
				case 1:
					projectMenu();
					break;
				case 2:
					collaboratorMenu();
					break;
				case 3:
					allocCollaborator();
					break;
				case 4:
					consultMenu();
					break;
				case 5:
					report();
					break;
				case 0:
					System.out.println("see ya!");
					break;
			}
		}while(opt != 0);
		
		s.close();
	}
	
	public static void projectMenu() {
		
		System.out.println("<---- Menu Projeto ---->");
		System.out.println("1)  Novo projeto");
		System.out.println("2)  Atualizar status do projeto");
		System.out.println("3)  Nova publicacao");
		System.out.println("-)  Qualquer outro valor p/ voltar");
		
		int opt = s.nextInt();
		
		switch(opt) {
		
			case 1:
				addProject();
				break;
			case 2:
				updateStatus();
				break;
			case 3:
				addPublication();
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
		
		int opt = s.nextInt();
		
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
		
		int opt = s.nextInt();
		
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
	
	public static void addProject() {
		
		System.out.println("-> Titulo do projeto:");
		String title = s.next();
		
		System.out.println("Professor gerente:");
		String managerName = s.next();
			
		Collaborator manager = lab.getCollaborator(managerName);
		
		int month;
		int year;
		
		System.out.println("Data de inicio(MM-YY):");
		System.out.println("Mês:");
		month = s.nextInt();
		System.out.println("Ano:");
		year = s.nextInt();
		Date startDate = new Date(month, year);
		
		System.out.println("Data de termino(MM-YY):");
		System.out.println("Mês:");
		month = s.nextInt();
		System.out.println("Ano:");
		year = s.nextInt();
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
		project.setManager((Teacher)manager);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		project.setAgency(agency);
		project.setValue(value);
		project.setGoal(goal);
		project.setDescription(description);
		
		if( lab.addProject(project) )
			System.out.println("Projeto adicionado!!");
		
		else
			System.out.println("Dados invalidos!!");
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
		
		if( lab.addCollaborator(student) )
			System.out.println("Estudante de Graduacao addicionado!");
		else
			System.out.println("Ja existe colaborador com esse nome!");
	}
	
	public static void addMastersStudent() {
		
		MastersStudent student = new MastersStudent();
		
		addCollaborator(student);
		
		if( lab.addCollaborator(student) )
			System.out.println("Estudante de Mestrado addicionado!");
		else
			System.out.println("Ja existe colaborador com esse nome!");
	}
	
	public static void addResearcher() {
		
		Researcher researcher = new Researcher();
		
		addCollaborator(researcher);
		
		if( lab.addCollaborator(researcher) )
			System.out.println("Pesquisador addicionado!");
		else
			System.out.println("Ja existe colaborador com esse nome!");
	}
	
	public static void addTeacher() {
		
		Teacher teacher = new Teacher();
		
		addCollaborator(teacher);
		
		if( lab.addCollaborator(teacher) )
			System.out.println("Professor addicionado!");
		else
			System.out.println("Ja existe colaborador com esse nome!");

	}
	
	public static void allocCollaborator() {
		
		System.out.println("-> Alocaremos um colaborador para algum projeto!");
		System.out.println("Colaborador:");
		String name = s.next();
		
		System.out.println("Projeto:");
		String project = s.next();
		
		if( lab.allocCollaborator(name, project) )
			System.out.println("Colaborador alocado com sucesso!");
		else
			System.out.println("ALOCACAO INVALIDA!!");
	}

	public static void updateStatus() {
		
		System.out.println("-> Atualizar status de qual projeto?");
		String title = s.next();
		
		Project project = lab.getProject(title);
		
		if( ! (project == null) ) {
			
			System.out.println("Status antigo:" + project.getStatus());
			
			if( ! (project.updateStatus()) )
				System.out.println("O STATUS NAO PODE SER ALTERADO!!");
				
			System.out.println("Status atual:" + project.getStatus());
			
		}else
			System.out.println("PROJETO INEXISTENTE!!");
	}
	
	public static void addPublication() {
		
		System.out.println("-> A qual projeto pertence a publicacao?");
		String projectTitle = s.next();
		
		Project project = lab.getProject(projectTitle);
		
		if( ( project != null ) && ( project.getStatus().equals("EM ANDAMENTO") ) ) {

			System.out.println("Titulo da publicacao:");
			String title = s.next();
			
			System.out.println("Conferencia da publicacao:");
			String local = s.next();

			System.out.println("Ano da publicacao:");
			int year = s.nextInt();
			
			Publication publication = new Publication();
			publication.setTitle(title);
			publication.setConference(local);
			publication.setYear(year);

			System.out.println("Colaboradores da publicacao:");
			System.out.println("Digite 'final' quando terminar");
			String collaborator;
			
			do {

				System.out.println("Colaborador:");				
				collaborator = s.next();
				
				if( project.isInProject(collaborator) ) {
					
					Collaborator c = project.getCollaborator(collaborator);
					publication.setAuthor(c);
					c.setSubmission(publication);
					
				} else
					if( ! (collaborator.equals("final")) )
						System.out.println("COOLABORADOR "
								+ "NAO EXISTE OU NAO PARTICIPA DO PROJETO!!");
				
			}while( ! (collaborator.equals("final") ));
			
			if(lab.addSubmission(publication)) {
				
				project.setSubmission(publication);
				
				System.out.println("Publicacao aceita!!");
				
			} else 
				System.out.println("PUBLICACAO INVALIDA!!");
		
		} else
			System.out.println("PUBLICACAO INVALIDA!!");
	}
	
	public static void consultCollaborator() {
		
		System.out.println("Nome do colaborador:");
		String name = s.next();
		
		Collaborator collaborator = lab.getCollaborator(name);
		
		if( ! (collaborator == null) ) {

			System.out.println("-> Informacoes do colaborador:");
			System.out.println("Nome: " + collaborator.getName());
			System.out.println("Email: " + collaborator.getEmail());

			System.out.println("Projetos: " + collaborator.listProjects());
			System.out.println("Producao academica: " + collaborator.listSubmissions());
			
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
			
			System.out.println("Colaboradores: " + project.listCollaborators());
			System.out.println("Procucao academica: " + project.listSubmissions());
			
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
}
import java.util.Scanner;

public class Program{
	
	static Lab lab = new Lab();
	static Scanner s = new Scanner(System.in);
	
	public static void main(String args[]) {

		int opt;
		
		do {
			
		System.out.println("Bem vindo ao " +lab.getName());
		System.out.println("Suas opcoes sao:");
		System.out.println("1)  Novo Projeto");
		System.out.println("2)  Novo Aluno da Graduacao");
		System.out.println("3)  Novo Aluno do Mestrado");
		System.out.println("4)  Novo Pesquisador");
		System.out.println("5)  Novo Professor");
		System.out.println("6)  Alocar Participante");
		System.out.println("7)  Atualizar Status do Projeto");
		System.out.println("8)  Nova Publicacao");
		System.out.println("9)  Consultar Colaborador");
		System.out.println("10) Consultar Projeto");
		System.out.println("11) Relatorio Producao Academica");
		System.out.println("0) Sair");
		System.out.print("Selecione a opcao: ");
		
		opt = s.nextInt();
		
			switch(opt) {
				case 1:
					addProject();
					break;
				case 2:
					addGradStudent();
					break;
				case 3:
					addMastersStudent();
					break;
				case 4:
					addResearcher();
					break;
				case 5:
					addTeacher();
					break;
				case 6:
					allocCollaborator();
					break;
				case 7:
					updateStatus();
					break;
				case 8:
					addPublication();
					break;
				case 9:
					seeCollaborator();
					break;
				case 10:
					seeProject();
					break;
				case 11:
					report();
					break;
				case 0:
					System.out.println("see ya!");
					break;
			}
		}while(opt != 0);
		
		s.close();
	}
	
	public static void addProject() {
		
		System.out.println("Titulo do projeto:");
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
		
		if(lab.addProject(project))
			System.out.println("Projeto adicionado!!");
		
		else
			System.out.println("Dados invalidos!!");
	}
	
	
	public static void addCollaborator(Collaborator c) {
		
		System.out.println("Nome do colaborador:");
		String name = s.next();
		
		System.out.println("Email do colaborador:");
		String email = s.next();
		
		c.setName(name);
		c.setEmail(email);		
	}
	
	public static void addGradStudent() {
		
		GraduationStudent student = new GraduationStudent();
		
		addCollaborator(student);
		
		if(lab.addCollaborator(student))
			System.out.println("Estudante de Graduacao addicionado!");
		else
			System.out.println("Ja existe colaborador com esse nome!");
	}
	
	public static void addMastersStudent() {
		
		MastersStudent student = new MastersStudent();
		
		addCollaborator(student);
		
		if(lab.addCollaborator(student))
			System.out.println("Estudante de Mestrado addicionado!");
		else
			System.out.println("Ja existe colaborador com esse nome!");
	}
	
	public static void addResearcher() {
		
		Researcher researcher = new Researcher();
		
		addCollaborator(researcher);
		
		if(lab.addCollaborator(researcher))
			System.out.println("Pesquisador addicionado!");
		else
			System.out.println("Ja existe colaborador com esse nome!");
	}
	
	public static void addTeacher() {
		
		Teacher teacher = new Teacher();
		
		addCollaborator(teacher);
		
		if(lab.addCollaborator(teacher))
			System.out.println("Professor addicionado!");
		else
			System.out.println("Ja existe colaborador com esse nome!");

	}
	
	public static void allocCollaborator() {
		
		System.out.println("Alocaremos um colaborador para algum projeto!");
		System.out.println("Colaborador:");
		String name = s.next();
		
		System.out.println("Projeto:");
		String project = s.next();
		
		if(lab.allocCollaborator(name, project))
			System.out.println("Colaborador alocado com sucesso!");
		else
			System.out.println("ALOCACAO INVALIDA!!");
	}

	public static void updateStatus() {
		
		System.out.println("Atualizar status de qual projeto?");
		String title = s.next();
		
		Project project = lab.getProject(title);
		
		if(!(project == null)) {
			
			System.out.println("Status antigo:" + project.getStatus());
			
			if(!(project.updateStatus()))
				System.out.println("O STATUS NAO PODE SER ALTERADO!!");
				
			System.out.println("Status atual:" + project.getStatus());
			
		}else
			System.out.println("PROJETO INEXISTENTE!!");
	}
	
	public static void addPublication() {
		
		System.out.println("A qual projeto pertence a publicacao?");
		String projectTitle = s.next();
		
		Project project = lab.getProject(projectTitle);
		
		if((project != null) && (project.getStatus().equals("EM ANDAMENTO"))) {

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
					c.setSubmissions(publication);
					
				} else
					System.out.println("COOLABORADOR NAO EXISTE OU NAO PARTICIPA DO PROJETO!!");
				
			}while(!( collaborator.equals("final") ));
			
			if(lab.addSubmission(publication)) {
				
				project.setSubmission(publication);
				
				System.out.println("Publicacao aceita!!");
				
			} else 
				System.out.println("PUBLICACAO INVALIDA!!");
		
		} else
			System.out.println("PUBLICACAO INVALIDA!!");
	}
	
	public static void seeCollaborator() {
		
		System.out.println("Nome do colaborador:");
		String name = s.next();
		
		Collaborator collaborator = lab.getCollaborator(name);
		
		if(!(collaborator == null)) {

			System.out.println("Informacoes do colaborador:");
			System.out.println("Nome: " + collaborator.getName());
			System.out.println("Email: " + collaborator.getEmail());

			System.out.println("Projetos: " + collaborator.listProjects());

			System.out.println("Producao academica: " 
					+ collaborator.listSubmissions());
			
		} else
			System.out.println("NOME INVALIDO!!");
	}
	
	public static void seeProject() {
		
		System.out.println("Titulo do projeto:");
		String title = s.next();
		
		Project project = lab.getProject(title);
		
		if(!(project == null)) {
			
			System.out.println("Insformacoes do projeto(" + project.getStatus() + "):");
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
		
		System.out.println("Relatorio de producao do laboratorio:");
		System.out.println("Colaboradores:" + lab.getNumCollaborators());
		System.out.println("Projetos em elaboracao:" + lab.getNumBuilding());
		System.out.println("Projetos em andamento:" + lab.getNumInProgress());
		System.out.println("Projetos concluidos:" + lab.getNumFinished());
		System.out.println("Projetos:" + lab.getNumProjects());
		System.out.println("Publicacoes/Orientacoes:" + lab.getNumSubmissions());
		
	}
	
	
	
}
public class Project {
	
	private String title;
	private Date startDate;
	private Date endDate;
	private String agency;
	private String value;
	private String goal;
	private String description;
	private String status = "EM ELABORACAO";
	private Teacher manager;
	private int numCollaborators = 0;
	private Collaborator[] collaborators;
	private int numSubmissions = 0;
	private AcademicProduction[] submissions;
	
	public Project() {
		
		collaborators = new Collaborator[25];
		submissions = new AcademicProduction[25];
	}
	
	public int getNumCollaborators() {
		return numCollaborators;
	}
	
	public int getNumSubmissions() {
		return numSubmissions;
	}
	
	public String getStatus() {
		return status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Teacher getManager() {
		return manager;
	}
	public void setManager(Teacher manager) {
		this.manager = manager;
	}
	
	public String getDate() {
		
		String date;
		
		date = Integer.toString(startDate.getMonth()) + "/" + Integer.toString(startDate.getYear());
		
		date = date + " ~ ";
		
		date = date + Integer.toString(endDate.getMonth()) + "/" + Integer.toString(endDate.getYear());
		
		return date;
	}
	
	public void setCollaborator(Collaborator collaborator) {
		collaborators[numCollaborators] = collaborator;
		numCollaborators++;
	}
	
	public Collaborator getCollaborator(String collaborator) {
		
		for(int i = 0; i < numCollaborators; i++)
			if(collaborators[i].getName().equals(collaborator))
				return collaborators[i];
		
		return null;
	}
	
	public void setSubmission(AcademicProduction submission) {
		submissions[numSubmissions] = submission;
		numSubmissions++;
	}
	
	public boolean updateStatus() {
		
		if( status.contentEquals("EM ELABORACAO") ) {
			status = "EM ANDAMENTO";
			return true;
		}
		
		if( status.contentEquals("EM ANDAMENTO") ) {
			
			if(getNumSubmissions() > 0) {
				status = "CONCLUIDO";
				return true;
			}
		}
		
		return false;
	}
	
	public String listCollaborators() {
		
		String list = "";
		
		for(int i = 0; i < numCollaborators; i++) {
			
			list = list + collaborators[i].getName() + "; ";
			
		}
		
		return list;
	}
	
	public String listSubmissions() {
		
		String list = "";
		
		for(int i = 0; i < numSubmissions; i++) {
			
			list = list + submissions[i].getTitle() + "; ";
			
		}
		
		return list;
	}
}
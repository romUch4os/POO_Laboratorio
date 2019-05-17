public class GraduationStudent extends Collaborator{
	
	private Boolean inProject = false;
	
	public Boolean getInProject() {
		return inProject;
	}

	public void setInProject() {
		this.inProject = true;
	}	
	
	public void freeStudent() {
		this.inProject = false;
	}
}
public class Date{
	
	private int month;
	private int year;
	
	public Date() {
		
		this.month = 0;
		this.year = 0;
	}
	
	public Date(int month, int year) {
		this.month = month;
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	//	verifica se a data esta num formato valido
	//	o ano ser >= 2009 eh soh uma feature(ou firula hahahah)
	//	pelo curso ter sido iniciado nesse ano
	public boolean validateDate() {
		
		if(( month >= 1 ) && ( month <= 12 )) 
			if( year >= 2009 )
			return true;
		
		return false;
	}
	
	//	verifica se this data(inicial)
	//	vem antes da data final
	public boolean validatePeriod(Date end) {
		
		if( !( this.validateDate() ))
			return false;
		
		if( !( end.validateDate() ))
			return false;
		
		int dateStart;
		int dateEnd;
		
		dateStart = this.year * 365 +
				+	this.month * 30;
		
		dateEnd = end.getYear() * 365 +
				+	end.getMonth() * 30;
		
		if( dateStart < dateEnd )
			return true;
		
		return false;
	}
	
	//	verificar se a data da publicacao
	//	estah entre data inicio -> fim
	public boolean validatePublication(Date start, Date end) {
		
		int dateThis;
		int dateStart;
		int dateEnd;
		
		dateThis = this.getYear() * 365 +
				+	this.getMonth() * 30;
		
		dateStart = start.getYear() * 365 +
				+	start.getMonth() * 30;

		dateEnd = end.getYear() * 365 +
				+	end.getMonth() * 30;
		
		if( dateThis < dateStart )
			return false;
		
		if( dateThis > dateEnd )
			return false;
		
		return true;
	}
	
}
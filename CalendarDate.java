
public class CalendarDate {
	
	private int day;
	private int month;
	private int year;
	
	public CalendarDate(int month, int day, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String toString() {
		int month = this.month;
		String monthString = null;
		
		if(this.isValidDate()) { //if the date is valid 
			// used to change number of month into its String name equivalent
			switch(month) {
			case 1:		monthString = "January";
						break;
			case 2:		monthString = "February";
						break;
			case 3:		monthString = "March";
						break;
			case 4:		monthString = "April";
						break;
			case 5:		monthString = "May";
						break;
			case 6: 	monthString = "June";
						break;
			case 7:		monthString = "July";
						break;
			case 8:		monthString = "August";
						break;
			case 9:		monthString = "September";
						break;
			case 10:	monthString = "October";
						break;
			case 11:	monthString = "November";
						break;
			case 12:	monthString = "December";
						break;
			}
			//return String "Month day, year"
			return monthString + " " + this.day + ", " + this.year;
		}
		else {
			return "Invalid date entered";
		}
	}
	
	private Boolean isValidDate() {
		Boolean isTrue = false; //initial boolean set to false
		switch(this.month) {
			//cases in which the month has 31 days
			case 1: 
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: 	if (this.day > 0 && this.day < 32) {
							isTrue = true; //change to true if date is valid
						}
						break;
					
			case 2:		if(isLeapYear()) { //feb has 29 days in leap year
							if(this.day > 0 && this.day < 30) {
								isTrue = true; //change to true is date is valid
							}
						}
						else { //feb has 28 days if not a leap year
							if(this.day > 0 && this.day < 29) {
								isTrue = true; //change to true if date is valid
							}
						}
				
			//cases in which month has 30 days			
			case 4:
			case 6:
			case 9:
			case 11:	if(this.day > 0 && this.day < 31) {
							isTrue = true; //change to true if date is valid
						}
						break;	
			}
		return isTrue;
		}
		
		
	
	
	public Boolean isLeapYear() {
		if(this.year % 100 == 0) { //year is divisible by 100
			if(this.year % 400 == 0) { //and year is divisible by 400
				return true; //is a leap year
			}
		}
		else if (this.year % 4 == 0) { //if divisible by 4 and not 100 
			return true;//is a leap year
		}
		return false;
	}
	
	public void advanceOneDay() {
		switch(this.month) {
		//cases in which the month has 31 days
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:	if(this.day < 31) {// advance one day if date is less than 31st
						this.day++;
					} 
					else { // advance month and set day to one if date was 31st
						this.month++;
						this.day = 1;
					}
					break;
				
		case 2:		if(isLeapYear()) { //leap year has 29 days
						if(this.day < 29) { //advance one day if less than 29th
							this.day++;
						}
						else { //advance month and set day to 1 if 29th
							this.month++;
							this.day = 1;
						}
					}
					else { //28 days if not leap year
						if(this.day < 28) { //advance day 1 if less than 28th
							this.day++;
						} 
						else { // advance month and set day to one if 28th
							this.month++;
							this.day = 1;
						}
					}
					break;
					
			
		//cases in which month has 30 days			
		case 4:
		case 6:
		case 9:
		case 11:	if(this.day < 30) {
						this.day++;
					}
					else {
						this.month++;
						this.day = 1;
					}
		
		//if December must change month to Jan and increment year
		case 12:	if(this.day < 31) {
						this.day++;
					}
					else {
						this.month = 1;
						this.year++;
						this.day = 1;
					}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		//if compared with itself return true
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof CalendarDate)) {
			return false;
		}
		CalendarDate o = (CalendarDate) obj;
		if(this.compareTo(o) == 0) {	
			return true;
		}
		
		return false;
	}
	
	
	public int compareTo(Object obj) {
		CalendarDate o = (CalendarDate) obj;
		if(this.year > o.getYear()) { //this is larger
			return 1;
		}
		else if(this.year < o.getYear()) { //parameter is larger
			return -1;
		}
		else if(this.month > o.getMonth()) { //this is larger
			return 1;
		}
		else if(this.month < o.getMonth()) { //parameter is larger
			return -1;
		}
		else if(this.day > o.getDay()) { //this is larger
			return 1;
		}
		else if(this.day < o.getDay()) { //parameter is larger
			return -1;
		}
		else { //dates are equal
			return 0;
		}
	}
	
}

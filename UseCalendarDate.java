
public class UseCalendarDate {

	public static void main(String[] args) {

		CalendarDate leapYear = new CalendarDate(2, 29, 2020);
		CalendarDate test = new CalendarDate(12, 30, 2019);
		CalendarDate test2 = new CalendarDate(12, 31, 2019);
		CalendarDate test3 = new CalendarDate(10, 42, 2918);
		CalendarDate test4 = new CalendarDate(0, 13, 2010);
		
		System.out.println(test.getDay());
		System.out.println(test.getMonth());
		System.out.println(test.getYear());
		
		test4.setDay(15);
		test4.setMonth(2);
		test4.setYear(10);
		
		System.out.println(test4 + " Modified 2, 15, 10");
		
		System.out.println("Should be false not leap year: " + test2.isLeapYear());
		System.out.println("Should be true is a leap year: " + leapYear.isLeapYear());
		
		test.advanceOneDay();
		System.out.println("Should be equal: " + test.equals(test2));
		
		test2.advanceOneDay();
		System.out.println("Advance one day to move to next year: " + test2);
		
		System.out.println(test3);		
		
	}

}

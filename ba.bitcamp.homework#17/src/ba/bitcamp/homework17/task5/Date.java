package ba.bitcamp.homework17.task5;

/**
 * This Class represent one date. It has attributes day, month and year. It has
 * all getters and setters, toString and equals methods, and two author created
 * methods dayPassed and monthPassed.
 * 
 * @author LAPA
 *
 */
public class Date {
	private int day;
	private int month;
	private int year;

	/**
	 * Date constructor. It uses only one attribute day. Month and year are set
	 * to 1.
	 * 
	 * @param day
	 *            - Set day
	 */
	public Date(int day) {
		this.day = day;
		this.month = 1;
		this.year = 1;
	}

	/**
	 * Date constructor. As attributes it uses day and month, year is set to
	 * one.
	 * 
	 * @param day
	 *            - Set day
	 * @param month
	 *            - Set month
	 */
	public Date(int day, int month) {
		this.day = day;
		this.month = month;
		this.year = 1;
	}

	/**
	 * Date constructor. As attributes it uses day, month and year.
	 * 
	 * @param day
	 *            - Set day
	 * @param month
	 *            - Set month
	 * @param year
	 *            - Set year
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String toString() {
		String s = "";
		if (this.day > 0 && this.day < 10) {
			s += "0" + this.day + ".";
		} else {
			s += this.day + ".";
		}
		if (this.month > 0 && this.month < 10) {
			s += "0" + this.month + ".";
		} else {
			s += this.month + ".";
		}
		if (this.year == 1) {
			s += "000" + this.year;
		} else {
			s += this.year;
		}
		return s;
	}

	/**
	 * Change day in date. Day can't be 0 or negative, and also can't be over
	 * 31. Watch out for months when changing day.
	 * 
	 * @param day
	 *            - Change day
	 */
	public void setDay(int day) {
		if (day <= 0 || day > 31) {
			System.out
					.println("Day can't be 0, negative number or higher then 31");
			throw new IllegalArgumentException();
		} else if (month == 2 || month == 4 || month == 6 || month == 9
				|| month == 11) {
			if (day > 30) {
				System.out.println("This month don't have 31 days");
				throw new IllegalArgumentException();
			}
		} else if (day > 28 && month == 2) {
			System.out.println("February have 28 days");

		} else {
			this.day = day;
		}
	}

	/**
	 * Change month in date, but be careful if day is 30 or 31.
	 * 
	 * @param month
	 *            - Change month
	 */
	public void setMonth(int month) {
		if (day > 30) {
			if (month == 2 || month == 4 || month == 6 || month == 9
					|| month == 11) {
				System.out.println("Change day to set this month");
				throw new IllegalArgumentException();
			}
		} else if (day > 28 && month == 2) {
			System.out.println("Fabruary have 28 days");
		} else {
			this.month = month;
		}
	}

	/**
	 * Change year.
	 * 
	 * @param year
	 *            - Set year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * This method prints yesterday or passed day.
	 */
	public void dayPassed() {
		if (day == 31) {
			if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10) {
				day = 1;
				month++;
			} else if (month == 12) {
				day = 1;
				month = 1;
				year++;
			}
		} else if (day == 30) {
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				day = 1;
				month++;
			}
		} else if (day == 28 && month == 2) {
			day = 1;
			month++;
		} else {
			day++;
		}
	}

	/**
	 * This method prints same date but month earlier
	 */
	public void monthPassed() {
		if (month == 12) {
			month = 1;
			year++;
		} else {
			month++;
		}
	}
}

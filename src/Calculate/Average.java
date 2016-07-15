package Calculate;

public class Average {
	static public double Count_Average (Mark[] marks) {
		double numerator = 0;
		double denominator =0;
		for(Mark mark : marks) {
			numerator+=mark.getMark();
			denominator+=mark.getValue();
		}
		return (numerator/denominator);
		
	}
}

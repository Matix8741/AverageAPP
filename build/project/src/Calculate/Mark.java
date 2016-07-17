package Calculate;

public class Mark {
	private double mark;
	private double value;
	public Mark(int mark) {
		this.setMark((double) mark);
		setValue(1);
	}
	public Mark(double mark){
		this.setMark(mark);
		setValue(1);
	}
	public Mark(double mark, double value) {
		this.setMark(mark);
		this.setValue(value);
	}
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	/**
	 * @return the mark
	 */
	public double getMark() {
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(double mark) {
		this.mark = mark;
	}
}

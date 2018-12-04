package hpbui.gamerportal.viewmodel;

public class GameAddViewModel {
	private String name;
	private int startTime;
	private int endTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
}

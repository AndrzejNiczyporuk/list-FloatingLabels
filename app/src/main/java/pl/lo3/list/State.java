package pl.lo3.list;


import java.util.Date;

/*
 * Basic Data class to hold a state land and the state city.
 */
public class State {

	private long id;
	private String land;
	private String city;
	private Integer stopNumber;
	private String stopName;
	private Integer lineNumber;
	private String lineDirection;
	private Date from;
	private Date down;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getLineDirection() {
		return lineDirection;
	}
	public void setLineDirection(String lineDirection) {
		this.lineDirection = lineDirection;
	}
	public void setLineNumberAndDirection(String stopNaN) {
		String[] RowData = stopNaN.split("-");
		this.lineNumber = Integer.parseInt(RowData[0].trim());
		this.lineDirection=RowData[1];
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getDown() {
		return down;
	}
	public void setDown(Date down) {
		this.down = down;
	}
	public String getStopName() {
		return stopName;
	}
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
	public Integer getStopNumber() {
		return stopNumber;
	}
	public void setStopNumber(Integer stopNumber) {
		this.stopNumber = stopNumber;
	}
	public void setStopNumberAndName(String stopNaN) {
		String[] RowData = stopNaN.split("-");
		this.stopNumber = Integer.parseInt(RowData[0].trim());
		this.stopName=RowData[1];
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}

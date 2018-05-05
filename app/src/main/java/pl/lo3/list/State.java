package pl.lo3.list;


import android.util.TimeUtils;

import java.util.Calendar;
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
	public Integer getLineNumber(Integer integer) {
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

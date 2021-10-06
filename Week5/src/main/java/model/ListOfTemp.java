package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Oct 5, 2021
 */
@Entity
@Table(name="temps")
public class ListOfTemp {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int temperature;
	@Column(name="FROMTO")
	private int fromTo;
	@Column(name="RESULT")
	private int result;
	
	
	public ListOfTemp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ListOfTemp(int temperature, int fromTo, int result) {
		super();
		this.temperature = temperature;
		this.fromTo = fromTo;
		this.result = result;
	}

	

	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getFromTo() {
		return fromTo;
	}
	public void setFromTo(int fromTo) {
		this.fromTo = fromTo;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	public int convertTemp() {
		if(fromTo==1) {
			result= (int)((temperature *1.8)+32);
		}else if(fromTo==2) {
			result =(int)((temperature -32)*(0.5556));
		}
		return result;
	}


	/**
	 * @return
	 */
	public char[] returnTempDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}

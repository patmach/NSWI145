package restpackage;


import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Date;



import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tender {
	private int ID;
	private String name;
	private double amount;
	
	@XmlElement(name="ID")
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	
	
	public Tender(int ID, String name, double amount) {
		this.ID=ID;
		this.name=name;
		this.amount=amount;
	}
	public Tender() {}
}
package soaphw;

public class Address {
	public String street;
	public String streetNumber;
	public String city;
	
	public Address(String street, String streetNumber, String city) {
		this.street=street;
		this.streetNumber=streetNumber;
		this.city=city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}

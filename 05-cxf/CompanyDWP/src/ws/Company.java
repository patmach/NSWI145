package ws;


import com.google.gson.Gson;

public class Company {
	
	public String name;
	public String ico;
	public Address address;
	
	public Company(String name, String ico, Address address) {
		this.name= name;
		this.ico=ico;
		this.address=address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}

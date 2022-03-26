package org.apache.juddi.example;


import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Date;

import com.google.gson.Gson;


public class Tender {
	public String name;
	public double amount;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(Date realizationDate) {
		this.realizationDate = realizationDate;
	}

	public Date realizationDate;
	
	public Tender(String name, double amount, Date realizationDate) {
		this.name=name;
		this.amount=amount;
		this.realizationDate=realizationDate;
	}
	
	@Override
	public String toString() {
		//return MessageFormat.format("<name>{0}</name>\n<amount>{1}</amount>\n<realizationDate>{2}</realizationDate>", name, amount, realizationDate);
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

package service;

import storage.Storage;
import model.Company;
import model.Participent;

public class Service {	
	//Company methods
	
	public static Company createCompany(String name, String address, int telephone) {
		Company company = new Company(name, address, telephone);
		Storage.addCompany(company);
		return company;
	}
	
	public static void updateCompany(Company company, String name, String address, int telephone) {
		company.setAddress(address);
		company.setName(name);
		company.setTelephone(telephone);
	}
	
	public static void deleteCompany(Company company) {
		Storage.removeCompany(company);
	}
	//-----------------------------------------------------------------------------------------

	//Participent methods
	
	public static Participent createParticipent(String name, String address, int telephone, String email) {
		Participent participent = new Participent(name, address, telephone, email);
		Storage.addDeltager(participent);
		return participent;
	}
}

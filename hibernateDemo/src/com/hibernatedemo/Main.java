package com.hibernatedemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
			
		//Unit of work bak buna !!
	    Session session=factory.getCurrentSession(); //Session sorgu gönderebiliyor olacağız.
	    
	    try {
	    	session.beginTransaction();
	    	//DESC --> Descending - Alçalan (Alfabetik test sıralama) Bu sayısal işlemlerde de aynı şekilde kullanılır.
	    	//ASC --> Ascending - Yükselen (Alfabetik sıralama)
	    	//HQL --> Hibernate Query Language
	    	//Select*from city
	    	//from City c where c.countryCode='TUR' AND c.district='Ankara'
	    	
//	    	List<City> cities=session.createQuery("from City c where c.countryCode='TUR' OR c.countryCode='USA'").getResultList();
	    	
//	    	List<City> cities=session.createQuery("from City c where c.countryCode='TUR' AND c.district='Ankara'").getResultList();
	    	
//	    	List<City> cities=session.createQuery("from City c where c.name LIKE '%kar%'").getResultList(); //Şehir isimlerinin içinde "kar" kelimesi geçenleri buldurma foksiyonudur.% olan tarafın ne bi önemi yok demektir.
	    	
//	    	List<City> cities=session.createQuery("from City c ORDER BY c.name DESC").getResultList(); //Şehirleri sıralamak içinde bu fonsiyonu kullanıyoruz.
	    	
//	    	List<String> countryCodes=session.createQuery("select c.countryCode from City c GROUP BY c.countryCode").getResultList();
	    	
	    	//for(City city:cities) {
	    		//System.out.println(city.getName());
	    		
			/*
			 * for(String countryCode:countryCodes) { System.out.println(countryCode); }
			 */
	    	
	    	//INSERT
//	    	City city=new City();
//	    	city.setName("Düzce 10");
//	    	city.setCountryCode("TUR");
//	    	city.setDistrict("Karadeniz");
//	    	city.setPopulation(100000);
//	    	session.save(city);
	    	
	    	//UPDATE
//	    	City city= session.get(City.class, 4086);
//	    	System.out.println(city.getName());
//	    	city.setPopulation(110000);
//	    	session.save(city);
	    	
	    	//CRUD Create Read Update Delete
	    	
	    	//DELETE
	    	City city=session.get(City.class, 4087);
	    	session.delete(city);
	    	
	    	session.getTransaction().commit(); //Otomatik bir hata olduğunda hibernate aldığından catch bloğuna burda gerek yoktur.
	    	System.out.println("Şehir silindi");
	    }finally {
	    	factory.close();
	    }
		
	}

}

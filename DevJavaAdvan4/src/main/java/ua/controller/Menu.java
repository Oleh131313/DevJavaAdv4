package ua.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;

import ua.entity.Cafe;
import ua.entity.OpenClose;
import ua.entity.Type;

public class Menu {

	Scanner sc = new Scanner(System.in);
	
	void addCafe(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Cafe cafe = new Cafe();
		System.out.println("Ведіть назву кафе ");
		String name=sc.next();
		cafe.setName(name);
		System.out.println("Ведіть адрес кафе");
		String adresCafe=sc.next();
		cafe.setAddress(adresCafe);
		System.out.println("Ведіть тип кафе(PUB, SUSHY, BAR, CAFE, RESTAURANT) ");
		String input=sc.next();
		Type type=Type.valueOf(input.toUpperCase());
		cafe.setType(type);
		System.out.println("Ведіть Email кафе ");
		String email=sc.next();
		cafe.setEmail(email);
		System.out.println("Ведіть телефон  кафе ");
		String phone=sc.next();
		cafe.setPhone(phone);
		System.out.println("Ведіть повний опис кафе ");
		String fullDescr=sc.next();
		cafe.setFullDescription(fullDescr);
		System.out.println("Ведіть короткий опис ");
		String shordDescr=sc.next();
		cafe.setShortDescription(shordDescr);
		System.out.println("Ведіть з якої години працює кафе(спочатку годину потим хвилини");
		OpenClose open=new OpenClose (LocalTime.of(sc.nextInt(), sc.nextInt()));
		em.persist(open);
		System.out.println("Ведіть до якої години працює кафе(спочатку годину потим хвилини");
		OpenClose close=new OpenClose (LocalTime.of(sc.nextInt(), sc.nextInt()));
		cafe.setClose(close);
		em.persist(close);
		
		em.persist(cafe);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void deleteCafe() {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			System.out.println("Ведіть назву кафе яке хочите удалити");
			String name=sc.next();
		List<Cafe> list = em.createQuery("SELECT c FROM Cafe c WHERE c.name=:name", Cafe.class)
				.setParameter("name", name)
				.getResultList();
		for (Cafe cafe : list) {
			if(name.equals(cafe.getName())) {
				em.remove(cafe);
			}
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}catch(NoResultException |NonUniqueResultException e) {
		System.out.println("Ви ввели кафе якого нема в списку або яких знайдено більше одного");
	}
	}
	
	public void edit() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Ведіть назву кафе яке хочите редагувати");
		String name=sc.next();
		List<Cafe> list = em.createQuery("SELECT c FROM Cafe c WHERE c.name=:name", Cafe.class)
				.setParameter("name", name)
				.getResultList();
		for (Cafe cafe : list) {
			if(name.equals(cafe.getName())) {
				System.out.println("Ведіть тип кафе(PUB, SUSHY, BAR, CAFE, RESTAURANT) ");
				String input=sc.next();
				Type type=Type.valueOf(input.toUpperCase());
				cafe.setType(type);
				
				System.out.println("Ведіть назву кафе ");
				String editName=sc.next();
				cafe.setName(editName);
				
				System.out.println("Ведіть адрес кафе");
				String adresCafe=sc.next();
				cafe.setAddress(adresCafe);
				
				System.out.println("Ведіть Email кафе ");
				String email=sc.next();
				cafe.setEmail(email);
				
				System.out.println("Ведіть телефон  кафе ");
				String phone=sc.next();
				cafe.setPhone(phone);
				
				System.out.println("Ведіть повний опис кафе ");
				String fullDescr=sc.next();
				cafe.setFullDescription(fullDescr);
				
				System.out.println("Ведіть короткий опис ");
				String shordDescr=sc.next();
				cafe.setShortDescription(shordDescr);
				
				System.out.println("Ведіть з якої години працює кафе(спочатку годину потим хвилини");
				OpenClose open=new OpenClose (LocalTime.of(sc.nextInt(), sc.nextInt()));
				cafe.setOpen(open);
				em.persist(open);
				
				System.out.println("Ведіть до якої години працює кафе(спочатку годину потим хвилини");
				OpenClose close=new OpenClose (LocalTime.of(sc.nextInt(), sc.nextInt()));
				cafe.setClose(close);
				em.persist(close);
				em.persist(cafe);
			}
			em.getTransaction().commit();
			em.close();
			factory.close();
		}
	}
}

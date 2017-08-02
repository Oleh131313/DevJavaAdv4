package ua.controller;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.Cafe;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
//		OpenClose open= new OpenClose(LocalTime.of(22, 0));
//		em.persist(open);
//		em.detach(open);
//		open.setTime(LocalTime.of(23, 0));
//		em.merge(open);
//		OpenClose openClose = em.find(OpenClose.class, 2);
//		openClose.setTime(LocalTime.of(10, 0));
//		em.remove(openClose);
//		OpenClose open = em.find(OpenClose.class, 1);
//		OpenClose close = em.find(OpenClose.class, 3);
//		Cafe cafe = new Cafe();
//		cafe.setAddress("Lviv, sg.Shevchenka 250");
//		cafe.setClose(close);
//		cafe.setEmail("dakdjhfka@dfj.df");
//		cafe.setFullDescription("Full desc");
//		cafe.setName("atlas");
//		cafe.setOpen(open);
//		cafe.setPhone("+356844874");
//		cafe.setShortDescription("Short desc");
//		cafe.setType(Type.PUB);
//		em.persist(cafe);
//		List<Cafe> list = em.createQuery("FROM Cafe c WHERE c.name=?1", Cafe.class)
//				.setParameter(1, "addada")
//				.getResultList();
//		for (Cafe cafe : list) {
//			System.out.println(cafe.getName());
//		}
		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c JOIN  c.open o WHERE o = ?1", Cafe.class)
				.setParameter(1, LocalTime.of(12, 0))
				.getResultList();
		for (Cafe cafe : cafes) {
			System.out.println(cafe.getOpen());
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
//		Menu menu = new Menu();
//		switch (menu.menu()) {
//		case 1:
//			menu.addCafe();
//			break;
//		case 2:
//			menu.deleteCafe();
//			break;
//		case 3:
//			menu.edit();
//			break;
//		}
		
		
	}

}

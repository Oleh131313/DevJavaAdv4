package ua.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.Cafe;
import ua.entity.OpenClose;
import ua.entity.Type;

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
//		cafe.setAddress("Lviv, sg.Shevchenka 25");
//		cafe.setClose(close);
//		cafe.setEmail("dakdjhfka@dfj.df");
//		cafe.setFullDescription("Full desc");
//		cafe.setName("addada");
//		cafe.setOpen(open);
//		cafe.setPhone("+356844874");
//		cafe.setShortDescription("Short desc");
//		cafe.setType(Type.CAFE);
//		em.persist(cafe);
		List<Cafe> list = em.createQuery("FROM Cafe c WHERE c.name=?1", Cafe.class)
				.setParameter(1, "addada")
				.getResultList();
		for (Cafe cafe : list) {
			System.out.println(cafe.getName());
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}

}

package ua.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.Cafe;

public class Example {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Scanner sc = new Scanner(System.in);
		
//		����� �� ������ ���� �� ������� ����
//		System.out.println("������ ����� ����:");
//		String name = sc.next();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.name=:name", Cafe.class)
//				.setParameter("name", name)
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
		
//		����� �� ������ ���� � ������� ��������
//		System.out.println("������ ����� ���� ��������:");
//		BigDecimal bottonValue = sc.nextBigDecimal();
//		System.out.println("������ ������ ���� ��������:");
//		BigDecimal topValue = sc.nextBigDecimal();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.rate "
//				+ "BETWEEN :first AND :second",Cafe.class)
//				.setParameter("first",bottonValue )
//				.setParameter("second",topValue )
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
		
//		����� �� ������ ���� �� ����������� �� ������� �����
//		System.out.println("������ �����:");
//		String value = sc.next();
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c "
//				+ "WHERE c.name LIKE :name", Cafe.class)
//				.setParameter("name", value)
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe);
//		}
//		����� �� ������ ����, ����� ������� ��� � � ���� ������� ����� ��������� :
		System.out.println("������ ������� ����:");
		BigDecimal rate = sc.nextBigDecimal();
		System.out.println("������ ��� ���� ����:");
		String name = sc.next();
		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c WHERE c.name = :name "
				+ "AND c.rate > :rate", Cafe.class)
				.setParameter("rate", rate)
				.setParameter("name", name)
				.getResultList();
		for (Cafe cafe : cafes) {
			System.out.println(cafe);
		}
		
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}

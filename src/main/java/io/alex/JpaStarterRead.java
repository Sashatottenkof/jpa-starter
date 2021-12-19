package io.alex;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        PayStub payStub = entityManager.find(PayStub.class, 5 );
//        System.out.println(payStub.getEmployee());
        Employee employee = entityManager.find(Employee.class, 1);
        System.out.println(employee.getPayStubs());
//       AccessCard card = entityManager.find(AccessCard.class, 3);
//        System.out.println(card);

        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 7);
        System.out.println("Got email group. Now accessing members");
        System.out.println(emailGroup.getMembers());
    }
}

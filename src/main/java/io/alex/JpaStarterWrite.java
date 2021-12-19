package io.alex;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class JpaStarterWrite {


    public static void main(String[] args) {


        Employee employee1 = new Employee();
        employee1.setName("Alan");
        employee1.setSsn("113");
        employee1.setAge(20);
        employee1.setDob(new Date());
        employee1.setType(EmployeeType.CONTRACTOR);


        Employee employee2 = new Employee();
        employee2.setName("Fargo");
        employee2.setSsn("114");
        employee2.setType(EmployeeType.FULL_TIME);
        employee2.setDob(new Date());
        employee2.setAge(12);

        AccessCard card1 = new AccessCard();
        card1.setIssuedDate(new Date());
        card1.setActive(true);
        card1.setFirmwareVersion("1.1.0");
        card1.setOwner(employee1);
        employee1.setCard(card1);

        AccessCard card2 = new AccessCard();
        card2.setIssuedDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");
        card2.setOwner(employee2);
        employee2.setCard(card2);

        PayStub payStub1 = new PayStub();
        payStub1.setPayPeriodStart(new Date());
        payStub1.setPayPeriodEnd(new Date());
        payStub1.setEmployee(employee1);
        payStub1.setSalary(1000);
        PayStub payStub2 = new PayStub();
        payStub2.setPayPeriodStart(new Date());
        payStub2.setPayPeriodEnd(new Date());
        payStub2.setEmployee(employee1);
        payStub2.setSalary(2000);

        employee1.setPayStubs(List.of(payStub1, payStub2));


        EmailGroup emailGroup1 = new EmailGroup();
        emailGroup1.setName("Company WaterCooler  discussions");
        emailGroup1.addMember(employee1);
        emailGroup1.addMember(employee2);
        employee1.addEmailSubscription(emailGroup1);
        employee2.addEmailSubscription(emailGroup1);

        EmailGroup emailGroup2 = new EmailGroup();
        emailGroup2.setName("Engineering");
        employee1.addEmailSubscription(emailGroup2);
        emailGroup2.addMember(employee1);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(card1);
        entityManager.persist(card2);

        entityManager.persist(payStub1);
        entityManager.persist(payStub2);

        entityManager.persist(emailGroup1);
        entityManager.persist(emailGroup2);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

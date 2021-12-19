package io.alex;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class PersistenceContextDemo {


    public static void main(String[] args) {


        Employee employee1 = new Employee();
        employee1.setName("New Employee");
        employee1.setSsn("113");
        employee1.setAge(20);
        employee1.setDob(new Date());
        employee1.setType(EmployeeType.CONTRACTOR);
        System.out.println("************************ Created employee instance");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        System.out.println("************************ Starting transaction");

        entityManager.persist(employee1);
        entityManager.flush();
        System.out.println("************************ After persist method called");

        Employee employeeFound = entityManager.find(Employee.class, 1);
        System.out.println("********************************  Found employee" + employeeFound);
        transaction.commit();
        System.out.println("************************ After persist method closed");
        entityManager.close();
        entityManagerFactory.close();
    }
}

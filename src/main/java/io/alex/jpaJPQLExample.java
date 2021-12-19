package io.alex;

import javax.persistence.*;
import java.util.List;

public class jpaJPQLExample {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        int age = 20;
//        TypedQuery<Object[]> query = entityManager.createQuery("Select e.name, e.card.issuedDate from Employee e where e.age < :minAge", Object[].class);
//        query.setParameter("minAge", age);
//        List<Object[]> resultList = query.getResultList();
//        resultList.forEach(e -> System.out.println(e[0] + " " + e[1]));
        Query query = entityManager.createNamedQuery("emp name asc", Employee.class);
        query.setParameter("minAge", age);
        List<Employee> resultList = query.getResultList();
        resultList.forEach(e -> System.out.println(e));
        entityManager.close();
        entityManagerFactory.close();
    }
}

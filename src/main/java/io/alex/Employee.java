package io.alex;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA")
@NamedQuery(query = "select e from Employee e where e.age < :minAge order by e.name", name = "emp name asc")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "employee_name")
    private String name;

    private int age;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(unique = true, nullable = false, updatable = false, length = 10)
    private String ssn;

    @Enumerated(EnumType.STRING)
    EmployeeType type;

    @Transient
    private String debugString;

    @OneToOne
    private AccessCard card;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<PayStub> payStubs;

    @ManyToMany(mappedBy = "members", fetch = FetchType.EAGER)
    private List<EmailGroup> emailGroups = new ArrayList<>();

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public String getDebugString() {
        return debugString;
    }

    public void setDebugString(String debugString) {
        this.debugString = debugString;
    }

    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }

    public List<PayStub> getPayStubs() {
        return payStubs;
    }

    public void setPayStubs(List<PayStub> payStubs) {
        this.payStubs = payStubs;
    }

    public void addEmailSubscription(EmailGroup emailGroup){
        this.emailGroups.add(emailGroup);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", ssn='" + ssn + '\'' +
                ", type=" + type +
                '}';
    }

}

package io.alex;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "email_group")
public class EmailGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String Name;

    @ManyToMany
    @JoinTable(name = "email_group_subscriptions",
    joinColumns = @JoinColumn(name="SUBSCRIPTION_EMAIL_ID"),
    inverseJoinColumns = @JoinColumn(name="EMPLOYEE_ID"))
    private List<Employee> members = new ArrayList<>();

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Employee> getMembers() {
        return members;
    }

    public void setMembers(List<Employee> members) {
        this.members = members;
    }

    public void addMember(Employee employee){
        this.members.add(employee);
    }
}

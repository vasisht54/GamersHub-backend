package jpa.server.backend.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity
public class User extends Person {

    @ManyToMany(mappedBy = "usersList")
    private List<Group> groupsList;

    public User() {
    }

    public User(String username, String password, String firstName, String lastName, Date dob) {
        super(username, password, firstName, lastName, dob);
    }

    public List<Group> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<Group> groupsList) {
        this.groupsList = groupsList;
    }
}

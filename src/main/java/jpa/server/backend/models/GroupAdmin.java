package jpa.server.backend.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class GroupAdmin extends User {

   @OneToMany(mappedBy = "groupAdmin")
    private List<GameGroup> groupsList;

    public GroupAdmin() {
    }

    public GroupAdmin(String username, String password, String firstName, String lastName, Date dob) {
        super(username, password, firstName, lastName, dob);
    }

    @Override
    public List<GameGroup> getGroupsList() {
        return groupsList;
    }

    @Override
    public void setGroupsList(List<GameGroup> groupsList) {
        this.groupsList = groupsList;
    }
}

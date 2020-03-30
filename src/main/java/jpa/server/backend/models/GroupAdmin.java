package jpa.server.backend.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class GroupAdmin extends User {

   @OneToMany(mappedBy = "groupAdmin")
    private List<Group> groupsList;
}

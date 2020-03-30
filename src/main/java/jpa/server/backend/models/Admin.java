package jpa.server.backend.models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Admin extends Person {
    private String adminKey;

    public Admin(String username, String password, String firstName, String lastName, Date dob) {
        super(username, password, firstName, lastName, dob);
    }

    public Admin() {
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }
}

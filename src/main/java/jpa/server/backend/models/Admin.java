package jpa.server.backend.models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Admin extends Person {
    private String adminKey;


    public Admin() {
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }
}

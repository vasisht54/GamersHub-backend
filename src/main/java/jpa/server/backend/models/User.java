package jpa.server.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Person {

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "usersList")
    @JsonIgnore
    private List<GameGroup> membershipGroups = new ArrayList<>();

    @OneToMany(mappedBy = "groupAdmin")
    private List<GameGroup> adminGroups;

    public User() {
    }

    public List<GameGroup> getMembershipGroups() {
        return membershipGroups;
    }

    public void setMembershipGroups(List<GameGroup> membershipGroups) {
        this.membershipGroups = membershipGroups;
    }

    public List<GameGroup> getAdminGroups() {
        return adminGroups;
    }

    public void setAdminGroups(List<GameGroup> adminGroups) {
        this.adminGroups = adminGroups;
    }

    @Override
    public String toString() {
        return "User{" +
                "membershipGroups=" + membershipGroups +
                ", adminGroups=" + adminGroups +
                "} " + super.toString();
    }
}

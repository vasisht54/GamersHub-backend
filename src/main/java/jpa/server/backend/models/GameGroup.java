package jpa.server.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class GameGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "groupsList")
    private List<User> usersList;
    @ManyToOne
    @JsonIgnore
    private GroupAdmin groupAdmin;
    @ManyToOne
    @JsonIgnore
    private Game game;

    public GameGroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public GroupAdmin getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(GroupAdmin groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

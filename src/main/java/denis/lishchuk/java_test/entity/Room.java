package denis.lishchuk.java_test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "room")
    private List<Point> room = new ArrayList<>();

    public Room(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Point> getRoom() {
        return room;
    }

    public void setRoom(List<Point> room) {
        this.room = room;
    }


}

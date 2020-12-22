package denis.lishchuk.java_test.dto.response;

import denis.lishchuk.java_test.entity.Point;
import denis.lishchuk.java_test.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomResponse {

    private List<Point> room = new ArrayList<>();

    public RoomResponse(Room r){
        room = r.getRoom();
    }

    public List<Point> getRoom() {
        return room;
    }

    public void setRoom(List<Point> room) {
        this.room = room;
    }
}

package denis.lishchuk.java_test.dto.request;

import denis.lishchuk.java_test.entity.Point;
import denis.lishchuk.java_test.validators.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RoomRequest {
    @NotEmpty
    @NotNull
    @PointsAreInteger(groups = FirstGroup.class)
    @AtLeastFourPointsArePresent(groups = FirstGroup.class)
    @FiniteRoom(groups = SecondGroup.class)
    @NoDiagonalWalls(groups = SecondGroup.class)
    @WallsDoNotIntersect(groups = SecondGroup.class)
    private List<Point> room = new ArrayList<>();

    public List<Point> getPoints() {
        return room;
    }

    public void setRoom(List<Point> room) {
        this.room = room;
    }
}

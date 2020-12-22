package denis.lishchuk.java_test.service;

import denis.lishchuk.java_test.dto.request.RoomRequest;
import denis.lishchuk.java_test.dto.response.RoomResponse;
import denis.lishchuk.java_test.entity.Point;
import denis.lishchuk.java_test.entity.Room;
import denis.lishchuk.java_test.exception.InputDataException;
import denis.lishchuk.java_test.repository.PointRepository;
import denis.lishchuk.java_test.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PointRepository pointRepository;

    public Room roomRequestToRoom(Room r) {
        if (r == null)
            r = new Room();
        return r;
    }

    public RoomResponse save(RoomRequest roomRequest) {
        Room r = roomRepository.save(roomRequestToRoom(null));
        pointsFill(roomRequest, r);
        return new RoomResponse(roomRepository.save(roomRequestToRoom(r)));
    }

    public RoomResponse update(RoomRequest roomRequest, Long id) throws InputDataException {
        Room r = findOneRoom(id);
        pointsDelete(id);
        pointsFill(roomRequest, r);
        return new RoomResponse(roomRepository.save(roomRequestToRoom(r)));
    }

    public void delete(Long id) throws InputDataException{
        pointsDelete(id);
        roomRepository.delete(findOneRoom(id));
    }

    public void pointsFill(RoomRequest roomRequest, Room r) throws InputDataException {
        List<Point> room = roomRequest.getPoints();
        for (Point p: room) {
            p.setRoom(r);
            pointRepository.save(p);
        }
        r.setRoom(room);
    }
    public void pointsDelete(Long roomId)throws InputDataException{
        for (Point p: findOneRoom(roomId).getRoom()) {
            pointRepository.delete(p);
        }
    }

    public List<RoomResponse> findAll(){
        return roomRepository.findAll().stream().map(RoomResponse::new).collect(Collectors.toList());
    }

    public Room findOneRoom(Long id)throws InputDataException {
        return roomRepository.findById(id).orElseThrow(() -> new InputDataException("Room with id " + id + " not exists"));
    }

    public Point findOnePoint(Long id)throws InputDataException {
        return pointRepository.findById(id).orElseThrow(() -> new InputDataException("Point with id " + id + " not exists"));
    }
}

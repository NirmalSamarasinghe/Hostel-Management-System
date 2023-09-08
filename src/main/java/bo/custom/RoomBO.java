package bo.custom;

import bo.SuperBo;
import dto.RoomDTO;
import dto.StudentDTO;

import java.util.List;

public interface RoomBO extends SuperBo {

    boolean saveRoom(RoomDTO roomDTO);

    List<StudentDTO> getAllRoom();

    boolean updateRoom(StudentDTO studentDTO);

    boolean deleteRoom(String studentId);

    List<RoomDTO> getAllRooms();
}

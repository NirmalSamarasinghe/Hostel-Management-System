package bo.custom.impl;

import bo.custom.RoomBO;
import dto.RoomDTO;
import dto.StudentDTO;

import java.util.List;

public class RoomBoImpl implements RoomBO {
    @Override
    public boolean saveRoom(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public List<StudentDTO> getAllRoom() {
        return null;
    }

    @Override
    public boolean updateRoom(StudentDTO studentDTO) {
        return false;
    }

    @Override
    public boolean deleteRoom(String studentId) {
        return false;
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return null;
    }
}

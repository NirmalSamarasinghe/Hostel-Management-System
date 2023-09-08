package bo.custom;


import bo.SuperBo;
import dto.StudentDTO;
import entity.Student;

import java.util.List;

public interface StudentBO extends SuperBo {
    boolean saveStudent(StudentDTO studentDto);

    List<StudentDTO> getAllStudent();

    boolean updateStudent(StudentDTO studentDTO);

    boolean deleteStudent(String studentId);

}
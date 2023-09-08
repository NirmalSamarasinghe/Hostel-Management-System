package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public boolean saveStudent(StudentDTO studentDto) {
        return studentDAO.save(new Student(studentDto.getStudent_id(), studentDto.getName(), studentDto.getAddress(), studentDto.getContact_no(), studentDto.getDate(),studentDto.getGender()));
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<StudentDTO> customerDTOArrayList = new ArrayList<>();
        List<Student> customerArrayList = studentDAO.getAll();
        for (Student student:customerArrayList) {
            customerDTOArrayList.add(new StudentDTO(student.getStudent_id(),student.getName(), student.getAddress(), student.getContact_no(),student.getDate(),student.getGender()));
        }
        return customerDTOArrayList;
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        return studentDAO.update(new Student(studentDTO.getStudent_id(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContact_no(), studentDTO.getDate(),  studentDTO.getGender()));
    }

    @Override
    public boolean deleteStudent(String studentId) {
        Student student = new Student();
        student.setStudent_id(studentId);
        return studentDAO.delete(student);
    }
}
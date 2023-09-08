package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tm.StudentTM;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AddStudentFormController implements Initializable {

    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXTextField txtStudentId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private DatePicker txtDob;

    @FXML
    private JFXRadioButton rBtnMale;

    @FXML
    private JFXRadioButton rBtnFemale;

    @FXML
    private TableColumn<?, ?> colStudentId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDoB;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<StudentTM> studentTbl;


    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    @FXML
    void btnAddOnAction(ActionEvent event) {
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudent_id(txtStudentId.getText());
        studentDTO.setName(txtName.getText());
        studentDTO.setAddress(txtAddress.getText());
        studentDTO.setContact_no(txtContact.getText());
        studentDTO.setDate(Date.valueOf(txtDob.getValue()));
        studentDTO.setGender((rBtnMale.isSelected()) ? "Male" : "Female");

        boolean isSaved = studentBO.saveStudent(studentDTO);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Student saved!...").show();
            getAll();
        }else {
            new Alert(Alert.AlertType.ERROR, "Student not saved!...").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        StudentTM selectedItem = studentTbl.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            boolean isDeleted = studentBO.deleteStudent(selectedItem.getStudent_id());
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student deleted!...").show();
                getAll();
            } else {
                new Alert(Alert.AlertType.ERROR, "Student not deleted   !...").show();
            }

        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudent_id(txtStudentId.getText());
        studentDTO.setName(txtName.getText());
        studentDTO.setAddress(txtAddress.getText());
        studentDTO.setContact_no(txtContact.getText());
        studentDTO.setDate(Date.valueOf(txtDob.getValue()));
        studentDTO.setGender((rBtnMale.isSelected()) ? "Male":"Female");

        boolean isUpdated = studentBO.updateStudent(studentDTO);
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student updated!...").show();
            getAll();
        } else {
            new Alert(Alert.AlertType.ERROR, "Student not updated!...").show();
        }

    }

    private void getAll() {
        ObservableList<StudentTM> observableList = FXCollections.observableArrayList();
        List<StudentDTO> customerDTOList = studentBO.getAllStudent();
        for (StudentDTO studentDTO : customerDTOList) {
            observableList.add(new StudentTM(
                            studentDTO.getStudent_id(),
                            studentDTO.getName(),
                            studentDTO.getAddress(),
                            studentDTO.getContact_no(),
                            studentDTO.getDate(),
                            studentDTO.getGender()
                    )
            );
        }
        studentTbl.setItems(observableList);
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setCellValueFactory();

    }

    @FXML
    void studentTblOnMouseClicked(MouseEvent event) {
        StudentTM selectedItem = (StudentTM) studentTbl.getSelectionModel().getSelectedItem();
        try {
            if (selectedItem != null) {
                deleteBtn.setDisable(false);
                txtStudentId.setText(selectedItem.getStudent_id());
                txtName.setText(selectedItem.getName());
                txtAddress.setText(selectedItem.getAddress());
                if (selectedItem.getGender().equals("Male")) {
                    rBtnMale.setSelected(true);
                } else {
                    rBtnFemale.setSelected(true);
                }
                txtContact.setText(selectedItem.getContact_no());
                txtDob.setValue(selectedItem.getDob().toLocalDate());
            } else {
                saveBtn.setDisable(true);
            }
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    private void setCellValueFactory() {

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colDoB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }
}

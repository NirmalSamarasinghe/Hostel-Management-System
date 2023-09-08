package controller;

import bo.BOFactory;
import bo.custom.RoomBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tm.RoomTM;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtRoomId;

    @FXML
    private JFXTextField txtKeyMoney;

    @FXML
    private JFXComboBox<?> combType;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colKeyMoney;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableView<RoomTM> roomTble;
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    @FXML
    void btnAddOnAction(ActionEvent event) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoom_type_id(txtRoomId.getText());
        roomDTO.setKey_money(Double.valueOf(txtKeyMoney.getText()));
        roomDTO.setType(txtQty.getText());
        roomDTO.setQty(Integer.valueOf(txtQty.getText()));

        boolean isSaved = roomBO.saveRoom(roomDTO);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Student saved!...").show();
            getAll();
        }else {
            new Alert(Alert.AlertType.ERROR, "Student not saved!...").show();
        }

    }

    private void getAll() {
        ObservableList<RoomTM> observableList = FXCollections.observableArrayList();
        List<RoomDTO> roomDTOList = roomBO.getAllRooms();
        for (RoomDTO roomDTO : roomDTOList) {
            observableList.add(new RoomTM(
                            roomDTO.getRoom_type_id(),
                            roomDTO.getType(),
                            roomDTO.getKey_money(),
                            roomDTO.getQty()
                    )
            );
        }
        roomTble.setItems(observableList);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        RoomTM selectedItem = roomTble.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            boolean isDeleted = roomBO.deleteRoom(selectedItem.getRoomId());
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room deleted!...").show();
                getAll();
            } else {
                new Alert(Alert.AlertType.ERROR, "Room not deleted   !...").show();
            }
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

package bo.custom;

import bo.SuperBo;
import dto.UserDTO;

public interface UserBO extends SuperBo {
    boolean checkUser(String userName, String password, String password1);

    String generatenextUserId();

    boolean saveUser(UserDTO user);
}
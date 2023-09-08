package bo.custom.impl;

import bo.custom.UserBO;
import dto.UserDTO;

public class UserBOImpl implements UserBO {

    @Override
    public boolean checkUser(String userName, String password, String password1) {
        return false;
    }

    @Override
    public String generatenextUserId() {
        return null;
    }

    @Override
    public boolean saveUser(UserDTO user) {
        return false;
    }
}

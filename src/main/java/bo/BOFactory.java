package bo;

import bo.custom.impl.RoomBoImpl;
import bo.custom.impl.StudentBOImpl;
import bo.custom.impl.UserBOImpl;
//import bo.custom.impl.UserBoImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER,STUDENT,ROOM
    }

    public SuperBo getBO(BOTypes boTypes){
        switch (boTypes){
            case USER:
                return new UserBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBoImpl();
            default:
                return null;
        }
    }
}
package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Room {
    @Id
    private String room_type_id;
    private Double key_money;
    private Integer qty;
    private String type;
    @ToString.Exclude
    @OneToMany(mappedBy = "room", targetEntity = Reservation.class)
    List<Reservation> reservationList = new ArrayList<>();
}
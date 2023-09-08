package tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RoomTM {
    private String roomId;
    private String type;
    private Double keyMoney;
    private Integer qty;
}

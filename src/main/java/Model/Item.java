package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Item {
    private String code;
    private String description;
    private Double unitPrice;
    private String qtyOnHand;

}

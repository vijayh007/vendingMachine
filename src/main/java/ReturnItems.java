import lombok.Data;

import java.util.List;

/**
 * Created by vijay.hathimare on 4/29/19.
 *
 */
@Data
public class ReturnItems {
    private Product product;
    private List<Integer> changes;
}

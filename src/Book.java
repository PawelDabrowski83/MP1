import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Book as a unique record, not real item.
 */
public class Book {

    private static int idCounter = 0;
    private int id;
    private String title;
    private Person authors[];
    private Person borrower;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public BigDecimal checkPenalty() {
        return BigDecimal.ZERO;
    }
}

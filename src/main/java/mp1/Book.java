package mp1;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;


public class Book extends ObjectPlus {

    private static int idCounter = 0;
    private int id;
    private String title;
    private Person[] authors;
    private Person borrower;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    public BigDecimal checkPenalty() throws IllegalStateException {
        if (returnDate == null) {
            returnDate = LocalDateTime.now();
        }
        if (borrowDate == null) {
            throw new IllegalStateException("This book is not borrowed.");
        }
        long daysCount = DAYS.between(borrowDate, returnDate);
        return BigDecimal.valueOf(daysCount * 3.1415).setScale(2, RoundingMode.CEILING);
    }

    public Book(String title, Person[] authors) {
        this.id = idCounter++;
        this.title = title;
        this.authors = authors;
    }

    public Book(String title, Person[] authors, Person borrower, LocalDateTime borrowDate, LocalDateTime returnDate) {
        this.id = idCounter++;
        this.title = title;
        this.authors = authors;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        String authorsToString = Stream.of(authors).map(Person::toOrdinaryList).collect(Collectors.joining(", "));
        if (borrower == null) {
            return String.format("Book{ id %d: \"%s\" %s}", id, title, authorsToString);
        }
        return String.format("Book{ id %d: \"%s\", %s, borrower=%s, borrowDate=%s, returnDate=%s }",
                id, title, authorsToString,
                borrower.toOrdinaryList(),
                borrowDate == null ? "n/a" : borrowDate.toString(),
                returnDate == null ? "n/a" : returnDate.toString());
    }
}

package mp2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class ProductionHistory {
    private static int counter = 0;
    protected static final Set<ProductionHistory> allProductionHistory = new HashSet<>();
    private int id;
    private Medicine medicine;
    private Manufacturer manufacturer;
    private LocalDate startDate;
    private LocalDate endDate;

    public ProductionHistory(Medicine medicine, Manufacturer manufacturer, LocalDate startDate, LocalDate endDate) {
        this.id = counter++;
        this.medicine = medicine;
        this.manufacturer = manufacturer;
        this.startDate = startDate;
        this.endDate = endDate;
        allProductionHistory.add(this);
        medicine.addProductionHistory(this);
        manufacturer.addProductionHistory(this);
    }

    public ProductionHistory(Medicine medicine, Manufacturer manufacturer, LocalDate startDate) {
        new ProductionHistory(medicine, manufacturer, startDate, null);
    }

    public int getId() {
        return id;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void remove() {
        allProductionHistory.remove(this);
        manufacturer.remove(this);
        medicine.remove(this);
    }
}

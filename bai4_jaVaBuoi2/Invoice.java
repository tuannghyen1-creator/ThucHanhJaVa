public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    // Constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        
        // Nếu số lượng không dương, đặt thành 0
        this.quantity = (quantity > 0) ? quantity : 0;
        
        // Nếu giá không dương, đặt thành 0.0
        this.pricePerItem = (pricePerItem > 0.0) ? pricePerItem : 0.0;
    }

    // Getter và Setter cho partNumber
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    // Getter và Setter cho partDescription
    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    // Getter và Setter cho quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = (quantity > 0) ? quantity : 0;
    }

    // Getter và Setter cho pricePerItem
    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = (pricePerItem > 0.0) ? pricePerItem : 0.0;
    }

    // Phương thức tính tổng số tiền hóa đơn
    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }

    // Hiển thị thông tin hóa đơn một cách gọn gàng
    @Override
    public String toString() {
        return String.format("Mã hàng: %-10s | Mô tả: %-20s | Số lượng: %-5d | Đơn giá: %-10.2f | Tổng tiền: %-10.2f", 
                partNumber, partDescription, quantity, pricePerItem, getInvoiceAmount());
    }
}

/**
 * @ File chứa thông tin sản phẩm
 * @author : Nguyễn Thành Nhân
 * @version : 1.0
 * @created : 16-Sep-2025 12:30:36 PM
 */
import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    private String productID;
    private String description;
    private double price;

    public Product() {
    }

    public Product(String productID, String description, double price) {
        setProductID(productID);
        setDescription(description);
        setPrice(price);
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        if (productID == null || productID.isEmpty()) {
            throw new IllegalArgumentException("ID sản phẩm không được để trống");
        }
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description không được để trống");
        }
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0.0) {
            throw new IllegalArgumentException("Giá phải lớn hơn 0");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("vi-VN"));
        return String.format("%s - %s (Đơn giá: %s)", productID, description, nf.format(price) + " VND");
    }
}

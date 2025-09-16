
/**
 * @ File chứa detailOrder của sản phẩm
 * @author : Nguyễn Thành Nhân
 * @version : 1.0
 * @created : 16-Sep-2025 12:42:12 PM
 */
import java.text.NumberFormat;
import java.util.Locale;

public class OrderDetail {
    private int quantity;
    private Product product;

    public OrderDetail(int quantity, Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product không được null");
        }
        this.product = product;
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity phải lớn hơn 0");
        }
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double calcTotalPrice() {
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("vi-VN"));
        return String.format("%-6s | %-15s | %10s | %7d | %12s", 
                product.getProductID(), product.getDescription(), 
                nf.format(product.getPrice()), quantity, 
                nf.format(calcTotalPrice()) + " VND");
    }
}



import java.sql.Date;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class Order {
    private int orderID;
    private Date orderDate;
    private OrderDetail[] lineItems;
    private int count = 0;
    
    public Order(int orderID, java.util.Date orderDate) {
        if (orderID <= 0) {
            throw new IllegalArgumentException("OrderID phải lớn hơn 0");
        }
        this.orderID = orderID;
        setOrderDate(orderDate != null ? new java.sql.Date(orderDate.getTime()) : null);
        lineItems = new OrderDetail[10]; 
    }
    
    public Order(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Kích thước phải lớn hơn 0");
        }
        lineItems = new OrderDetail[size];
    }

    public int getOrderID() {
        return orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        if (orderDate == null) {
            throw new IllegalArgumentException("Không được để trống order date");
        }
        this.orderDate = orderDate;
    }
    
    public void addLineItem(Product p, int q) {
        if (p == null) {
            throw new IllegalArgumentException("Product không được null");
        }
        if (q <= 0) {
            throw new IllegalArgumentException("Quantity phải lớn hơn 0");
        }
        for (int i = 0; i < count; i++) {
            if (lineItems[i].getProduct().getProductID().equals(p.getProductID())) {
                lineItems[i].setQuantity(lineItems[i].getQuantity() + q);
                return;
            }
        }
        if (count == lineItems.length) {
            lineItems = Arrays.copyOf(lineItems, lineItems.length * 2);
        }
        lineItems[count++] = new OrderDetail(q, p);
    }
    
    public double calcTotalCharge() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += lineItems[i].calcTotalPrice();
        }
        return total;
    }
    


    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("vi-VN"));
        StringBuilder sb = new StringBuilder();

        sb.append("Mã HD: ").append(orderID).append("\n");
        sb.append("Ngày lập hóa đơn: ")
          .append(String.format("%1$td/%1$tm/%1$tY", orderDate))
          .append("\n");

        sb.append(String.format("%-4s | %-6s | %-15s | %-10s | %-7s | %-12s\n",
                "STT", "Mã SP", "Mô tả", "Đơn giá", "SL", "Thành tiền"));
        sb.append("---------------------------------------------------------------------\n");

        for (int i = 0; i < count; i++) {
            sb.append(String.format("%-4d | %s\n", i + 1, lineItems[i].toString()));
        }

        sb.append("---------------------------------------------------------------------\n");
        sb.append("Tổng tiền thanh toán: ")
          .append(nf.format(calcTotalCharge()))
          .append(" VND\n");

        return sb.toString();
    }
}


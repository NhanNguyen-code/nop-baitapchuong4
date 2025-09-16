
/**
 * @ File kiểm thử
 * @author : Nguyễn Thành Nhân
 * @version : 1.0
 * @created : 16-Sep-2025 1:15:13 PM
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("sp1", "Gạo", 18000);
        Product p2 = new Product("sp2", "Nước mắm", 15000);

        Order order = new Order(1, new GregorianCalendar(2025, Calendar.SEPTEMBER, 16).getTime());

        order.addLineItem(p1, 5);
        order.addLineItem(p2, 3);
        order.addLineItem(p1, 2);  
        order.addLineItem(p2, 10); 
        order.addLineItem(new Product("sp3", "Muối", 5000), 20);
        order.addLineItem(new Product("sp4", "Đường", 10000), 1); 

        System.out.println(order);
    }
}

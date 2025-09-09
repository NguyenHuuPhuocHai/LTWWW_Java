package iuh.edu.se.baitap04.Model;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    public static final List<Product> ds = new ArrayList<Product>();
    static {
        initData();
    }

    public static List<Product> queryProducts() {
        return ds;
    }

    private static void initData() {
        Product sp = new Product();
        sp.setId("PR001");          sp.setModel("Nokia Lumia");
        sp.setDescription("");      sp.setQuantity(10);
        sp.setPrice(99000);         sp.setImgURL("/images/dt1.jpg");
        ds.add(sp);

        sp = new Product();
        sp.setId("PR002");          sp.setModel("Nokia Lumia");
        sp.setDescription("");      sp.setQuantity(10);
        sp.setPrice(99000);        sp.setImgURL("/images/dt2.jpg");
        ds.add(sp);

        sp = new Product();
        sp.setId("PR003");          sp.setModel("Nokia Lumia");
        sp.setDescription("");      sp.setQuantity(10);
        sp.setPrice(99000);        sp.setImgURL("/images/dt3.jpg");
        ds.add(sp);

        sp = new Product();
        sp.setId("PR004");          sp.setModel("Nokia Lumia");
        sp.setDescription("");      sp.setQuantity(10);
        sp.setPrice(99000);        sp.setImgURL("/images/dt4.jpg");
        ds.add(sp);

        sp = new Product();
        sp.setId("PR005");          sp.setModel("Nokia Lumia");
        sp.setDescription("");      sp.setQuantity(10);
        sp.setPrice(99000);        sp.setImgURL("/images/dt5.jpg");
        ds.add(sp);
    }
}

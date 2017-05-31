package org.itstep.pps2701.dk_orders.dao;

import android.content.ContentValues;
import android.content.Context;
import org.itstep.pps2701.dk_orders.Utils.DataBaseManager;
import org.itstep.pps2701.dk_orders.entity.Product;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by DK-HOME on 31.05.2017.
 */
public class ProductRepository extends DataBaseManager {

    public ProductRepository(Context context) {
        super(context);
    }

    public long save(Product product) {
        ContentValues values = new ContentValues();
        values.put("name", product.getName());
        values.put("description", product.getDescription());
        values.put("price", product.getPrice());

        return database.insert("Products", null, values);
    }

}

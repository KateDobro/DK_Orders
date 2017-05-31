package org.itstep.pps2701.dk_orders.dao;

import android.content.ContentValues;
import android.content.Context;
import org.itstep.pps2701.dk_orders.Utils.DataBaseManager;
import org.itstep.pps2701.dk_orders.entity.Order;

/**
 * Created by DK-HOME on 31.05.2017.
 */
public class OrderRepository extends DataBaseManager{

    public OrderRepository(Context context) {
        super(context);
    }

    public long save(Order order) {
        ContentValues values = new ContentValues();
        values.put("order_date", String.valueOf(order.getOrderDate()));

        return database.insert("Orders", null, values);
    }

    // todo - чтение, редактирование, удаление
}

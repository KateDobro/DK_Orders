package org.itstep.pps2701.dk_orders.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DK-HOME on 30.05.2017.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "orderdb";
    private static final int DATABASE_VERSION = 1;

    private static DataBaseHelper instance;

    public static synchronized DataBaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DataBaseHelper(context);
        return instance;
    }

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // таблица товаров
        db.execSQL("create table Products (" +
                        "_id integer primary key autoincrement, " +
                        "name text, " +
                        "description text, " +
                        "price double);"
        );

        // таблица продуктов
        db.execSQL("create table Orders (" +
                "_id integer primary key autoincrement, " +
                "order_date timestamp(6));"
        );

        // таблица связи товаров с заказами
        db.execSQL("create table OrderProduct (" +
                "_id integer primary key autoincrement, " +
                "order_id integer, " +
                "goods_id integer, " +
                "quantity integer);"
        );

        // начальные данные для таблицы товаров
        ContentValues cv = new ContentValues();
        String[] names = {"HDD", "SSD", "USB FlashDrive"};
        String[] descs = {"Hard Disk Drive", "Solid-State Drive", "Data storage device that includes flash memory"};
        double[] prices = {2530.99, 4653.76, 345.67};
        for (int i = 0; i < names.length; i++) {
            cv.put("name", names[i]);
            cv.put("description", descs[i]);
            cv.put("price", prices[i]);
            db.insert("Products", null, cv);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

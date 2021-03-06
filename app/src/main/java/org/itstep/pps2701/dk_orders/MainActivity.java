package org.itstep.pps2701.dk_orders;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import org.itstep.pps2701.dk_orders.Utils.DataBaseHelper;
import org.itstep.pps2701.dk_orders.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    SQLiteDatabase db;
    DataBaseHelper helper;
    Cursor userCursor;
    int prodId = 0;

    Button btnAddProduct;
    Button btnEditProduct;
    ListView productListView;

    private static final String LOG_TAG = "SQLiteOrders";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddProduct = (Button) findViewById(R.id.btnAddProduct);
        btnEditProduct = (Button) findViewById(R.id.btnEditProduct);
        productListView = (ListView) findViewById(R.id.listProduct);

        helper = new DataBaseHelper(this);
        fillProductList();
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {

            case R.id.btnAddProduct:
                intent = new Intent(this, ProductDialog.class);
                startActivityForResult(intent, REQUEST_PRODUCT);
                break;
                break;
            case R.id.btnEditProduct:
                // todo
                break;
        }
    }


    private void fillProductList(){
        db = helper.getReadableDatabase();
        userCursor = db.rawQuery("SELECT * FROM Products", null);

        if (userCursor.moveToFirst()) {
            List<Product> prodList = new ArrayList<>();
            int idIndex = userCursor.getColumnIndex("_id");
            int nameIndex = userCursor.getColumnIndex("name");
            int descIndex = userCursor.getColumnIndex("description");
            int priceIndex = userCursor.getColumnIndex("price");
            do {
                prodList.add(new Product(
                        userCursor.getInt(idIndex),
                        userCursor.getString(nameIndex),
                        userCursor.getString(descIndex),
                        userCursor.getDouble(priceIndex)));
            } while (userCursor.moveToNext());

            ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this,
                    android.R.layout.simple_list_item_1, prodList);
            productListView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Строк в таблице: 0", Toast.LENGTH_LONG).show();
        } // if
    }


    private void addProductDialog(){

    }

    private void addProduct(Product prod){
        ContentValues cv = new ContentValues();
        cv.put("name", prod.getName());
        cv.put("description", prod.getDescription());
        cv.put("price", prod.getPrice());
        db.insert("Products", null, cv);
        this.recreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        fillProductList();
    }

}

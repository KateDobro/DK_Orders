package org.itstep.pps2701.dk_orders.entity;

import android.os.Parcel;
import android.os.Parcelable;


public class OrderProduct implements Parcelable {

    private int id;
    private int orderId;
    private int productId;
    private int quantity;

    public OrderProduct() {
        super();
    }

    public OrderProduct(int orderId, int productId, int quantity) {
        super();
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    protected OrderProduct(Parcel in) {
        id = in.readInt();
        orderId = in.readInt();
        productId = in.readInt();
        quantity = in.readInt();
    }

    public static final Creator<OrderProduct> CREATOR = new Creator<OrderProduct>() {
        @Override
        public OrderProduct createFromParcel(Parcel in) {
            return new OrderProduct(in);
        }

        @Override
        public OrderProduct[] newArray(int size) {
            return new OrderProduct[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(orderId);
        dest.writeLong(productId);
        dest.writeInt(quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

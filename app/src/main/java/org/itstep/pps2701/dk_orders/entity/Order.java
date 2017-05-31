package org.itstep.pps2701.dk_orders.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

/**
 * Created by DK-HOME on 30.05.2017.
 */
public class Order implements Parcelable{

    private Integer id;                             // ид он же номер заказа
    private Date orderDate;                         // дата заказа
    private List<OrderProduct> orderProductList;

    public Order() {
        super();
    }

    private Order(Parcel in) {
        super();
        this.id = in.readInt();
        this.orderDate = new Date(in.readLong());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(getId());
        parcel.writeLong(orderDate.getTime());
    }

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        public Order[] newArray(int size) {
            return new Order[size];
        }
    };


    public void addToOrderProductList(Product prod, int quantity){
        orderProductList.add(new OrderProduct(id, prod.getId(), quantity));
    }

    public void addToPurchaseList(OrderProduct item){
        orderProductList.add(item);
    }

    public void removeFromOrderProductList(Product prod){
        for(OrderProduct orderProduct : orderProductList) {
            if(orderProduct.getProductId() == prod.getId()){
                orderProductList.remove(orderProduct);
            }
        }
    }

    public void removeFromOrderProductList(OrderProduct item){
        orderProductList.remove(item);
    } // removeFromPurchaseList

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProduct> orderProductList) {
        this.orderProductList = orderProductList;
    }
}

package org.itstep.pps2701.dk_orders.entity;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DK-HOME on 29.05.2017.
 */
public class Product implements Parcelable {

    private int id;
    private String name;
    private String description;
    private double price;

    public Product() {
        super();
    }

    private Product(Parcel in) {
        super();
        this.id = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.price = in.readDouble();
    }

    @Override
    public String toString() {
        return name + " (" + description + "): " + price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(getId());
        parcel.writeString(getName());
        parcel.writeString(getDescription());
        parcel.writeDouble(getPrice());
    }


    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

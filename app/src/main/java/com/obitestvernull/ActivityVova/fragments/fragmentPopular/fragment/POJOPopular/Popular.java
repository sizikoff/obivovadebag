package com.obitestvernull.ActivityVova.fragments.fragmentPopular.fragment.POJOPopular;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Popular {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("obi_id")
    @Expose
    private String obiId;
    @SerializedName("store_id")
    @Expose
    private int storeId;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("quantity")
    @Expose
    private int quantity;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("price_m2")
    @Expose
    private String priceM2;
    @SerializedName("old_price")
    @Expose
    private String oldPrice;
    @SerializedName("category_id")
    @Expose
    private int categoryId;
    @SerializedName("existing")
    @Expose
    private int existing;
    @SerializedName("pickup")
    @Expose
    private int pickup;
    @SerializedName("delivery")
    @Expose
    private int delivery;
    @SerializedName("is_new")
    @Expose
    private int isNew;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("existing_in_stores")
    @Expose
    private List<Integer> existingInStores = null;
    @SerializedName("boards")
    @Expose
    private List<Object> boards = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObiId() {
        return obiId;
    }

    public void setObiId(String obiId) {
        this.obiId = obiId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceM2() {
        return priceM2;
    }

    public void setPriceM2(String priceM2) {
        this.priceM2 = priceM2;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getExisting() {
        return existing;
    }

    public void setExisting(int existing) {
        this.existing = existing;
    }

    public int getPickup() {
        return pickup;
    }

    public void setPickup(int pickup) {
        this.pickup = pickup;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Integer> getExistingInStores() {
        return existingInStores;
    }

    public void setExistingInStores(List<Integer> existingInStores) {
        this.existingInStores = existingInStores;
    }

    public List<Object> getBoards() {
        return boards;
    }

    public void setBoards(List<Object> boards) {
        this.boards = boards;
    }
}

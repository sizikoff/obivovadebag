package com.obitestvernull.fourthModuleFindProducts.ActivityFour.fragments.fragmentOneActFourth.POJOActFourFragOne;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindingProducts {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}


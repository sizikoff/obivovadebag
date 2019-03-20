package com.obitestvernull.commonClassesAndUtils.POJO;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Ignore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CitiesWithStores {

        @SerializedName("data")
        @Expose

        public Data data;

        public CitiesWithStores(Data data) {
                this.data = data;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
                this.data = data;
        }
}

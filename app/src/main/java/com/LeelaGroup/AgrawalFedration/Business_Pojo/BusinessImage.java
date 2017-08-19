package com.LeelaGroup.AgrawalFedration.Business_Pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by USer on 13-07-2017.
 */

public class BusinessImage {

    @SerializedName("cat_id")
    String cat_id;

    @SerializedName("cat_name")
    String cat_name;

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_img() {
        return cat_img;
    }

    public void setCat_img(String cat_img) {
        this.cat_img = cat_img;
    }

    @SerializedName("cat_img")
    String cat_img;
}

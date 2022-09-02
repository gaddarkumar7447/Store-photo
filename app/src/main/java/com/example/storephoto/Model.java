package com.example.storephoto;

import android.view.Display;

public class Model {
    private String imageUrlM;

    public Model(){}

    public Model(String imageUrlM) {
        this.imageUrlM = imageUrlM;
    }

    public String getImageUrlM() {
        return imageUrlM;
    }

    public void setImageUrlM(String imageUrlM) {
        this.imageUrlM = imageUrlM;
    }
}
